package com.tuandang.manga.leech;



import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by APC on 10/31/2016.
 */

public class FireBaseManga {
    Firebase firebase;
    public FireBaseManga() throws FirebaseException {
        String firebase_baseUrl = "https://manga-439bf.firebaseio.com/";

        // create the firebase
         firebase = new Firebase(firebase_baseUrl);
    }

    public String postChapter(Map<String,Object> chapters) throws JacksonUtilityException, UnsupportedEncodingException, FirebaseException {
        System.out.println("postChapter");

        FirebaseResponse response = firebase.post( "chapters", chapters );
        //System.out.println( "\n\nResult of POST " + response );
        return (String)response.getBody().get("name");
    }

    public String postStory(Story story) throws JacksonUtilityException, UnsupportedEncodingException, FirebaseException {
        FirebaseResponse response = firebase.post( "stories", story.toMap() );
        //System.out.println( "\n\nResult of POST " + response );
        return (String)response.getBody().get("name");
    }
}
