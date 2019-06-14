package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的方法结构
 */
public class MethodTest {

    @Test
    public void test(){
        Class clazz = Person.class;


//        getMethods()：获取当前类和父类public的方法
        Method[] m = clazz.getMethods();
        for (Method method : m) {
            System.out.println(method);
        }
        System.out.println("**********************");


//        getDeclaredMethods():只获取当前类的声明的所有方法（不包含父类）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }

    }

    /**
     *
     * z注解
     * 权限修饰符 返回值类型 方法名（参数类型一 形参名一。。。。。。。。） throw XxxException
     */
    @Test
    public void test2(){
        //获取注解
        Class clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation a :annotations){
                System.out.println(a);
            }
//            权限修饰符
            System.out.println(Modifier.toString(method.getModifiers()));
//            返回值类型
            Class type = method.getReturnType();
            System.out.println(type.getName() + "\t");
            //        方法名
            System.out.print(method.getName());
            System.out.print("(");
//            形参列表
            Class[] parameterTypes = method.getParameterTypes();
            if(!(parameterTypes == null && parameterTypes.length == 0)){
                for (int i = 0; i < parameterTypes.length; i++) {
                    System.out.print(parameterTypes[i].getName()+"args_"+i);
                }
            }

//            获取异常

            Class[] exceptionTypes = method.getExceptionTypes();
        }

    }


}
