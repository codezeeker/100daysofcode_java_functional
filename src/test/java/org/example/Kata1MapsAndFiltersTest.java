package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import static java.util.Arrays.asList;
import static org.example.Kata1MapsAndFilters.*;
import static org.junit.jupiter.api.Assertions.*;

class Kata1MapsAndFiltersTest {

    Logger logger = Logger.getAnonymousLogger();


    //exercise 1
    @Test
    public void transformShouldFilterCollection() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("MY", "NAME", "IS", "JOHN", "DOE");
        assertTrue(transformToUpper(collection).equals(expected));
    }
    @Test
    public void testFilterMoreThanFour() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList( "name", "John");
        assertEquals(expected,filterMoreThanFour(collection));
    }

    @Test
    public void testTransformShouldFlattenCollection() {
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        List<String> expected = asList("Viktor", "Farcic", "John", "Doe", "Third");
        assertEquals(expected, transformShouldFlattenCollection(collection));
    }

    @Test
    public void testJoinTwoLists() {

        List<List<Integer>> list1 = asList(asList(1,2), asList(3,4));
        List<Integer> list2 = asList(5,6);
        List<Integer> expected = asList(1,2,3,4,5,6);
        assertEquals(expected, joinTwoLists(list1, list2));
    }

    @Test
    public void getKidNameShouldReturnNamesOfAllKidsFromNorway() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        Person anna = new Person("Anna", 5);
        List<Person> collection = asList(sara, eva, viktor, anna);

        Set<String> kidNames = getKidNames(collection);
        logger.info("kids:::"+kidNames);

        assertTrue(kidNames.containsAll(Set.of("Sara", "Anna")));
        assertFalse(kidNames.equals(Set.of("Viktor", "Eva")));
    }


    @Test
    public void testExtractNestedMap(){
        Map<String, Map<Integer, String>> nestedMap = new HashMap<>();
        nestedMap.put("A", new HashMap<>());
        nestedMap.get("A").put(1, "a");
        nestedMap.get("A").put(2, "b");

        List<String> values = extractNestedMap(nestedMap);

        assertTrue(asList("a","b").equals(values));

    }

    @Test
    public void testExtractMap(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");

        List<String> values = extractMap(map);
        assertTrue(asList("a","b").equals(values));

    }

    @Test
    public void testExtractMapKeys(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");

        List<Integer> values = extractMapKeys(map);
        assertTrue(asList(1,2).equals(values));

    }

    @Test
    public void testExtractDoubleNestedMap() {
        Map<String, Map<Integer, String>> nestedMap1 = new HashMap<>();
        Map<Integer, String> innerMap1 = new HashMap<>();
        innerMap1.put(1, "A");
        innerMap1.put(2, "B");
        nestedMap1.put("Key1", innerMap1);

        Map<String, Map<Integer, String>> nestedMap2 = new HashMap<>();
        Map<Integer, String> innerMap2 = new HashMap<>();
        innerMap2.put(3, "C");
        innerMap2.put(4, "D");
        nestedMap2.put("Key2", innerMap2);

        List<String> values = extractDoubleNestedMap(nestedMap1, nestedMap2);

        assertTrue(asList("A","B","C","D").equals(values));
    }

}