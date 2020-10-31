package com.example.helloboot.model.item;

import java.util.List;
/**
 * Auto-generated: 2020-10-20 20:53:29
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Item {

    private String logistics;
    private double original_price;
    private double package_width;
    private int cmt_count;
    private double weight;
    private long shopid;
    private String currency;
    private long create_time;
    private int likes;
    private String images;
    private List<String> tenures;   		// 这个参数待定，不知道有什么用
    private boolean is_2tier_item;
    private int days_to_ship;
    private double package_length;
    private int reserved_stock;
    private long stock;
    private String status;
    private long update_time;
    private String description;
    private int views;
    private double price;
    private double sales;
    private int discount_id;
    private long item_id;
    private String wholesales;
    private String condition;
    private int package_height;
    private String name;
    private int rating_star;
    private String item_sku;
    private String variations;
    private String tier_variation;
    private String size_chart;
    private boolean is_pre_order;
    private boolean has_variation;
    private String attributes;
    private int category_id;
    
    public Item() {}
    
	public String getTier_variation() {
		return tier_variation;
	}
	public void setTier_variation(String tier_variation) {
		this.tier_variation = tier_variation;
	}
	
	public void setLogistics(String logistics) {
         this.logistics = logistics;
     }
     public String getLogistics() {
         return logistics;
     }

    public void setOriginal_price(double original_price) {
         this.original_price = original_price;
     }
     public double getOriginal_price() {
         return original_price;
     }

    public void setPackage_width(double package_width) {
         this.package_width = package_width;
     }
     public double getPackage_width() {
         return package_width;
     }

    public void setCmt_count(int cmt_count) {
         this.cmt_count = cmt_count;
     }
     public int getCmt_count() {
         return cmt_count;
     }

    public void setWeight(double weight) {
         this.weight = weight;
     }
     public double getWeight() {
         return weight;
     }

    public void setShopid(long shopid) {
         this.shopid = shopid;
     }
     public long getShopid() {
         return shopid;
     }

    public void setCurrency(String currency) {
         this.currency = currency;
     }
     public String getCurrency() {
         return currency;
     }

    public void setCreate_time(long create_time) {
         this.create_time = create_time;
     }
     public long getCreate_time() {
         return create_time;
     }

    public void setLikes(int likes) {
         this.likes = likes;
     }
     public int getLikes() {
         return likes;
     }
     public void setImages(String images) {
         this.images = images;
     }
     public String getImages() {
         return images;
     }

    public void setTenures(List<String> tenures) {
         this.tenures = tenures;
     }
     public List<String> getTenures() {
         return tenures;
     }

    public void setIs_2tier_item(boolean is_2tier_item) {
         this.is_2tier_item = is_2tier_item;
     }
     public boolean getIs_2tier_item() {
         return is_2tier_item;
     }

    public void setDays_to_ship(int days_to_ship) {
         this.days_to_ship = days_to_ship;
     }
     public int getDays_to_ship() {
         return days_to_ship;
     }

    public void setPackage_length(double package_length) {
         this.package_length = package_length;
     }
     public double getPackage_length() {
         return package_length;
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

    public void setStatus(String status) {
         this.status = status;
     }
     public String getStatus() {
         return status;
     }

    public void setUpdate_time(long update_time) {
         this.update_time = update_time;
     }
     public long getUpdate_time() {
         return update_time;
     }

    public void setDescription(String description) {
         this.description = description;
     }
     public String getDescription() {
         return description;
     }

    public void setViews(int views) {
         this.views = views;
     }
     public int getViews() {
         return views;
     }

    public void setPrice(double price) {
         this.price = price;
     }
     public double getPrice() {
         return price;
     }

    public void setSales(double sales) {
         this.sales = sales;
     }
     public double getSales() {
         return sales;
     }

    public void setDiscount_id(int discount_id) {
         this.discount_id = discount_id;
     }
     public int getDiscount_id() {
         return discount_id;
     }

    public void setItem_id(long item_id) {
         this.item_id = item_id;
     }
     public long getItem_id() {
         return item_id;
     }

    public void setWholesales(String wholesales) {
         this.wholesales = wholesales;
     }
     public String getWholesales() {
         return wholesales;
     }

    public void setCondition(String condition) {
         this.condition = condition;
     }
     public String getCondition() {
         return condition;
     }

    public void setPackage_height(int package_height) {
         this.package_height = package_height;
     }
     public int getPackage_height() {
         return package_height;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setRating_star(int rating_star) {
         this.rating_star = rating_star;
     }
     public int getRating_star() {
         return rating_star;
     }

    public void setItem_sku(String item_sku) {
         this.item_sku = item_sku;
     }
     public String getItem_sku() {
         return item_sku;
     }

    public void setVariations(String variations) {
         this.variations = variations;
     }
     public String getVariations() {
         return variations;
     }

    public void setSize_chart(String size_chart) {
         this.size_chart = size_chart;
     }
     public String getSize_chart() {
         return size_chart;
     }

    public void setIs_pre_order(boolean is_pre_order) {
         this.is_pre_order = is_pre_order;
     }
     public boolean getIs_pre_order() {
         return is_pre_order;
     }

    public void setHas_variation(boolean has_variation) {
         this.has_variation = has_variation;
     }
     public boolean getHas_variation() {
         return has_variation;
     }

    public void setAttributes(String attributes) {
         this.attributes = attributes;
     }
     public String getAttributes() {
         return attributes;
     }

    public void setCategory_id(int category_id) {
         this.category_id = category_id;
     }
     public int getCategory_id() {
         return category_id;
     }
}