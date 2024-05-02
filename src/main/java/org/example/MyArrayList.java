package org.example;

import java.util.Arrays;

public class MyArrayList {
    private static int defaultCapacity = 10;
    private Object[] elements;
    private int count;

    public MyArrayList() {
        this.elements =  new Object[defaultCapacity];
        this.count = 0;
    }


    private void increaseCapacity(){

        Object[] temp = elements;
        int newCapacity = defaultCapacity*2;
        defaultCapacity = newCapacity;
        elements =  new Object[newCapacity];
        for (int i = 0; i < temp.length; i++) {
            elements[i] = temp[i];

        }
    }
    private void trimToSize(){
        defaultCapacity = 10;
        elements = new Object[defaultCapacity];

    }
    public int size(){
        int counterElements = 0;
        for (int i = 0; i < elements.length; i++) {
            if(elements[i]!=null){
                counterElements++;
            }
        }
        return counterElements;
    }
    public void addElements(Object o){
        this.elements[count] = o;
        count++;
        if(count == elements.length){
            increaseCapacity();
        }
    }

    public void addArrElements(Object[] objects){
        for (int i = 0; i < objects.length; i++) {
            if(count == elements.length){
                increaseCapacity();
            }
            this.elements[count] =  objects[i];
            count ++;
        }
    }

    public void addToIndex(Object o, int index){
        if (this.elements[index]==null){
            this.elements[index]=o;
        } else if (this.elements[index]!=null && this.elements[index+1]==null) {
            this.elements[index+1]=elements[index];
            this.elements[index]=o;
        }else{
            Object[] swap = new Object[defaultCapacity];
            for (int i = index; i < elements.length ; i++) {
                swap[i] = elements[i];
            }
            this.elements[index]=o;
            for (int i = index + 1; i < elements.length; i++) {
                this.elements[i]=swap[i-1];
            }
        }
    }
    public void removeToIndex(int index){
        Object [] remove = new Object[defaultCapacity];
        for (int i = index + 1; i < elements.length; i++) {
            remove[i] = this.elements[i];
        }
        for (int i = index; i < elements.length - 1; i++) {
            this.elements[i] = remove[i + 1];
        }
    }

    public void removeAllElements(){
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        trimToSize();
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    public Object get(int index) {
        return elements[index];
    }

}