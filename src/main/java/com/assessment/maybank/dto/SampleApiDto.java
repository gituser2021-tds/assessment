package com.assessment.maybank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SampleApiDto {
    private String type;
    private String setup;
    private String punchline;
    private Long id;
}
