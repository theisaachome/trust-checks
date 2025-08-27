package com.highway.trustchecks.service.impl;
import com.highway.trustchecks.api.ApiResponse;
import com.highway.trustchecks.api.IdResponse;
import com.highway.trustchecks.entity.CaseStatus;
import com.highway.trustchecks.mapper.IncidentReportMapper;
import com.highway.trustchecks.dto.IncidentReportDto;
import com.highway.trustchecks.repos.*;
import com.highway.trustchecks.service.IncidentReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class IncidentReportServiceImpl implements IncidentReportService {

    private final ProfileRepository profileRepository;
    private final ReporterRepository reporterRepos;
    private final IncidentReportRepository incidentReportRepos;
    private final IncidentReportMapper incidentReportMapper;
    private final EvidenceRepository evidenceRepos;

    @Transactional
    @Override
    public ApiResponse ingestIncidentReport(IncidentReportDto dto) {
        // Create Reporter
        var entityReporter = incidentReportMapper.mapToReporterEntity(dto.reporter());
        var newReporter= reporterRepos.findByContactEmail(entityReporter.getContactEmail())
                .orElseGet(()->{
                    return reporterRepos.save(entityReporter);
                });
        // social accounts
        var socialMedia = incidentReportMapper
                .mapList(dto.profile().socialMediaHandles(), incidentReportMapper::mapToSocialMediaEntity);

        // create location and save
        var location = incidentReportMapper.mapToLocationEntity(dto.profile().location());


        // 2 Create a Scammer Profile
        var profile = incidentReportMapper.mapToProfileEntity(dto.profile());
        socialMedia.forEach((s)->s.setProfile(profile));
        profile.setSocialMedia(socialMedia);
        profile.setLocation(location);
        var savedProfile= profileRepository.save(profile);



        // 3 Create Case  (Scam Information)
        var incidentEntity = incidentReportMapper.mapToIncidentEntity(dto.incident());


        // 4 financial and setup transaction associated with incident Report
        var paymentEntities = incidentReportMapper.mapList(dto.incident().payments(), incidentReportMapper::mapToPaymentTransaction);
        var profileIdentifierEntities = incidentReportMapper.mapList(dto.incident().payments(),incidentReportMapper::mapToProfileIdentifierEntity);
        profileIdentifierEntities.forEach(identity->identity.setProfile(savedProfile));


        // attachments
        var attachments = incidentReportMapper.mapList(dto.incident().evidence().attachments(), incidentReportMapper::mapToAttachment);
        var caseEvidence = incidentReportMapper.mapToCaseEvidence(dto.incident().evidence());
        attachments.forEach((attachment)-> attachment.setEvidence(caseEvidence));

        evidenceRepos.save(caseEvidence);

        // create case-report
        var incidentReport = incidentReportMapper.mapToIncidentReportEntity(dto);
        incidentReport.setProfile(savedProfile);
        incidentReport.setIncident(incidentEntity);
        incidentReport.setReporter(newReporter);
        incidentReport.setModality("Online");
        incidentReport.setDataSource("User Submission..");
        incidentReport.setStatus(CaseStatus.ACTIVE);


       var savedIncidentReport = incidentReportRepos.save(incidentReport);
       return new ApiResponse(LocalDateTime.now(), 201,new IdResponse(savedIncidentReport.getId()),"New Scam Case Report Created");
    }


}
