package com.highway.trustchecks.service.impl;

import com.highway.trustchecks.api.ApiResponse;
import com.highway.trustchecks.api.IdResponse;
import com.highway.trustchecks.entity.ScamCaseReport;
import com.highway.trustchecks.mapper.CaseReportMapper;
import com.highway.trustchecks.dto.ScamCaseReportDto;
import com.highway.trustchecks.repos.*;
import com.highway.trustchecks.service.ScamReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class ScammerServiceImpl implements ScamReportService {

    private final ScammerDetailsRepos scammerRepos;
    private final CaseReporterRepos reporterRepos;
    private final ScamCaseInformationRepos scamCaseRepos;
    private final ScamCaseReportRepo scamCaseReportRepos;
    private final CaseReportMapper scamCaseReporterMapper;
    private final CaseEvidenceRepo caseEvidenceRepos;

    @Transactional
    @Override
    public ApiResponse ingestScamReport(ScamCaseReportDto dto) {
        // 1 Find or Create Reporter
        var entityReporter = scamCaseReporterMapper.mapToReporter(dto.reporter());
        var newReporter= reporterRepos.findByContactEmail(entityReporter.getContactEmail())
                .orElseGet(()->{
                    return reporterRepos.save(entityReporter);
                });
        // social accounts
        var socialMedia = scamCaseReporterMapper
                .mapList(dto.scammerDetails().socialMediaHandles(),scamCaseReporterMapper::mapToSocialMediaHandle);

        // create location and save
        var location = scamCaseReporterMapper.mapToLocation(dto.scammerDetails().location());


        // 2 Find or create Scammer
        var entityScammer = scamCaseReporterMapper.mapToScammer(dto.scammerDetails());
        socialMedia.forEach((s)->s.setScammer(entityScammer));
        entityScammer.setSocialMediaHandles(socialMedia);
        entityScammer.setLocation(location);

        var newScammer = scammerRepos.findByPhoneNumber(entityScammer.getPhoneNumber())
                .orElseGet(()->scammerRepos.save(entityScammer));



        // 3 Create Case  (Scam Information)
        var scamCaseInformationEntity = scamCaseReporterMapper.mapToScamCaseInformation(dto.scamInformation());


        // 4 financial and setup transaction associated with Scam Case
        var paymentInformation = scamCaseReporterMapper.mapToPaymentInformation(dto.paymentInformation());
        var paymentTransactions = scamCaseReporterMapper.mapList(dto.paymentInformation().transactions(),scamCaseReporterMapper::mapToPaymentTransaction);
        paymentTransactions.forEach(trx-> trx.setPaymentInformation(paymentInformation));
        paymentInformation.setPaymentTransaction(new HashSet<>(paymentTransactions));

        // attachments
        var attachments = scamCaseReporterMapper.mapList(dto.case_evidence().attachments(), scamCaseReporterMapper::mapToAttachment);
        var caseEvidence = scamCaseReporterMapper.mapToCaseEvidence(dto.case_evidence());
        attachments.forEach((attachment)-> attachment.setCaseEvidence(caseEvidence));

        caseEvidenceRepos.save(caseEvidence);

        // create case-report
        var caseReport = scamCaseReporterMapper.mapToScamCaseReport(dto);
        caseReport.setCaseReporter(newReporter);
        caseReport.setScammerDetails(newScammer);
        caseReport.setScamCaseInformation(scamCaseInformationEntity);
        caseReport.setPaymentInformation(paymentInformation);
        caseReport.setCaseEvidence(caseEvidence);


       var newScamCaseReport = scamCaseReportRepos.save(caseReport);
       return new ApiResponse(LocalDateTime.now(), 201,new IdResponse(newScamCaseReport.getScamCaseReportId()),"New Scam Case Report Created");
    }


}
