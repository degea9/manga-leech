package manga.android.tuandang.com.manga.data.model;

import java.util.List;
import java.util.Map;

/**
 * Created by APC on 11/4/2016.
 */

public class Chapter {
    public String getStoryUrl() {
        return storyUrl;
    }

    public void setStoryUrl(String storyUrl) {
        this.storyUrl = storyUrl;
    }

    public String getChapterUrl() {
        return chapterUrl;
    }

    public void setChapterUrl(String chapterUrl) {
        this.chapterUrl = chapterUrl;
    }

    public List<String> getChapters() {
        return chapters;
    }

    public void setChapters(List<String> chapters) {
        this.chapters = chapters;
    }

    private String storyUrl;
    private String chapterUrl;
    private List<String> chapters;
}
