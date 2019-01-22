package com.example.demo.web;

import com.example.demo.core.BookUseCase;
import com.example.demo.core.dto.ResponseKakaoBook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final BookUseCase bookUseCase;

    public ApiController(BookUseCase bookUseCase) {
        this.bookUseCase = bookUseCase;
    }

    @GetMapping("book")
    public Mono<ResponseKakaoBook> findBookByQuery(){

        List<ResponseKakaoBook.document> documentList = new ArrayList<>();

        return bookUseCase.findBookByQuery("스프링부트");
    }

    @GetMapping("blog")
    public Flux<?> findBlogByQuery(){

        return null;
    }


}
