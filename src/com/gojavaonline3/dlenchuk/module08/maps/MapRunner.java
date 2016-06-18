package com.gojavaonline3.dlenchuk.module08.maps;

import java.util.Map;
import java.util.TreeMap;

public class MapRunner {

    public static void main(String[] args) {
        Map<String, Integer> hashMap = new SimpleHashMap<>();

        System.out.println("hashMap.size() == " + hashMap.size());
        System.out.println("hashMap.isEmpty() == " + hashMap.isEmpty());

        System.out.println();
        System.out.println("hashMap.put(\"70\", 71) == " + hashMap.put("70", 71));
        System.out.println("hashMap.put(\"30\", 31) == " + hashMap.put("30", 31));
        System.out.println("hashMap.put(\"50\", 51) == " + hashMap.put("50", 51));
        System.out.println("hashMap.put(\"20\", 21) == " + hashMap.put("20", 21));
        System.out.println("hashMap.put(\"30\", 32) == " + hashMap.put("30", 32));
        System.out.println("hashMap.put(\"10\", 11) == " + hashMap.put("10", 11));
        System.out.println("hashMap.put(\"60\", 61) == " + hashMap.put("60", 61));

        System.out.println();
        System.out.println(hashMap);

        System.out.println();
        System.out.println("hashMap.size() == " + hashMap.size());
        System.out.println("hashMap.isEmpty() == " + hashMap.isEmpty());

        System.out.println();
        System.out.println("hashMap.find(\"30\") == " + ((SimpleHashMap<String, Integer>) hashMap).find("30"));
        System.out.println("hashMap.find(\"333\") == " + ((SimpleHashMap<String, Integer>)hashMap).find("333"));

        System.out.println();
        System.out.println("hashMap.containsKey(\"30\") == " + hashMap.containsKey("30"));
        System.out.println("hashMap.containsKey(30) == " + hashMap.containsKey(30));
        System.out.println("hashMap.containsKey(\"333\") == " + hashMap.containsKey("333"));

        System.out.println();
        System.out.println("hashMap.containsValue(32) == " + hashMap.containsValue(32));
        System.out.println("hashMap.containsValue(\"32\") == " + hashMap.containsValue("32"));
        System.out.println("hashMap.containsValue(333) == " + hashMap.containsValue(333));

        System.out.println();
        System.out.println("hashMap.get(\"30\") == " + hashMap.get("30"));
        System.out.println("hashMap.get(30) == " + hashMap.get(30));
        System.out.println("hashMap.get(\"333\") == " + hashMap.get("333"));

        System.out.println();
        System.out.println("hashMap.remove(\"30\") == " + hashMap.remove("30"));
        System.out.println("hashMap.remove(\"50\") == " + hashMap.remove("50"));
        System.out.println("hashMap.remove(30) == " + hashMap.remove(30));
        System.out.println("hashMap.remove(\"333\") == " + hashMap.remove("333"));

        System.out.println();
        System.out.println(hashMap);

        Map<String, Integer> subMap = new TreeMap<>();

        System.out.println();
        System.out.println("subMap.put(\"30\", 31) == " + subMap.put("30", 31));
        System.out.println("subMap.put(\"50\", 51) == " + subMap.put("50", 51));

        hashMap.putAll(subMap);
        System.out.println("hashMap.putAll(subMap) => " + hashMap);

        System.out.println();
        System.out.println("hashMap.keySet() == " + hashMap.keySet());
        System.out.println("hashMap.values() == " + hashMap.values());
        System.out.println("hashMap.entrySet() == " + hashMap.entrySet());

        hashMap.clear();
        System.out.println("hashMap.clear() => " + hashMap);

    }

}
