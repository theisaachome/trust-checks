package com.highway.trustchecks.service.impl;
import com.highway.trustchecks.api.ApiResponse;
import com.highway.trustchecks.api.IdResponse;
import com.highway.trustchecks.mapper.IncidentReportMapper;
import com.highway.trustchecks.dto.IncidentReportDto;
import com.highway.trustchecks.repos.*;
import com.highway.trustchecks.service.ScamReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class ScammerServiceImpl implements ScamReportService {

    private final ScammerDetailsRepos scammerRepos;
    private final ReporterRepository reporterRepos;
    private final ScamCaseReportRepo scamCaseReportRepos;
    private final IncidentReportMapper scamCaseReporterMapper;
    private final CaseEvidenceRepo caseEvidenceRepos;

    @Transactional
    @Override
    public ApiResponse ingestScamReport(IncidentReportDto dto) {
        // Create Reporter
        var entityReporter = scamCaseReporterMapper.mapToReporterEntity(dto.reporter());
        var newReporter= reporterRepos.findByContactEmail(entityReporter.getContactEmail())
                .orElseGet(()->{
                    return reporterRepos.save(entityReporter);
                });
        // social accounts
        var socialMedia = scamCaseReporterMapper
                .mapList(dto.scammerDetails().socialMediaHandles(),scamCaseReporterMapper::mapToSocialMediaEntity);

        // create location and save
        var location = scamCaseReporterMapper.mapToLocationEntity(dto.scammerDetails().location());


        // 2 Create a Scammer Profile
        var entityScammer = scamCaseReporterMapper.mapToProfileEntity(dto.scammerDetails());
        socialMedia.forEach((s)->s.setScammer(entityScammer));
        entityScammer.setSocialMedia(socialMedia);
        entityScammer.setLocation(location);

        var savedScammer  = scammerRepos.save(entityScammer);



        // 3 Create Case  (Scam Information)
        var scamCaseInformationEntity = scamCaseReporterMapper.mapToIncidentEntity(dto.scamInformation());


        // 4 financial and setup transaction associated with Scam Case
        var paymentInformation = scamCaseReporterMapper.mapToPaymentInformation(dto.paymentInformation());
        var paymentTransactions = scamCaseReporterMapper.mapList(dto.paymentInformation().transactions(),scamCaseReporterMapper::mapToPaymentTransaction);
        paymentTransactions.forEach(trx-> trx.setPaymentInformation(paymentInformation));
        paymentInformation.setPaymentTransaction(new HashSet<>(paymentTransactions));

        // attachments
        var attachments = scamCaseReporterMapper.mapList(dto.case_evidence().attachments(), scamCaseReporterMapper::mapToAttachment);
        var caseEvidence = scamCaseReporterMapper.mapToCaseEvidence(dto.case_evidence());
        attachments.forEach((attachment)-> attachment.setEvidence(caseEvidence));

        caseEvidenceRepos.save(caseEvidence);

        // create case-report
        var caseReport = scamCaseReporterMapper.mapToIncidentReportEntity(dto);
        caseReport.setCaseReporter(newReporter);
        caseReport.setProfile(newScammer);
        caseReport.setIncident(scamCaseInformationEntity);
        caseReport.setPaymentInformation(paymentInformation);
        caseReport.setEvidence(caseEvidence);


       var newScamCaseReport = scamCaseReportRepos.save(caseReport);
       return new ApiResponse(LocalDateTime.now(), 201,new IdResponse(newScamCaseReport.getScamCaseReportId()),"New Scam Case Report Created");
    }


}
