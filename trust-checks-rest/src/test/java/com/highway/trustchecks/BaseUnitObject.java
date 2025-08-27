package com.highway.trustchecks;
import com.highway.trustchecks.dto.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class BaseUnitObject {


    protected PaymentDto createPaymentInformationDTO() {
        return new PaymentDto(
                                "Bank Transfer", // payment_method
                                "John Doe", // account_holder_name
                                "123456789", // bank_account_number
                                "ABC Bank", // bank_name
                                BigDecimal.valueOf(200), // amount
                "USD",
                                LocalDate.of(2025, 7, 15) // transaction_date

        );
    }
    protected ReporterDto createReporterDTO() {
        return new ReporterDto("Anonymous","optional@example.com","optional");
    }
    protected ProfileDto createProfileDto() {
      return   new ProfileDto(
              "John Doe", // scammer_alias
              "Johnathan Doe", // full_name
              "+65 123456789", // phone_number
              "johndoe@example.com", // email_address
              List.of(
                      new SocialMediaDto(
                              "Facebook",
                              "https://facebook.com/scammer-profile"
                      ),
                      new SocialMediaDto(
                              "Instagram",
                              "https://instagram.com/fakeprofile"
                      )
              ),
              new LocationDto("Singapore", "SG","Yangon"));
    }
    protected static IncidentDto getIncidentDto() {
        var evidenceDto = new EvidenceDto(
                List.of( new AttachmentDto(
                        "screenshot1.png", // file_name
                        "https://example.com/evidence/screenshot1.png", // file_url
                        "image/png" // file_type
                ), new AttachmentDto(
                        "screenshot1.png", // file_name
                        "https://example.com/evidence/screenshot1.png", // file_url
                        "image/png" // file_type
                )),
                "https://example.com/evidence/screenshot1.png"
        );

        var payments = new PaymentDto(
                "Bank Transfer", // payment_method
                "John Doe", // account_holder_name
                "123456789", // bank_account_number
                "ABC Bank", // bank_name
                BigDecimal.valueOf(200), // amount
                "USD",
                LocalDate.of(2025, 7, 15) // transaction_date
        );

        var incidentDto = new IncidentDto(
                "Job Hunting", // case_type
                "Job Hunting",
                LocalDate.of(2025, 7, 15),
                "I was looking for....",
                "I was looking for a remote job and ended up...", // scam_description
                evidenceDto,
                List.of(payments)
        );
        return incidentDto;
    }
}
