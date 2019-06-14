package com.atguigu.java;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * 类的加载器
 *
 * @author java_fan
 * @create 2019-05-29 13:06
 */
public class ClassLoaderTest {
    @Test
    public void test1() {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
//        sun.misc.Launcher$AppClassLoader@18b4aac2  系统类加载器（对于自定义类）
        System.out.println(classLoader);


        ClassLoader classLoaderParent = classLoader.getParent();
//        sun.misc.Launcher$ExtClassLoader@452b3a41 扩展类加载器
        System.out.println(classLoaderParent);
//           引导类加载器无法获取，引导类加载器主要负责加载java的核心类库，无法加载自定义类


        ClassLoader loader = String.class.getClassLoader();
//        null 无法获取
        System.out.println(loader);

    }

    /**
     * Proprities:用于读取配置文件
     */
    @Test
    public void test2() throws Exception {
        Properties pros = new Properties();
//        读取配置文件的方式一:当前module
//        pros.load(new FileInputStream("jdbc.properties"));

//        方式二:默认路径当前module下的src文件
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);


        String user = pros.getProperty("user");
        String pass = pros.getProperty("pass");
        System.out.println(user);
        System.out.println(pass);


    }


}
