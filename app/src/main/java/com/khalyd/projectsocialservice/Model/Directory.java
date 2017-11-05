package com.khalyd.projectsocialservice.Model;



public class Directory  {

    //Files to use

    private String name;
    private String description;
    private String imgProfile;

    //May final String?

    public Directory(String name, String description, String imgProfile) {
        this.name = name;
        this.description = description;
        this.imgProfile = imgProfile;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImgProfile() {
        return imgProfile;
    }

}
