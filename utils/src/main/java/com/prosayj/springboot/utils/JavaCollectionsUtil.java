package com.prosayj.springboot.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/8/14 下午 06:52
 * @since 1.0.0
 */
public class JavaCollectionsUtil {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("2018-09-20", "hha");
        map.put("2017-09-20", "hha");
        map.put("2017-09-29", "hha");
        map.put("2018-09-21", "hha");
        System.out.println(map);

        System.out.println(mapSortByKey(map, true));
        System.out.println(mapSortByKey(map, false));
    }


    /**
     * map value排序
     *
     * @param map
     * @param asc
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> mapSortByValue(Map<K, V> map, boolean asc) {
        Map<K, V> result = new LinkedHashMap<>();
        Stream<Map.Entry<K, V>> stream = map.entrySet().stream();
        if (asc) //升序
        {
            //stream.sorted(Comparator.comparing(e -> e.getValue()))
            stream.sorted(Map.Entry.<K, V>comparingByValue())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        } else //降序
        {
            //stream.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            stream.sorted(Map.Entry.<K, V>comparingByValue().reversed())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        }
        return result;
    }

    /**
     * map key排序
     *
     * @param map
     * @param asc
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K extends Comparable<? super K>, V> Map<K, V> mapSortByKey(Map<K, V> map, boolean asc) {
        Map<K, V> result = new LinkedHashMap<>();
        Stream<Map.Entry<K, V>> stream = map.entrySet().stream();
        if (asc) {
            stream.sorted(Map.Entry.<K, V>comparingByKey())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        } else {
            stream.sorted(Map.Entry.<K, V>comparingByKey().reversed())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        }
        return result;
    }
}
