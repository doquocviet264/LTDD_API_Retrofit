package com.example.api_retrofit2;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Category implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("images")
    private String images;
    @SerializedName("description")
    private String description;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getImages() {
        return images;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }


}
