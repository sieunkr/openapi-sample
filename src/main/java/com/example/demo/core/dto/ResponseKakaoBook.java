package com.example.demo.core.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseKakaoBook {

    private ResponseKakaoBook.Meta meta;
    private List<document> documents;

    public List<document> getDocuments() {
        return documents;
    }

    static class Meta{
        long total_count;
        long pageable_count;
        Boolean is_end;
    }

    public static class document{
        String title;
        String contents;
        String url;
        List<String> authors;
        String publisher;
        String thumbnail;
        //TODO: 더 많은 데이터
    }

}
