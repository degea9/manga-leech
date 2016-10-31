package com.tuandang.manga.leech;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Page {
	private Connection con;
	private  Document doc;
	public Page(String url) {
		try {
			con = Jsoup.connect(url).userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21");
			con.timeout(1800000).ignoreHttpErrors(true).followRedirects(true);
			Response resp = con.execute();

			if (resp.statusCode() == 200) {
				  doc = con.get();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void getStoryUrl(){
		long startTime = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(4);
		Elements urls = doc.select(".item");
		for(Element url:urls){
			LeechRunnable worker = new LeechRunnable(url.select("a").first().attr("abs:href"));
			executor.execute(worker);
//			/System.out.println("link story "+url.select("a").first().attr("abs:href"));
		}
		 executor.shutdown();
         // Wait until all threads are finish
		 try {
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 long endTime = System.currentTimeMillis();
		 long processTime = endTime-startTime;
         System.out.println("\nFinished all threads,process Time "+processTime);
	}
}
