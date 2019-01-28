package com.example.demo.core.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ResponseKakaoTranslation implements Serializable {

    private List<List<String>> translated_text;

}