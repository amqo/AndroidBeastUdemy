package com.example.alberto.beastmainproject.inmemory;

import com.example.alberto.beastmainproject.entities.EventPicture;
import com.example.alberto.beastmainproject.infrastructure.BeastApplication;
import com.example.alberto.beastmainproject.services.EventPhotoService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class InMemmoryPictureService extends BaseInMemory {

    public InMemmoryPictureService(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void postCommunityPhotos(EventPhotoService.SearchCommunityPhotosRequest request) {
        EventPhotoService.SearchCommunityPhotosResponse response =
                new EventPhotoService.SearchCommunityPhotosResponse();

        response.communityPhotos = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            response.communityPhotos.add(
                    new EventPicture("http://www.gravatar.com/avatar/" + 50 + i + "?d=identicon"));
        }
        bus.post(response);
    }

    @Subscribe
    public void postBrotherHoodPhotos(EventPhotoService.SearchBrotherHoodPhotosRequest request) {
        EventPhotoService.SearchBrotherHoodPhotosResponse response =
                new EventPhotoService.SearchBrotherHoodPhotosResponse();

        response.brotherHoodPhotos = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            response.brotherHoodPhotos.add(
                    new EventPicture("http://www.gravatar.com/avatar/" + 60 + i + "?d=identicon"));
        }
        bus.post(response);
    }

    @Subscribe
    public void postSocialyPhotos(EventPhotoService.SearchSocialPhotosRequest request) {
        EventPhotoService.SearchSocialPhotosResponse response =
                new EventPhotoService.SearchSocialPhotosResponse();

        response.socialPhotos = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            response.socialPhotos.add(
                    new EventPicture("http://www.gravatar.com/avatar/" + 70 + i + "?d=identicon"));
        }
        bus.post(response);
    }
}
