package com.example.alberto.beastmainproject.services;

import com.example.alberto.beastmainproject.entities.EventPicture;

import java.util.List;

public class EventPhotoService {

    private EventPhotoService() {
    }

    public static class SearchCommunityPhotosRequest {
        public String fireBaseUrl;

        public SearchCommunityPhotosRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchCommunityPhotosResponse {
        public List<EventPicture> communityPhotos;
    }

    public static class SearchBrotherHoodPhotosRequest {
        public String fireBaseUrl;

        public SearchBrotherHoodPhotosRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchBrotherHoodPhotosResponse {
        public List<EventPicture> brotherHoodPhotos;
    }

    public static class SearchSocialPhotosRequest {
        public String fireBaseUrl;

        public SearchSocialPhotosRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchSocialPhotosResponse {
        public List<EventPicture> socialPhotos;
    }

}
