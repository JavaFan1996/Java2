package com.atguigu.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

/**
 * @author java_fan
 * @create 2019-05-20 12:49
 */
public class CollectionTest {


    @Test
    public void test(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(789);
        coll.add(434);


        coll.forEach(System.out::println);


    }

}
