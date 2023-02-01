package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Kata1MapsAndFilters {
    public static List<String> transformToUpper(List<String> list){
        return list.parallelStream()
                .map(String::toUpperCase)
                .collect(toList());
    }

    public static List<String> filterMoreThanFour(List<String> list){
        return list.parallelStream()
                .filter(s -> s.length() >= 4)
                .collect(toList());
    }

    public static List<String> transformShouldFlattenCollection(List<List<String>> collection) {
        return collection.parallelStream()
                .flatMap( s -> s.stream())
                .collect(toList());
    }
    public static List<Integer> joinTwoLists(List<List<Integer>> list1, List<Integer> list2) {
       return Stream.concat(list1.stream()
                .flatMap(Collection::stream)
                , list2.stream()
        ).collect(toList());

    }

    public static Set<String> getKidNames(List<Person> personList) {
        return
                personList.stream()
                        .filter( p -> p.getAge() < 18)
                        .map(Person::getName)
                        .collect(Collectors.toSet());
    }

    public static List<String> extractNestedMap(Map<String, Map<Integer, String>> nestedMap) {
        return nestedMap.values().stream()
                .flatMap(map -> map.values().stream())
                .collect(Collectors.toList());
    }

    public static List<String> extractMap(Map<Integer, String> map) {
        return  map.values().stream()
                .collect(Collectors.toList());
    }
    public static List<Integer> extractMapKeys(Map<Integer, String> map) {
        return  map.keySet().stream()
                .collect(Collectors.toList());
    }

    public static List<String> extractDoubleNestedMap(Map<String, Map<Integer, String>> nestedMap1,
                                                      Map<String, Map<Integer, String>> nestedMap2) {
                //Step 1: Merge 2 MAPS into SINGLE MAP stream
        return Stream.of(nestedMap1, nestedMap2)
                //step 2: get VALUES from OUTER MAP into a map STREAM
                .flatMap(innerMap -> innerMap.values().stream())
                //step 3: get VALUES from INNER MAP into a map STREAM
                .flatMap(combinedStream -> combinedStream.values().stream())
                //step 4: convert STREAM to LIST
                .collect(Collectors.toList());
    }
    public static List<Integer> extractFromOptional(Optional<Integer> optional) {
        return optional.stream()
                //.flatMap(Stream::of)
                .collect(Collectors.toList());
    }


}
