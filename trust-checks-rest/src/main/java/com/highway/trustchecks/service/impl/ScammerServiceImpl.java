package com.highway.trustchecks.service.impl;

import com.highway.trustchecks.mapper.ScamCaseMapper;
import com.highway.trustchecks.dto.ScamReportDto;
import com.highway.trustchecks.entity.Reporter;
import com.highway.trustchecks.entity.ScamCase;
import com.highway.trustchecks.entity.Scammer;
import com.highway.trustchecks.repos.ReporterRepos;
import com.highway.trustchecks.repos.ScamCaseRepos;
import com.highway.trustchecks.repos.ScammerRepos;
import com.highway.trustchecks.service.ScamReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ScammerServiceImpl implements ScamReportService {

    private final ScammerRepos scammerRepos;
    private final ReporterRepos reporterRepos;
    private final ScamCaseRepos scamCaseRepos;
    private final ScamCaseMapper scamCaseReporterMapper;

    @Transactional
    @Override
    public ScamCase ingestScamReport(ScamReportDto dto) {
        // 1 Find or Create Reporter
        var entityReporter = scamCaseReporterMapper.mapToReporter(dto.reporter());
        var newReporter= reporterRepos.findByContactEmail(entityReporter.getContactEmail())
                .orElseGet(()->{
                    return reporterRepos.save(entityReporter);
                });
        var socialMedia = scamCaseReporterMapper
                .mapList(dto.scammerDetails().socialMediaHandles(),scamCaseReporterMapper::mapToSocialMediaHandle);

        // 2 Find or create Scammer
        var entityScammer = scamCaseReporterMapper.mapToScammer(dto.scammerDetails());
        socialMedia.forEach((s)->s.setScammer(entityScammer));
        entityScammer.setSocialMediaHandles(socialMedia);

        var newScammer = scammerRepos.findByPhoneNumber(entityScammer.getPhoneNumber())
                .orElseGet(()->scammerRepos.save(entityScammer));
        // 3 Create Case  (Scam Information)
        var newScamCase = scamCaseReporterMapper.mapToScamCase(dto);
        newScamCase.setReporter(newReporter);
        newScamCase.setScammer(newScammer);


        // 4 financial and setup transaction associated with Scam Case
        var paymentTransactions = scamCaseReporterMapper.mapList(dto.paymentInformation().transactions(),scamCaseReporterMapper::mapToPaymentTransaction);
        paymentTransactions.forEach(trx->trx.setScamCase(newScamCase));


        // 5 evidence setup
        var evidenceFiles = scamCaseReporterMapper.mapList(dto.evidence(),scamCaseReporterMapper::mapToEvidenceFile);
        evidenceFiles.forEach(file->file.setScamCase(newScamCase));

       return scamCaseRepos.save(newScamCase);
    }


}
