package com.tuandang.manga.leech;

import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by hp 400 on 10/31/2016.
 */
public class StoryLeech {
    private static final String TAG = StoryLeech.class.getSimpleName();
    private String storyname;
    private Connection con;
    private Document doc;
    private Story story = new Story();

    public StoryLeech(String url) {
        try {
            con = Jsoup.connect(url).userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21");
            con.timeout(1800000).ignoreHttpErrors(true).followRedirects(true);
            Response resp = con.execute();

            if (resp.statusCode() == 200) {
                doc = con.get();
                Element title = doc.select(".title-detail").first();
                storyname = title.text();
                story.setTitle(storyname);
                //System.out.print("\nstory title " + title.text());

                Elements genres = doc.select("p.col-xs-8").get(2).select("a");
                String genreString = "";
                for (Element genre : genres) {
                    genreString+=","+genre.text();
                    //System.out.print("\nstory " + storyname + "  genre " + genre.text());
                }
                story.setGenre(genreString);

                Element author = doc.select("p.col-xs-8").first();
                story.setAuthor(author.text());
                //System.out.print("\nstory " + storyname + "  author " + author.text());

                Element status = doc.select("p.col-xs-8").get(1);
                story.setStatus(status.text());
                //System.out.print("\nstory " + storyname + "  status " + status.text());

                getChapterList();
                getStoryDescription();
                getViewCount();
                FireBaseManga fireBaseManga = new FireBaseManga();
                fireBaseManga.postStory(story);
                System.out.print("\n story " + storyname + "  done ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JacksonUtilityException e) {
            e.printStackTrace();
        } catch (FirebaseException e) {
            e.printStackTrace();
        }
    }

    public int getStoryInfoIndex(String name) {
        Elements list = doc.select(".ullist_item li");
        for (int i = 0; i < list.size() - 1; i++) {
            Element element = list.get(i);
            if (element.select(".item1").text().equals(name)) {
                System.out.print("\nindex " + i);
                return i;
            }
        }
        return 0;
    }

    public void getChapterList() {
        Elements list = doc.select(".list-chapter a");
        for (Element element : list) {
            System.out.print("\nstory " + storyname + " chapter name " + element.text());
            //System.out.print("\nchapter link " + element.attr("abs:href"));
            ChaptterLeech chaptter = new ChaptterLeech(story, element.text(), element.attr("abs:href"));
        }
    }

    public void getStoryDescription() {
        Element description = doc.select(".detail-content p").first();
        story.setDescription(description.text());
        //System.out.print("\n story " + storyname + " description " + description.text());
    }

    public void getViewCount() {
        Element view = doc.select(".viewed").first();
        story.setDescription(view.text());
        //System.out.print("\n story " + storyname + "  view " + view.text());
    }
}
