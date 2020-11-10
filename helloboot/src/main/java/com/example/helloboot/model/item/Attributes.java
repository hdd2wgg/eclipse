package com.example.helloboot.model.item;


/**
* 商品属性
* 撒旦法阿斯蒂芬asdfsadfasdfn nl1 ssf 你是不是傻逼l L L iI1
*/
public class Attributes {

   private String attribute_name; 	// 属性名称
   private boolean is_mandatory;	// 是否是强制
   private int attribute_id;		// 属性ID
   private String attribute_value;	// 属性结果
   private String attribute_type;	// 属性类型
   public void setAttribute_name(String attribute_name) {
        this.attribute_name = attribute_name;
    }
    public String getAttribute_name() {
        return attribute_name;
    }

   public void setIs_mandatory(boolean is_mandatory) {
        this.is_mandatory = is_mandatory;
    }
    public boolean getIs_mandatory() {
        return is_mandatory;
    }

   public void setAttribute_id(int attribute_id) {
        this.attribute_id = attribute_id;
    }
    public int getAttribute_id() {
        return attribute_id;
    }

   public void setAttribute_value(String attribute_value) {
        this.attribute_value = attribute_value;
    }
    public String getAttribute_value() {
        return attribute_value;
    }

   public void setAttribute_type(String attribute_type) {
        this.attribute_type = attribute_type;
    }
    public String getAttribute_type() {
        return attribute_type;
    }

}
