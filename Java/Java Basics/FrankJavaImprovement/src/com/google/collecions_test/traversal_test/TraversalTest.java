package com.google.collecions_test.traversal_test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class TraversalTest {
    /**
     * Fori Test.
     *
     * @date 2021-1-15
     * @author Liao
     */
    @Test
    public void forTest() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Tom");
        arrayList.add("Jerry");
        arrayList.add("Foo");
        arrayList.add("Fuck");
        arrayList.add("Jack");

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == "Jerry") {
                arrayList.set(i, "???");
            }
        }
        System.out.println(arrayList);
    }

    /**
     * Foreach Test.
     *
     * @date 2021-1-15
     * @author Liao
     */
    @Test
    public void foreachTest() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Tom");
        arrayList.add("Jerry");
        arrayList.add("Foo");
        arrayList.add("Fuck");
        arrayList.add("Jack");

        // 报 ConcurrentModificationException 异常，增、删报错，但可以修改。
        // 据我的理解，可以使用索引进行操作，但是使用对象来操作就会报错。相当于一边使用这个对象来遍历，一边又使用它来对集合进行操作，这显然线程不安全。
        /*for (String value :
                arrayList) {
            if (value == "Jerry") {
                arrayList.remove(value);
            }
        }
        System.out.println(arrayList);*/

        // 增
        /*for (String value :
                arrayList) {
            if (value == "Jerry") {
                arrayList.add("Bug");
            }
        }
        System.out.println(arrayList);*/

        // IDEA 提示可以使用 Collection.removeIf 代替
        arrayList.removeIf(e -> e.equals("Jerry"));
        System.out.println(arrayList);
    }

    /**
     * Iterator Test.
     *
     * @date 2021-1-15
     * @author Liao
     */
    @Test
    public void iteratorTest() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Tom");
        arrayList.add("Jerry");
        arrayList.add("Foo");
        arrayList.add("Fuck");
        arrayList.add("Jack");

        Iterator<String> iter = arrayList.iterator();
        while (iter.hasNext()) {
            // 不能删除
//            arrayList.remove(iter.next());

            // 解决方案：Iterator 给我们提供了一个 remove 方法。
            // 但是 IDEA 提示，可以使用 Collection.removeIf() 方法替代，这里为 arrayList.removeIf() 。★
            if (iter.next().equals("Jerry")) {
                iter.remove();
            }

            // 可以修改
            /*if (iter.next() == "Jerry") {
                arrayList.set(1, "GGGG");
            }*/
        }
        System.out.println(arrayList);
    }

    /**
     * Iterator Nesting Test.
     *
     * @date 2021-1-15
     * @author Liao
     */
    @Test
    public void iteratorNestingTest() {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Tom");
        arrayList1.add("Jerry");
        arrayList1.add("Foo");
        arrayList1.add("Fuck");
        arrayList1.add("Jack");

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("qnmd");
        arrayList2.add("wc");
        arrayList2.add("awsl");
        arrayList2.add("yyds");
        arrayList2.add("wrng");

        Iterator<String> iter1 = arrayList1.iterator();
        Iterator<String> iter2 = arrayList2.iterator();

        // 在一次循环中多次使用 iter.next() ，当到达 iter1 的末尾元素时，迭代器将悬空，于是报 NoSuchElementException 异常。
        /*while (iter1.hasNext() && iter2.hasNext()) {
            if (iter1.next() != iter2.next()) {
                System.out.println(iter1.next());
            }
        }*/

        // 解决方案：使用 foreach 或者 fori
        /*for (String value1 :
                arrayList1) {
            for (String value2 :
                    arrayList2) {
                if (value1 != value2) {
                    System.out.println(value1);
                }
            }
        }*/

        for (int i = 0; i < arrayList1.size() && i < arrayList2.size(); i++) {
            if (arrayList1.get(i) != arrayList2.get(i)) {
                System.out.println(arrayList1.get(i));
            }
        }
    }

    /**
     * Equals and == Test.
     *
     * @date 2021-1-15
     * @author Liao
     */
    @Test
    public void equalsTest() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("fuck");

        // 返回旧值 ...
        System.out.println(arrayList.set(0, "ff"));
//        System.out.println(arrayList.get(0) == arrayList.set(0, "go"));
    }
}
