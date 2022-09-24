package com.examsoft.wordFrequency.controller;

import com.examsoft.wordFrequency.model.WordFrequencyInfo;
import com.examsoft.wordFrequency.service.WordFrequencyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/wordfrequency")
@AllArgsConstructor
@Validated
public class WordFrequencyController {
    private final WordFrequencyService wordFrequencyService;

    @GetMapping()
    public ResponseEntity get(@RequestParam(required = false, value = "word") @NotEmpty(message = "The parameter 'word': must not be empty") @Valid String word,
                              HttpServletRequest httpServletRequest) {
        ResponseEntity response = null;
        List<WordFrequencyInfo> result = wordFrequencyService.getWordFrequency(word);
        if(CollectionUtils.isEmpty(result)) {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            response = ResponseEntity.ok(result);
        }
        return response;
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(ConstraintViolationException exception) {
        // handle all javax failed validation
        String errorMessage = new ArrayList<>(exception.getConstraintViolations()).get(0).getMessage();
        return new ResponseEntity<>(errorMessage, null, HttpStatus.BAD_REQUEST);
    }

}
