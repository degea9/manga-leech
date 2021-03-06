package com.tuandang.manga.leech;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by APC on 10/31/2016.
 */

public class Story {
    private String leechUrl;
    private String title;
    private String author;
    private String status;

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    private String viewCount;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public Map<String, String> getChapters() {
        return chapters;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addChapter(String chaptername,String id) {
        this.chapters.put(chaptername,id);
    }

    private Map<String,String> chapters = new HashMap<>();

    public String getLeechUrl() {
        return leechUrl;
    }

    public void setLeechUrl(String leechUrl) {
        this.leechUrl = leechUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    private String genre;

    public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("title",title);
        map.put("author",author);
        map.put("genre",genre);
        map.put("leechUrl",leechUrl);
        map.put("description",description);
        map.put("viewcount",viewCount);
        map.put("status",status);
        map.put("chapters",chapters);
        return map;
    }
}
