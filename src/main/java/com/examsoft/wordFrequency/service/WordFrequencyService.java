package com.examsoft.wordFrequency.service;

import com.examsoft.wordFrequency.model.WordFrequencyInfo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WordFrequencyService {

    public List<WordFrequencyInfo> getWordFrequency(String str) {
        // iterate through string, parse each word, insert into hashmap
        // if already in hashmap, increment word frequency
        String[] words = str.split("\\W+");
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            if(map.containsKey(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            } else {
                map.put(word, 1);
            }
        }
        return transformMapToPojo(map);
    }

    private List<WordFrequencyInfo> transformMapToPojo(Map<String, Integer> map) {
        List<WordFrequencyInfo> wordFrequencyInfos = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            WordFrequencyInfo wordFrequencyInfo = new WordFrequencyInfo();
            wordFrequencyInfo.setWord(entry.getKey());
            wordFrequencyInfo.setFrequency(entry.getValue());
            wordFrequencyInfos.add(wordFrequencyInfo);
        }
        wordFrequencyInfos.sort(Comparator.comparing(WordFrequencyInfo::getFrequency).reversed());
        return wordFrequencyInfos;

    }
}
