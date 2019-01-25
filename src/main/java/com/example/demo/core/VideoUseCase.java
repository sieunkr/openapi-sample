package com.example.demo.core;


import com.google.api.services.youtube.model.SearchListResponse;
import reactor.core.publisher.Mono;

public interface VideoUseCase {
    Mono<SearchListResponse> findVideoByQuery(String query);
}
