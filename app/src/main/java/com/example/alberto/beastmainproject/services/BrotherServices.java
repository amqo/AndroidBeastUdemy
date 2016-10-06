package com.example.alberto.beastmainproject.services;

import com.example.alberto.beastmainproject.entities.Brother;

import java.util.List;

public class BrotherServices {

    public BrotherServices() {
    }

    public static class SearchBrotherRequest {
        public String fireBaseUrl;

        public SearchBrotherRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchBrotherResponse {
        public List<Brother> brothers;
    }
}
