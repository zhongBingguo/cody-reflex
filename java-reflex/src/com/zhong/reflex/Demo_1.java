/* 
 * All rights Reserved, Designed By 学海无涯，苦作舟
 * 2017年6月4日 上午11:12:29
 */
package com.zhong.reflex;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

/** 
 *  反射的作用：
 *  1.可以创建对象
 *  2.可以得到对象里任何信息:类名，成员变量，方法，父类，实现的接口
 *  3.调用某一个方法,设置属性
 *  4.生成动态代理。
 * @author:CODY 2017年6月4日
 */
public class Demo_1 {
   

    /** 
     * 可以创建对象
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    
    @Test
    public void getObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> cls = Class.forName("com.zhong.reflex.User");
         User demo_1 = (User)cls.newInstance();
         System.out.println("类名： " + cls.getName());
         System.err.println(demo_1);
    }

    
    
    /** 
     *可以获取对象里的name，method等任何信息
     */
    @Test
    public void getObjectInfo() {
        User user = new User();
        //获取对象name
        String name = user.getClass().getName();
        System.out.println("对象name： " + name);
            
        //获取对象的方法
        Method[] methods = user.getClass().getMethods();
        for(Method str : methods){
            System.out.println("对象方法: " + str.getName());
        }
    }
    
    /** 
    * 获取一个对象的父类与实现的接口
    * 获取父类：getSuperclass()
    * 获取实现接口：getInterfaces();
    * @throws ClassNotFoundException
    */
    @Test
    public void getObjectSuperInfo() throws ClassNotFoundException {
       Class<?> cls = Class.forName("com.zhong.reflex.User");
       Class<?> superclass = cls.getSuperclass();
       System.out.println("父类为： " + superclass.getName());
       
       Class<?>[] interfaces = cls.getInterfaces();
       for(Class c : interfaces){
           System.out.println("实现的接口 ： " + c.getName());
       }
   }
    
    /**
     * 通过反射机制调用某个类的方法
     * @throws ClassNotFoundException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     */
    @Test
    public void callMethod() throws Exception{
        Class<?> cls = Class.forName("com.zhong.reflex.User");
        Method method = cls.getMethod("sleep", String.class);
        method.invoke(cls.newInstance(), "张三");
    }
    
    @Test
    public void getMethod() throws Exception{
        Class<?> cls = Class.forName("com.zhong.reflex.User");
        Method[] methods = cls.getMethods();
        
        Field[] fields = cls.getDeclaredFields ();
        for(Field f : fields){
            System.err.println(f);
        }
        System.out.println(1);
    }
    
    /**
     * 获取所有的属性：getDeclaredFields();
     * @throws Exception
     */
    @Test
    public void setValue() throws Exception{
        Class<?> cls = Class.forName("com.zhong.reflex.User");
        Object object = cls.newInstance();
        Field filed = cls.getDeclaredField("name");
        filed.setAccessible(true);
        filed.set(object, "zhangsan");
        System.out.println(filed.get(object));
    }
}
