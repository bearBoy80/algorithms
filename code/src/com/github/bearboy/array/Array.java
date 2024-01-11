package com.github.bearboy.array;

import java.util.Arrays;

public class Array {
    private int capacity;

    private int size;
    private Object[] objects;

    public Array(int size) {
        this.capacity = size;
        this.size = 0;
        this.objects = new Object[size];
    }

    public boolean add(Object obj){
        if (size == capacity){
            System.out.println("数组已满");
            return false;
        }
        objects[size++] = obj;
        return true;
    }
    public boolean add(int index,Object object){
        if (size == capacity){
            System.out.println("数组已满");
            return false;
        }
        if (index< 0 || index > size){
            System.out.println("插入位置不合法");
            return false;
        }
        //从尾部开始循环移动数组位置
        for (int i=size;i> index;i--){
            objects[i] = objects[i-1];
        }
        objects[index] =object;
        return true;
    }

    @Override
    public String toString() {
        return "Array{" +
                "capacity=" + capacity +
                ", size=" + size +
                ", objects=" + Arrays.toString(objects) +
                '}';
    }

    public static void main(String[] args) {
        Array array = new Array(10);
        array.add(1);
        array.add(2);
        array.add(1,12);
        System.out.println(array);
    }
}
