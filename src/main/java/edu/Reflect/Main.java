package edu.Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        try {
            Class<?> someClass2 = Person.class;
            Object instance1 = someClass2.getConstructor().newInstance();
            if(instance1 instanceof Person example){
                System.out.println(example.getAge());
                System.out.println(example.getId());
                System.out.println(example.getName());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
