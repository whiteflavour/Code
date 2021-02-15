package com.google.collecions_test.list_test.array_list_test;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * 利用反射获取 ArrayList 的容量。———— From CSDN
 */
public class ArrayListCapacity {
    public static int getArrayListCapacity(ArrayList<?> arrayList) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            //获取 elementData 字段
            Field field = arrayListClass.getDeclaredField("elementData");
            //开始访问权限
            field.setAccessible(true);
            //把示例传入get，获取实例字段elementData的值
            Object[] objects = (Object[]) field.get(arrayList);
            //返回当前ArrayList实例的容量值
            return objects.length;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}

