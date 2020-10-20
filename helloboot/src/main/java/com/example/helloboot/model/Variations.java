package com.example.helloboot.model;

/**
 * Copyright 2020 bejson.com 
 */
import java.util.List;
import java.util.Date;

/**
* Auto-generated: 2020-10-20 20:53:29
*
* @author bejson.com (i@bejson.com)
* @website http://www.bejson.com/java2pojo/
*/
public class Variations {

   private String status;
   private double original_price; 			// 原价
   private long update_time;				// 更新时间
   private List<String> set_content;
   private double price;
   private long variation_id;
   private int discount_id;
   private long create_time;
   private Date name;
   private boolean is_set_item;
   private String variation_sku;
   private int reserved_stock;
   private long stock;
   public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

   public void setOriginal_price(double original_price) {
        this.original_price = original_price;
    }
    public double getOriginal_price() {
        return original_price;
    }

   public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }
    public long getUpdate_time() {
        return update_time;
    }

   public void setSet_content(List<String> set_content) {
        this.set_content = set_content;
    }
    public List<String> getSet_content() {
        return set_content;
    }

   public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

   public void setVariation_id(long variation_id) {
        this.variation_id = variation_id;
    }
    public long getVariation_id() {
        return variation_id;
    }

   public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }
    public int getDiscount_id() {
        return discount_id;
    }

   public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }
    public long getCreate_time() {
        return create_time;
    }

   public void setName(Date name) {
        this.name = name;
    }
    public Date getName() {
        return name;
    }

   public void setIs_set_item(boolean is_set_item) {
        this.is_set_item = is_set_item;
    }
    public boolean getIs_set_item() {
        return is_set_item;
    }

   public void setVariation_sku(String variation_sku) {
        this.variation_sku = variation_sku;
    }
    public String getVariation_sku() {
        return variation_sku;
    }

   public void setReserved_stock(int reserved_stock) {
        this.reserved_stock = reserved_stock;
    }
    public int getReserved_stock() {
        return reserved_stock;
    }

   public void setStock(long stock) {
        this.stock = stock;
    }
    public long getStock() {
        return stock;
    }

}