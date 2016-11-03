package com.tuandang.manga.leech;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by APC on 11/3/2016.
 */

public class TestMap {
    public static void main(String[] args){
        Map<String,String> test= new HashMap<>();
        test.put("fdsfsdfsd","Chương 1");
        test.put("assssdasd","Chương 2");
        test.put("bghghfggg","Chương 3");
        test.put("aeevcvcxv","Chương 4");
        test.put("cgfhfghfg","Chương 11");
        test.put("gdfgrcvvc","Chương 12");
        test.put("nbmfghfgg","Chương 21");
        test.put("gerggvffc","Chương 22");
        test.put("ujukufghf","Chương 31");
        test.put("zgfgdfgdg","Chương 32");
        test.put("qertreter","Chương 41");

        for (final String key : test.values()) {
            System.out.println(key);
        }

    }
}
