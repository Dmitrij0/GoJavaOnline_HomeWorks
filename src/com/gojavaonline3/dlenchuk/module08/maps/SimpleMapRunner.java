package com.gojavaonline3.dlenchuk.module08.maps;

import java.util.Map;

public class SimpleMapRunner {
    public static void main(String[] args) {
        Map<String, Integer> map = new SimpleHashMap<>();
        System.out.println("map.size() = " + map.size());
        System.out.println("map.put(\"Dima\", 39) = " + map.put("Dima", 39));
        System.out.println("map.size() = " + map.size());
        System.out.println("map.put(\"1111\", 1111) = " + map.put("1111", 1111));
        System.out.println("map.size() = " + map.size());
        System.out.println("map.put(null, 40) = " + map.put(null, 40));
        System.out.println("map.size() = " + map.size());
        System.out.println("map.put(null, null) = " + map.put(null, null));
        System.out.println("map.size() = " + map.size());
        System.out.println("map.get(\"Dima\") = " + map.get("Dima"));
        System.out.println("map.get(\"1111\") = " + map.get("1111"));
        System.out.println("map.get(null) = " + map.get(null));
        System.out.println("map.containsValue(1111) = " + map.containsValue(1111));
        System.out.println("map.containsValue(null) = " + map.containsValue(null));
        System.out.println("map.containsValue(0) = " + map.containsValue(0));
        System.out.println("map.remove(\"1111\") = " + map.remove("1111"));
        System.out.println("map.size() = " + map.size());
        System.out.println("map.get(\"1111\") = " + map.get("1111"));

        System.out.println("map.size() = " + map.size());

        for (int i = 0; i < 1000; i++) {
            map.put(String.valueOf(i), i);
        }

        System.out.println("map.size() = " + map.size());

//        System.out.println(map);
    }
}
