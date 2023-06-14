package com.mock.assessment.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class EmployeeJsonTest {

    @Autowired
    private JacksonTester<EmployeeDto> jackson;

    private JsonContent<EmployeeDto> asJson;

    @Nested
    class Serialization {

        @Nested
        class PositiveScenarios {
            @BeforeEach
            void setup() throws IOException {
                EmployeeDto dto = new EmployeeDto(1, "Libu");
                asJson = jackson.write(dto);
            }

            @Test
            void checkEmployeeName() {
                assertThat(asJson).extractingJsonPathStringValue("name").isEqualTo("Libu");
            }

            @Test
            void checkEmployeeNameIsNotEmpty() {
                assertThat(asJson).extractingJsonPathStringValue("name").isNotBlank();
            }
        }
    }
}
