package com.tuandang.manga.leech;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Chaptter {
	private Connection con;
	private Document doc;

	public Chaptter(String storyname, String chaptername, String url) {
		try {
			con = Jsoup
					.connect(url)
					.userAgent(
							"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21");
			con.maxBodySize(0).timeout(1800000).ignoreHttpErrors(true).followRedirects(true);
			Response resp = con.execute();

			if (resp.statusCode() == 200) {
				doc = con.get();
				System.out.println("test "+doc.html());
//				Elements images = doc.select(".reading-detail img");
//				for (Element image : images) {
//					System.out.println("story " + storyname + " " + chaptername
//							+ " " + image.attr("src"));
//				}
//
//				System.out.println("story " + storyname + " " + chaptername
//						+ " done");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
