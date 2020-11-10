package com.example.helloboot.model.shopee;


import com.alibaba.fastjson.JSONArray;

/**
 * 	该Shop用于本地系统查询
 * @author Administrator
 *
 */
public class ShopLocal {

	private int shop_id;

    private String shop_name;

    private String country;

    private String shop_description;

    private JSONArray videos;

    private JSONArray images;

    private int disable_make_offer;

    private boolean enable_display_unitno;

    private int item_limit;

    private String status;

    private int installment_status;

    private JSONArray sip_a_shops;

    private boolean is_cb;

    private int non_pre_order_dts;

    private int auth_time;

    private int expire_time;

	public ShopLocal() {}

	public int getShop_id() {
		return shop_id;
	}

	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getShop_description() {
		return shop_description;
	}

	public void setShop_description(String shop_description) {
		this.shop_description = shop_description;
	}

	public JSONArray getVideos() {
		return videos;
	}

	public void setVideos(String videos) {
		this.videos = JSONArray.parseArray(videos);
	}

	public JSONArray getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = JSONArray.parseArray(images);
	}

	public int getDisable_make_offer() {
		return disable_make_offer;
	}

	public void setDisable_make_offer(int disable_make_offer) {
		this.disable_make_offer = disable_make_offer;
	}

	public boolean isEnable_display_unitno() {
		return enable_display_unitno;
	}

	public void setEnable_display_unitno(boolean enable_display_unitno) {
		this.enable_display_unitno = enable_display_unitno;
	}

	public int getItem_limit() {
		return item_limit;
	}

	public void setItem_limit(int item_limit) {
		this.item_limit = item_limit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getInstallment_status() {
		return installment_status;
	}

	public void setInstallment_status(int installment_status) {
		this.installment_status = installment_status;
	}

	public JSONArray getSip_a_shops() {
		return sip_a_shops;
	}

	public void setSip_a_shops(String sip_a_shops) {
		this.sip_a_shops = JSONArray.parseArray(sip_a_shops);
	}

	public boolean isIs_cb() {
		return is_cb;
	}

	public void setIs_cb(boolean is_cb) {
		this.is_cb = is_cb;
	}

	public int getNon_pre_order_dts() {
		return non_pre_order_dts;
	}

	public void setNon_pre_order_dts(int non_pre_order_dts) {
		this.non_pre_order_dts = non_pre_order_dts;
	}

	public int getAuth_time() {
		return auth_time;
	}

	public void setAuth_time(int auth_time) {
		this.auth_time = auth_time;
	}

	public int getExpire_time() {
		return expire_time;
	}

	public void setExpire_time(int expire_time) {
		this.expire_time = expire_time;
	}
    
    
}
