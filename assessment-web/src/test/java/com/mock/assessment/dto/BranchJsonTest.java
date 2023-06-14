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
public class BranchJsonTest {

    @Autowired
    private JacksonTester<BranchDto> jackson;

    private JsonContent<BranchDto> asJson;

    @Nested
    class Serialization {

        @Nested
        class PositiveScenarios {
            @BeforeEach
            void setup() throws IOException {
                BranchDto dto = new BranchDto(1, "CSE");
                asJson = jackson.write(dto);
            }

            @Test
            void checkBranchNameIsCSE() {
                assertThat(asJson).extractingJsonPathStringValue("name").isEqualTo("CSE");
            }

            @Test
            void checkBranchNameIsNotEmpty() {
                assertThat(asJson).extractingJsonPathStringValue("name").isNotBlank();
            }
        }
    }
}
