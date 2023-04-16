package com.mock.assessment.model.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

@JsonTest
public class BranchJsonTest {

  @Autowired private JacksonTester<BranchDto> jackson;

  private JsonContent<BranchDto> asJson;

  @Nested
  class Serialization {

    @Nested
    class HappyPath {
      @BeforeEach
      void setup() throws IOException {
        BranchDto dto = new BranchDto(1, "j.w.t.1");

        asJson = jackson.write(dto);
      }

      @Test
      void accessTokenIsMapped() {
        assertThat(asJson).extractingJsonPathStringValue("name").isEqualTo("j.w.t.2");
      }
    }
  }
}
