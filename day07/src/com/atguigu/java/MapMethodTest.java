package com.atguigu.java;

import org.junit.Test;

import java.awt.*;
import java.util.*;

/**
 * Map中常用的方法：
 * <p>
 * put()
 * putAll()
 * remove()
 * clean()
 *
 * @author java_fan
 * @create 2019-05-20 15:40
 */
public class MapMethodTest {
    @Test
    public void test() {
        Map map = new HashMap();

        //添加
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);
        //修改
        map.put("AA", 87);
        System.out.println(map);


        //putAll(map m)
        Map map1 = new HashMap();
        map1.put("CC", 123);
        map1.put("DD", 123);
        map.putAll(map1);
        System.out.println(map);


        //remove(Key key)
        Object value = map.remove("CC");
        System.out.println(value);
        System.out.println(map);
        //clean() 清空数据
        map1.clear();
        System.out.println(map1);

    }

    //元素查询
//    get(Object key)
//    ContainesKey(Object key)

    @Test
    public void test2(){


            Map map = new HashMap();

            //添加
            map.put("AA", 123);
            map.put(45, 123);
            map.put("BB", 56);
//    get(Object key)
        Object value = map.get(45);
        System.out.println(value);
//    ContainesKey(Object key)
        System.out.println(map.containsKey("AA"));//true
//    ContainesValue(Object Value)
        System.out.println(map.containsValue(123));//true

        map.clear();
        System.out.println(map.isEmpty());//true

        Map map1 = new HashMap();
        System.out.println(map.equals(map1)); //true


    }

    //遍历Map

    @Test
    public void test3(){
        Map map = new HashMap();

        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);

        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println();
        Collection values = map.values();
        for (Object obj:values){
            System.out.println(obj);
        }


        System.out.println();
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while(iterator1.hasNext()){

            //entrySet中的元素都是entry
            Map.Entry entry = (Map.Entry) iterator1.next();
            System.out.println(entry.getKey()+"--------------->" + entry.getValue());
        }
    }



}
