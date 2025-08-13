package com.highway.trustchecks.mapper;
import com.highway.trustchecks.dto.*;
import com.highway.trustchecks.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class CaseReportMapper {


    public ScamCaseReport mapToScamCaseReport(ScamCaseReportDto dto){
         if (dto ==null) return null;
         return   ScamCaseReport.builder()
                 .status(dto.status())
                 .dataSource(dto.dataSource())
                 .notes(dto.notes())
                 .build();
    }
    public CaseReporter mapToReporter(ReporterDTO dto) {
          if (dto == null) return null;
            return CaseReporter.builder()
                   .name(dto.name())
                    .contactEmail(dto.contactEmail())
                    .contactPhone(dto.contactPhone())
                    .build();
    }
    public ScammerDetails mapToScammer(ScammerDetailsDTO dto){
        if (dto == null) return null;

        var scammer = ScammerDetails.builder()
                .scammerAlias(dto.scammerAlias())
                .fullName(dto.fullName())
                .phoneNumber(dto.phoneNumber())
                .emailAddress(dto.emailAddress())
                .build();
        return scammer;
    }
    public Location mapToLocation(LocationDTO dto) {
        if (dto == null) return null;
        return Location.builder()
                .cityName(dto.cityName())
                .countryName(dto.countryName())
                .countryCode(dto.countryCode())
                .build();
    }

    public ScamCaseInformation mapToScamCaseInformation(ScamCaseInformationDTO dto){
        if(dto == null) return null;
        var scamCase = ScamCaseInformation.builder()
                .caseType(dto.caseType())
                .scamDescription(dto.scamDescription())
                .scamCategory(dto.scamCategory())
                .modality(dto.modality())
                .dateOfIncident(dto.dateOfIncident())
                .build();
        return scamCase;
    }
    public CaseEvidence mapToCaseEvidence(CaseEvidenceDTO dto){
        if(dto == null) return null;
        var evidenceFile = CaseEvidence.builder()
                .link(dto.link())
                .build();
        return evidenceFile;
    }
    public Attachment mapToAttachment(AttachmentDTO dto){
        if(dto == null) return null;
        return Attachment.builder()
                .fileName(dto.fileName())
                .fileUrl(dto.fileUrl())
                .fileType(dto.fileType())
                .build();
    }
    public SocialMediaHandle mapToSocialMediaHandle(SocialMediaHandleDTO dto){
        return  SocialMediaHandle.builder()
                .platform(dto.platform())
                .profileUrl(dto.profileUrl())
                .build();
    }

    public  PaymentInformation mapToPaymentInformation(PaymentInformationDTO dto){
        return PaymentInformation.builder()
                .currency(dto.currency())
                .totalAmountLost(dto.totalAmountLost())
                .build();
    }

    public PaymentTransaction mapToPaymentTransaction(TransactionDTO dto){
        if(dto == null) return null;
        var paymentTransaction = PaymentTransaction.builder()
                .paymentMethod(dto.paymentMethod())
                .accountHolderName(dto.accountHolderName())
                .bankAccountNumber(dto.bankAccountNumber())
                .bankName(dto.bankName())
                .transactionDate(dto.transactionDate())
                .build();
        return paymentTransaction;
    }
    public  <T,R>List<R> mapList(List<T> source, Function<T,R> mapper){
        return  source==null? List.of():source.stream().map(mapper).toList();
    }
}
