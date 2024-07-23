package com.lqt.duynguyenhairsalon.Model;

public class VideoYouTube {
    private String idVideo;
    private String thumbnail;
    private String title;

    public VideoYouTube(String idVideo, String thumbnail, String title) {
        this.idVideo = idVideo;
        this.thumbnail = thumbnail;
        this.title = title;
    }

    public String getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(String idVideo) {
        this.idVideo = idVideo;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
