package com.tuandang.manga.leech;

import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ChaptterLeech {
	private Connection con;
	private Document doc;

	public ChaptterLeech(Story story, String chaptername, String url) {
		try {
			con = Jsoup
					.connect(url)
					.userAgent(
							"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21");
			con.maxBodySize(0).timeout(1800000).ignoreHttpErrors(true).followRedirects(true);
			Response resp = con.execute();

			if (resp.statusCode() == 200) {
				Map<String,Object> listImages = new LinkedHashMap<String, Object>();
				doc = con.get();
				//System.out.println("test "+doc.html());
				Elements images = doc.select(".reading-detail img");
				for (int i=0;i<images.size();i++) {
					Element image = images.get(i);
					listImages.put(""+i,image.attr("src"));
					System.out.println("story " + "test " + " " + chaptername
							+ " " + image.attr("src"));
				}

				//listImages.put("http://4.bp.blogspot.com","1");

				FireBaseManga fireBaseManga = new FireBaseManga();
				String chapterId = fireBaseManga.postChapter(listImages);
				story.addChapter(chaptername,chapterId);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JacksonUtilityException e) {
			e.printStackTrace();
		} catch (FirebaseException e) {
			e.printStackTrace();
		}
	}
}
