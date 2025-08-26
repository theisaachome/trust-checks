package com.highway.trustchecks.mapper;
import com.highway.trustchecks.dto.*;
import com.highway.trustchecks.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class IncidentReportMapper {



    public Profile mapToProfileEntity(ProfileDto dto){
        if (dto == null) return null;

        var profileEntity = Profile.builder()
                .fullName(dto.fullName())
                .phoneNumber(dto.phoneNumber())
                .emailAddress(dto.emailAddress())
                .alias(dto.alias())
                .build();
        return profileEntity;
    }


    public Reporter mapToReporterEntity(ReporterDto dto) {
        if (dto == null) return null;
        return Reporter.builder()
                .nickName(dto.name())
                .contactEmail(dto.contactEmail())
                .contactPhone(dto.contactPhone())
                .build();
    }
    public  ProfileIdentifier mapToProfileIdentifierEntity(PaymentDto dto){
        var metadata = dto.bankName() + dto.accountHolderName();
        var profileIdentifierEntity = ProfileIdentifier.builder()
                .type(dto.paymentMethod())
                .value(dto.account_number())
                .normalizedValue(dto.account_number())
                .metadata(metadata)
                .accountHolderName(dto.accountHolderName())
                .accountNumber(dto.account_number())
                .bankName(dto.bankName())
                .build();
        return profileIdentifierEntity;

    }
    public IncidentReport mapToIncidentReportEntity(IncidentReportDto dto){
         if (dto ==null) return null;
         return   IncidentReport.builder()
                 .dataSource("User Submission")
                 .notes(dto.notes())
                 .declarationConsent(dto.declarationConsent())
                 .modality(dto.modality())
                 .build();
    }
    public Location mapToLocationEntity(LocationDto dto) {
        if (dto == null) return null;
        return Location.builder()
                .cityName(dto.cityName())
                .countryName(dto.countryName())
                .countryCode(dto.countryCode())
                .build();
    }

    public Incident mapToIncidentEntity(IncidentDto dto){
        if(dto == null) return null;
        var incidentEntity = Incident.builder()
                .type(dto.type())
                .category(dto.category())
                .shortStory(dto.short_story())
                .longStory(dto.details_story())
                .dateOfIncident(dto.dateOfIncident())
                .build();
        return incidentEntity;
    }
    public Evidence mapToCaseEvidence(EvidenceDto dto){
        if(dto == null) return null;
        var evidenceFile = Evidence.builder()
                .link(dto.link())
                .build();
        return evidenceFile;
    }
    public Attachment mapToAttachment(AttachmentDto dto){
        if(dto == null) return null;
        return Attachment.builder()
                .fileName(dto.fileName())
                .fileUrl(dto.fileUrl())
                .fileType(dto.fileType())
                .build();
    }
    public SocialMedia mapToSocialMediaEntity(SocialMediaDto dto){
        return  SocialMedia.builder()
                .platform(dto.platform())
                .profileUrl(dto.profileUrl())
                .build();
    }


    public Payment mapToPaymentTransaction(PaymentDto dto){
        if(dto == null) return null;
        var paymentTransaction = Payment.builder()
                .paymentMethod(dto.paymentMethod())
                .amount(dto.amount())
                .currency(dto.currency())
                .transactionDate(dto.transactionDate())
                .build();
        return paymentTransaction;
    }
    public  <T,R>List<R> mapList(List<T> source, Function<T,R> mapper){
        return  source==null? List.of():source.stream().map(mapper).toList();
    }
}
