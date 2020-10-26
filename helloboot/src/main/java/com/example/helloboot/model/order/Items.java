package com.example.helloboot.model.order;

/**
 * @author 黄大大的男人
 * 获取Shopee 店铺订单的的数据
 */
public class Items {

	private double weight;
	private String item_name;
	private boolean is_wholesale;
	private String promotion_type;
	private String item_sku;
	private String variation_discounted_price;
	private long variation_id;
	private String variation_name;
	private boolean is_set_item;
	private boolean is_add_on_deal;
	private long item_id;
	private int promotion_id;
	private int add_on_deal_id;
	private int variation_quantity_purchased;
	private String variation_sku;
	private String variation_original_price;
	private boolean is_main_item;
	private String image_url;

	public Items() {}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setIs_wholesale(boolean is_wholesale) {
		this.is_wholesale = is_wholesale;
	}

	public boolean getIs_wholesale() {
		return is_wholesale;
	}

	public void setPromotion_type(String promotion_type) {
		this.promotion_type = promotion_type;
	}

	public String getPromotion_type() {
		return promotion_type;
	}

	public void setItem_sku(String item_sku) {
		this.item_sku = item_sku;
	}

	public String getItem_sku() {
		return item_sku;
	}

	public void setVariation_discounted_price(String variation_discounted_price) {
		this.variation_discounted_price = variation_discounted_price;
	}

	public String getVariation_discounted_price() {
		return variation_discounted_price;
	}

	public void setVariation_id(long variation_id) {
		this.variation_id = variation_id;
	}

	public long getVariation_id() {
		return variation_id;
	}

	public void setVariation_name(String variation_name) {
		this.variation_name = variation_name;
	}

	public String getVariation_name() {
		return variation_name;
	}

	public void setIs_set_item(boolean is_set_item) {
		this.is_set_item = is_set_item;
	}

	public boolean getIs_set_item() {
		return is_set_item;
	}

	public void setIs_add_on_deal(boolean is_add_on_deal) {
		this.is_add_on_deal = is_add_on_deal;
	}

	public boolean getIs_add_on_deal() {
		return is_add_on_deal;
	}

	public void setItem_id(long item_id) {
		this.item_id = item_id;
	}

	public long getItem_id() {
		return item_id;
	}

	public void setPromotion_id(int promotion_id) {
		this.promotion_id = promotion_id;
	}

	public int getPromotion_id() {
		return promotion_id;
	}

	public void setAdd_on_deal_id(int add_on_deal_id) {
		this.add_on_deal_id = add_on_deal_id;
	}

	public int getAdd_on_deal_id() {
		return add_on_deal_id;
	}

	public void setVariation_quantity_purchased(int variation_quantity_purchased) {
		this.variation_quantity_purchased = variation_quantity_purchased;
	}

	public int getVariation_quantity_purchased() {
		return variation_quantity_purchased;
	}

	public void setVariation_sku(String variation_sku) {
		this.variation_sku = variation_sku;
	}

	public String getVariation_sku() {
		return variation_sku;
	}

	public void setVariation_original_price(String variation_original_price) {
		this.variation_original_price = variation_original_price;
	}

	public String getVariation_original_price() {
		return variation_original_price;
	}

	public void setIs_main_item(boolean is_main_item) {
		this.is_main_item = is_main_item;
	}

	public boolean getIs_main_item() {
		return is_main_item;
	}

}