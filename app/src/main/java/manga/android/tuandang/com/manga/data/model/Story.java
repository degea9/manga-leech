package manga.android.tuandang.com.manga.data.model;

/**
 * Created by APC on 11/1/2016.
 */

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

    public void setChapters(Map<String, String> chapters) {
        this.chapters = chapters;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    private String thumbnail;

    public int getViewcount() {
        return viewCount;
    }

    public void setViewcount(int viewcount) {
        this.viewCount = viewcount;
    }

    private int viewCount;

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

//    public Map<String,Object> toMap(){
//        Map<String,Object> map = new HashMap<>();
//        map.put("title",title);
//        map.put("author",author);
//        map.put("genre",genre);
//        map.put("leechUrl",leechUrl);
//        map.put("description",description);
//        map.put("viewcount",viewcount);
//        map.put("status",status);
//        map.put("chapters",chapters);
//        return map;
//    }

    public void printChapterList(){
        if(chapters!=null){
            for (String name: chapters.keySet()){
                String key =name.toString();
                String value = chapters.get(name).toString();
                System.out.println(key + " " + value);

            }
        }
    }
}

