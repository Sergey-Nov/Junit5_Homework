package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;


class MyArrayListTest {
    MyArrayList myArrayList = new MyArrayList();

    @BeforeEach
    void init() {
        myArrayList.addElements(1);
        myArrayList.addElements(2);
        myArrayList.addElements(3);

    }


    @Test
    void addElements() {
        int currentSize = myArrayList.size();
        int expectedSize = currentSize + 1;
        myArrayList.addElements("BY");
        assertNotEquals(expectedSize,currentSize);
    }


    @Test
    void addArrElements() {
        int currentSize = myArrayList.size();
        String [] str = {"BY","RU","EU"};
        int expectedSize = currentSize + str.length;
        myArrayList.addArrElements(str);
        System.out.println(myArrayList);
        assertEquals(expectedSize,currentSize + str.length);
    }

    @ParameterizedTest
    @MethodSource("provideValueFactory")
    void addToIndex(int index,int element) {
        MyArrayList expectedList = new MyArrayList();
        MyArrayList initialList = new MyArrayList();
        expectedList.addToIndex(element,index);
        initialList.addToIndex(element,index);
        assertEquals(expectedList.get(index),initialList.get(index));
    }

    public static Stream<Arguments> provideValueFactory() {
        return Stream.of(Arguments.of(1,4),
                         Arguments.of(4,1));
    }

    @ParameterizedTest
    @MethodSource("provideValueFactory")
    void removeToIndex(int index) {
       MyArrayList expectedList = new MyArrayList();
       MyArrayList initialList = new MyArrayList();
       expectedList.removeToIndex(index);
       initialList.removeToIndex(index);
       assertEquals(expectedList.get(index),initialList.get(index));
    }

    @ParameterizedTest
    @MethodSource("provideValueFactoryForRemove")
    void removeAllElements(int index) {
        MyArrayList testRemoveAllList = new MyArrayList();
        testRemoveAllList.removeAllElements();
        assertNull(testRemoveAllList.get(index));
    }
    public static Stream<Arguments> provideValueFactoryForRemove() {
        return Stream.of(Arguments.of(1),
                Arguments.of(4),
                Arguments.of(3));
    }
}