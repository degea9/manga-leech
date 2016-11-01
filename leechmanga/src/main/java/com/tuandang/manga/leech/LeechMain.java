package com.tuandang.manga.leech;

public class LeechMain {
    public static void main(String[] args){
    	//Page page = new Page("http://www.nettruyen.com/tim-truyen?status=-1&sort=5");
    	//page.getStoryUrl();
        System.out.print("LeechMain");
        StoryLeech storyLeech = new StoryLeech("http://www.nettruyen.com/truyen-tranh/001");
        //ChaptterLeech chaptter = new ChaptterLeech(null,"chap4","http://www.nettruyen.com/truyen-tranh/007-pha-an/chap-4/144878");
    }
}
