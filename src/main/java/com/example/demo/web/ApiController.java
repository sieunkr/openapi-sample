package com.example.demo.web;

import com.example.demo.core.BlogUseCase;
import com.example.demo.core.BookUseCase;
import com.example.demo.core.VideoUseCase;
import com.example.demo.core.dto.ResponseKakaoBook;
import com.example.demo.core.dto.ResponseNaverBlog;
import com.google.api.services.youtube.model.SearchListResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final BookUseCase bookUseCase;
    private final BlogUseCase blogUseCase;
    private final VideoUseCase videoUseCase;

    public ApiController(BookUseCase bookUseCase, BlogUseCase blogUseCase, VideoUseCase videoUseCase) {
        this.bookUseCase = bookUseCase;
        this.blogUseCase = blogUseCase;
        this.videoUseCase = videoUseCase;
    }

    @GetMapping("book")
    public Mono<ResponseKakaoBook> findBookByQuery(){

        List<ResponseKakaoBook.document> documentList = new ArrayList<>();

        return bookUseCase.findBookByQuery("스프링부트");
    }

    @GetMapping("blog")
    public Mono<ResponseNaverBlog> findBlogByQuery(){

        return blogUseCase.findBlogByQuery("스프링부트");
    }

    @GetMapping("video")
    public Mono<SearchListResponse> findVideoByQuery(){

        return videoUseCase.findVideoByQuery("spring boot");
    }


}
