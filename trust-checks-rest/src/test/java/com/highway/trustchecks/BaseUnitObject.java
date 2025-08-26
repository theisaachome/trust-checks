package com.highway.trustchecks;

import com.highway.trustchecks.dto.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class BaseUnitObject {


    protected PaymentInformationDTO createPaymentInformationDTO() {
        return new PaymentInformationDTO(
                BigDecimal.valueOf(200), // total_amount_lost
                "SGD", // currency
                List.of(
                        new PaymentDto(
                                "Bank Transfer", // payment_method
                                "John Doe", // account_holder_name
                                "123456789", // bank_account_number
                                "ABC Bank", // bank_name
                                BigDecimal.valueOf(200), // amount
                                LocalDate.of(2025, 7, 15) // transaction_date
                        )
                )
        );
    }
    protected ReporterDto createReporterDTO() {
        return new ReporterDto("Anonymous","optional@example.com","optional");
    }
    protected ProfileDto createScammerDetailsDTO() {
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
}
