package com.examsoft.wordFrequency.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WordFrequencyInfo {
    private String word;
    private Integer frequency;
}
