package edu.Test;

import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        boolean b = (!(true) && !(false));
//        System.out.println(b);
//        System.out.println(1+2+"3");
//        Stack<Character> stack = new Stack<>();
//        stack.push('A');
//        stack.push('B');
//        stack.push('C');
//        for(int i = 0; i < 3; i++){
//            System.out.println(stack.pop());
//        }
//        var map = new HashMap<MyKey, Integer>();
//        MyKey key = new MyKey();
//        map.put(new MyKey(), 1);
//        map.put(new MyKey(), 2);
//        map.put(new MyKey(), 3);
//        map.put(null,4);
//        System.out.println("map " + map);
        String text = null;
        //System.out.println(text.length());
        System.out.println(10/0);
    }
}


class MyKey{
    @Override
    public int hashCode(){
        return 1;
    }

    @Override
    public boolean equals (Object obj){
        return false;
    }

    @Override
    public String toString(){
        return "MyKey{}";
    }
}

//@RestController
//public class SampleController{
//    @RequestMapping("/map")
//    public String map(@RequestParam("bar") String foo,@RequestParam("foo") String bar ){
//        return bar + foo;
//    }
//}
//
//@RestController
//public class SampleController{
//    @RequestMapping("/map")
//    public String map(@RequestBody SampleObject sampleObject ){
//        return sampleObject.b + sampleObject.c;
//    }
//}

class SampleObject{
    public String b;
    public String c;
}