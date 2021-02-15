package com.google.collecions_test.list_test.array_list_test;

import org.junit.Test;

import java.util.*;

public class ArrayListTest {
    /**
     * 没有类型限定，不安全，不建议使用。
     */
    @Test
    public void arrayListTest() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Go fuck");
        arrayList.add('c');
        arrayList.add(1343242);
        arrayList.add(3.414);

        System.out.println(arrayList);
    }

    /**
     * 有类型限定。
     */
    @Test
    public void parameterizedArrayListTest() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Go");
        arrayList.add("Fuck");
        arrayList.add("yourself");
        arrayList.add("!!");

        System.out.println(arrayList);
    }

    @Test
    public void objectArrayListTest() {
        ArrayList<Jetty> arrayList = new ArrayList<>();
        arrayList.add(new Jetty("Goodbye", 2020));
        arrayList.add(new Jetty("Hello", 2021));

        System.out.println(arrayList);
    }

    @Test
    public void arrayListAddTest() {
        ArrayList<Integer> arrayListA = new ArrayList<>();
        arrayListA.add(1);
        arrayListA.add(2);
        arrayListA.add(3);
//        arrayListA.add(6, 4);

        ArrayList<Integer> arrayListB = new ArrayList<>();
        arrayListB.add(4);
        arrayListB.add(5);

        // addAll();
        arrayListA.addAll(1, arrayListB);
        System.out.println(arrayListA);

        // toArray();
        Object[] array = arrayListA.toArray();
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    @Test
    public void arrayListClearTest() {
        ArrayList<Integer> arrayListA = new ArrayList<>();
        arrayListA.add(1);
        arrayListA.add(2);
        arrayListA.add(3);

        ArrayList<Integer> arrayListB = new ArrayList<>();
        arrayListB.add(4);
        arrayListB.add(5);

        // contains();
        System.out.println(arrayListA.contains(5));

        // ensureCapacity();
        arrayListA.ensureCapacity(11);
        System.out.println(arrayListA.size());

        // clear();
        System.out.println(arrayListA);
        arrayListA.clear();
        System.out.println(arrayListA);

        // foreach
        for (Integer value :
                arrayListB) {
            System.out.print(++value + " ");
        }
        System.out.println();

        // get();
        for (int i = 0; i < arrayListB.size(); i++) {
            int arrayBValue = arrayListB.get(i);
            System.out.print(++arrayBValue + " ");
        }
        System.out.println();
    }

    /**
     * Some tests about Collections.copy
     *
     * @date 2020-12-20
     */
    @Test
    public void copyTest() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(0);
        arrayList1.add(0);
        arrayList1.add(0);


        System.out.println(arrayList1);
        // dest.size()必须比src.size()大或相等。
        Collections.copy(arrayList, arrayList1);
        System.out.println(arrayList);

        arrayList.addAll(arrayList1);
        System.out.println(arrayList);
        System.out.println(Collections.nCopies(1, arrayList1));
    }

    /**
     * Some tests about Collections.enumeration
     *
     * @date 2020-12-20
     */
    @Test
    public void enumerationTest() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        Enumeration<Integer> enumeration = Collections.enumeration(arrayList);
        while (enumeration.hasMoreElements()) {
            System.out.print(enumeration.nextElement());
            System.out.print(' ');
        }
//        System.out.println(Collections.list(enumeration));
    }

    /**
     * Some tests about enum type.
     *
     * @date 2020-12-20
     */
    @Test
    public void enumTest() {
        e[] enumArray = e.values();
        for (e value :
                enumArray) {
            System.out.print(value);
            System.out.print(' ');
        }
    }

    enum e {
        Google, Microsoft, Amazon;
    }

    /**
     * indexOf lastIndexOf isEmpty remove removeAll removeRange replaceAll retainAll（取交集并替换） set size Collections Collections.reverse subList(左闭右开) trimToSize 等方法的测试
     */
    @Test
    public void someTest() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
//        arrayList.add(4);
//        arrayList.add(5);

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(4);
        arrayList1.add(1);

        Collections.swap(arrayList, 0, 2);
        System.out.println(arrayList);
    }
}
