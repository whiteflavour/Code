package com.google.collecions_test.set_map_test;

import org.junit.Test;

import java.util.stream.Stream;

public class StreamTest {
    /**
     * A test of Stream peek() and forEach().
     * @author Liao
     * @date 2021-1-5
     */
    @Test
    public void streamTest() {
        Stream<String> stream = Stream.of("Go", "Fuck", "Yourself", "!!!");
        // 无输出，中间性操作。
        stream.peek(e -> System.out.print(e + " "));

        // 有输出，终结性操作。
//        stream.forEach(e -> System.out.print(e + " "));
    }

    /**
     * A test of Stream peek() and map().
     * @author Liao
     * @date 2021-1-5
     */
    @Test
    public void streamPeekMapTest() {
        Stream<String> stream = Stream.of("我", "日", "你", "哥", "...");
//        stream.peek(e -> System.out.print(e + " ")).forEach(e -> System.out.print(e + " "));
        stream.peek(e -> System.out.print("Peek: " + e + " ")).map(e -> e.indexOf(e)).peek(e -> System.out.print("Map: " + e + " ")).forEach(e -> System.out.print(e + " "));
    }
}
