/* 
 * All rights Reserved, Designed By 学海无涯，苦作舟
 * 2017年6月4日 上午11:31:29
 */
package com.zhong.reflex;

import java.io.Serializable;

/** 
 * @author:CODY 2017年6月4日
 */
public class User implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private Integer id;
    
    private String name;
    
    public String adress;

    
    /**
     * Integer
     */
    public Integer getId() {
        return id;
    }

    
    /**
     * Integer
     */
    public void setId(Integer id) {
        this.id = id;
    }

    
    /**
     * String
     */
    public String getName() {
        return name;
    }

    
    /**
     * String
     */
    public void setName(String name) {
        this.name = name;
    }
    
    public void sleep(String name){
        
        System.err.println(name + "   在睡觉");
    }
    
}
