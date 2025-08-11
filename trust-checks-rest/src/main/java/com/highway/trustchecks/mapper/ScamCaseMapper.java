package com.highway.trustchecks.mapper;
import com.highway.trustchecks.dto.*;
import com.highway.trustchecks.entity.*;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Component
public class ScamCaseMapper {


    public Reporter mapToReporter(ReporterDTO dto) {
          if (dto == null) return null;
            return Reporter.builder()
                   .name(dto.name())
                    .contactEmail(dto.contactEmail())
                    .contactPhone(dto.contactPhone())
                    .build();
    }
    public Scammer mapToScammer(ScammerDetailsDTO dto){
        if (dto == null) return null;

        var scammer =Scammer.builder()
                .scammerAlias(dto.scammerAlias())
                .fullName(dto.fullName())
                .phoneNumber(dto.phoneNumber())
                .emailAddress(dto.emailAddress())
                .cityName(dto.city().cityName())
                .countryName(dto.country().countryName())
                .countryCode(dto.country().countryCode())
                .build();
        return scammer;
    }

    public ScamCase mapToScamCase(ScamReportDto dto){
        if(dto == null) return null;
        var scamCase = ScamCase.builder()
                .scamCategory(dto.scamInformation().scamCategory())
                .scamDescription(dto.scamInformation().scamDescription())
                .caseType(dto.scamInformation().caseType())
                .notes(dto.notes())
                .dataSource(dto.dataSource())
                .dateOfIncident(dto.scamInformation().dateOfIncident())
                .reportedAt(LocalDateTime.now())
                .status(CaseStatus.ACTIVE)
                .modality(dto.scamInformation().modality())
                .reportedAt(LocalDateTime.now())
                .build();
        return scamCase;
    }
    public EvidenceFile mapToEvidenceFile(AttachmentDTO dto){
        if(dto == null) return null;
        var evidenceFile =EvidenceFile.builder()
                .fileName(dto.fileName())
                .fileType(dto.fileType())
                .fileUrl(dto.fileUrl())
                .build();
        return evidenceFile;
    }
    public SocialMediaHandle mapToSocialMediaHandle(SocialMediaHandleDTO dto){
        return  SocialMediaHandle.builder()
                .platform(dto.platform())
                .profileUrl(dto.profileUrl())
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
