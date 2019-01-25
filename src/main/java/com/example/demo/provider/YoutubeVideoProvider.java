package com.example.demo.provider;

import com.example.demo.core.VideoUseCase;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Component
public class YoutubeVideoProvider implements VideoUseCase {

    private static YouTube youtube;
    private static final long NUMBER_OF_VIDEOS_RETURNED = 25;
    public static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    public static final JsonFactory JSON_FACTORY = new JacksonFactory();

    @Value("${youtube.apikey}")
    private String youtubeApikey;


    @Override
    public Mono<SearchListResponse> findVideoByQuery(String query) {

            return Mono.create(sink -> {

                try {

                    youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
                        public void initialize(HttpRequest request) throws IOException {
                        }
                    }).setApplicationName("springboot").build();

                    YouTube.Search.List search = youtube.search().list("id,snippet");
                    String apiKey = youtubeApikey;
                    search.setKey(apiKey);
                    search.setQ(query);
                    search.setType("video");
                    search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/medium/url,snippet/description)");
                    search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);

                    SearchListResponse searchResponse = search.execute();
                    sink.success(searchResponse);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
    }
}
