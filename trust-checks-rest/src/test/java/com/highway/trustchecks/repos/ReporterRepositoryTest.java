package com.highway.trustchecks.repos;

import com.highway.trustchecks.BaseUnitObject;
import com.highway.trustchecks.entity.Reporter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ActiveProfiles("test")
class ReporterRepositoryTest extends BaseUnitObject {

    @Autowired
    ReporterRepository reporterRepository;


    @Test
    void test(){
        var newReporter = Reporter.builder()
                        .contactPhone("123456789")
                                .contactEmail("example@gmail.com")
                                        .nickName("anonymous")
                                                .build();
        reporterRepository.save(newReporter);
        assertNotNull(newReporter.getId());
    }

}
