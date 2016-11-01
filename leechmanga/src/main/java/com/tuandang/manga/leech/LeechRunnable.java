package com.tuandang.manga.leech;

public class LeechRunnable implements Runnable{
	private String storyUrl;
	
	public LeechRunnable(String storyUrl){
		this.storyUrl = storyUrl;
	}

	@Override
	public void run() {
		StoryLeech story = new StoryLeech(storyUrl);
		
	}

}
