package com.highway.trustchecks.service;

import com.highway.trustchecks.BaseUnitObject;
import com.highway.trustchecks.dto.*;
import com.highway.trustchecks.entity.CaseStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ScamReportServiceTest  extends BaseUnitObject {

    @Autowired
    private ScamReportService scamReportService;
    ScamCaseReportDto scamReportDto;
    @BeforeEach
    void init(){
        var reporter = new ReporterDTO("Anonymous","optional@example.com","optional");
        var scammerDetails =new ScammerDetailsDTO(
                "John Doe", // scammer_alias
                "Johnathan Doe", // full_name
                "+65 123456789", // phone_number
                "johndoe@example.com", // email_address
                List.of(
                        new SocialMediaHandleDTO(
                                "Facebook",
                                "https://facebook.com/scammer-profile"
                        ),
                        new SocialMediaHandleDTO(
                                "Instagram",
                                "https://instagram.com/fakeprofile"
                        )
                ),
                new LocationDTO("Singapore", "SG","Yangon"));

        var scamInformation = new ScamCaseInformationDTO(
                "Job Hunting", // case_type
                "I was looking for a remote job and ended up...", // scam_description
                "Employment Scam", // scam_category
                "Online", // modality
                LocalDate.of(2025, 7, 15) // date_of_incident
        );
        var paymentInformation = new PaymentInformationDTO(
                BigDecimal.valueOf(200), // total_amount_lost
                "SGD", // currency
                List.of(
                        new TransactionDTO(
                                "Bank Transfer", // payment_method
                                "John Doe", // account_holder_name
                                "123456789", // bank_account_number
                                "ABC Bank", // bank_name
                                BigDecimal.valueOf(200), // amount
                                LocalDate.of(2025, 7, 15) // transaction_date
                        )
                )
        );
        var caseEvidence = new CaseEvidenceDTO(
                List.of( new AttachmentDTO(
                        "screenshot1.png", // file_name
                        "https://example.com/evidence/screenshot1.png", // file_url
                        "image/png" // file_type
                ), new AttachmentDTO(
                        "screenshot1.png", // file_name
                        "https://example.com/evidence/screenshot1.png", // file_url
                        "image/png" // file_type
                )),
                "https://example.com/evidence/screenshot1.png"
        );

        scamReportDto = new ScamCaseReportDto(
                reporter,
                scammerDetails,
                scamInformation,
                paymentInformation,
                caseEvidence,
                CaseStatus.ACTIVE,
                List.of("Job hunting","Online"),
                "User Submition",
                "Reporting Scammer recently"
        );
    }

    @Test
    void shouldCreatePaymentInformationDto(){
        createPaymentInformationDTO();
    }

    @Test
    void test(){
        var result = scamReportService.ingestScamReport(scamReportDto);
        assertNotNull(result);
    }
}
