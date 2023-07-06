package junit5Test;

import linstener.Listener;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.hamcrest.Matcher.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(Listener.class)  // you can use it in disabled enabled class to test disabled
public class AssertionsTest {
    /*
     * assert string int bool object list set
     * */

    @Test
    void assertEqualsTest() {
        assertEquals("firstString", "secondString");
    }

    @Test
    void assertEqualsListTest() {
        List<String> expectedValues = Arrays.asList("firstString", "secondString ", "thirdString");
        List<String> actualValues = Arrays.asList("firstString", "secondString ", "thirdString");
        assertEquals(actualValues, expectedValues);
    }

    @Test
    void assertEqualsArrayTest() {
        int[] expectedResult = {1, 3, 5};
        int[] actualResult = {1, 3, 5};
        assertArrayEquals(actualResult,expectedResult,"error ");
    }

// in case of expecting Throw Exception
    @Test
    void assertThrowExceptionTest() {
        assertThrows(NullPointerException.class,null);
    }

    @Test
    void assertAllTest () {
        assertAll(
                ()->assertEquals("firstString","secondString","values not equals"),
                ()->assertTrue(false),
                ()->assertThrows(NullPointerException.class,null)
        );
    }

          /*     Hamcrest*/

    @Test
    void assertThatMapTest() {
        Map<String,Integer> theMap = new HashMap<>();
        theMap.put("firstKey",1);
        theMap.put("secondKey",2);
        theMap.put("thirdKey",3);
        theMap.put("fourthKey",4);

        assertThat(theMap, Matchers.hasValue(2));
        assertThat(theMap,Matchers.hasKey("secondKey"));
    }

    @Test
    void assertThatListTest() {
        List<String> list = Arrays.asList("first","second","third");
        assertThat(list,Matchers.hasItems("third","second"));
        assertThat(list,Matchers.hasItem("second"));
    }

    @Test
    void assertThatAnyOFTest() {
        List<String> list = Arrays.asList("first","second","third");
        assertThat(list,Matchers.anyOf(Matchers.hasItem("first"),
                                       Matchers.hasItem("second!")));

    }

    @Test
    void assertThatContainsAnyOrderTest() {
        List<String> list = Arrays.asList("first","second","third");
        assertThat(list,Matchers.containsInAnyOrder("first","second","third"));
    }
}
