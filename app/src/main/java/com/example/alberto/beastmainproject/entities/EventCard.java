package com.example.alberto.beastmainproject.entities;

public class EventCard {

    private int eventId;
    private String eventName;
    private String eventDescription;
    private String eventImage;
    protected boolean isVideo;
    private String youtubeEnding;

    public EventCard(int eventId, String eventName, String eventDescription, String eventImage,
                     boolean isVideo, String youtubeEnding) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventImage = eventImage;
        this.isVideo = isVideo;
        this.youtubeEnding = youtubeEnding;
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getEventImage() {
        return eventImage;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public String getYoutubeEnding() {
        return youtubeEnding;
    }
}
