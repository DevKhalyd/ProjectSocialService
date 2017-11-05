package com.khalyd.projectsocialservice.Model;



public class NotificationsModel {

    private String urlImg;
    private String title;
    private String subdescription;


    public NotificationsModel(String urlImg, String title, String subdescription) {
        this.urlImg = urlImg;
        this.title = title;
        this.subdescription = subdescription;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public String getTitle1() {
        return title;
    }

    public String getSubdescription() {
        return subdescription;
    }
}
