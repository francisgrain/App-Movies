package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OmdbService {

    @Autowired
    private RestTemplate restTemplate;

    private final String apiKey = "";
    private final String urlTemplate = "";

    public String getMovieDetails(String title) {
        return restTemplate.getForObject(urlTemplate, String.class, title, apiKey);
    }
}
