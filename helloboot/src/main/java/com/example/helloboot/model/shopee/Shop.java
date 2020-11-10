package com.example.helloboot.model.shopee;

public class Shop
{
    private int shop_id;

    private String shop_name;

    private String country;

    private String shop_description;

    private String videos;

    private String images;

    private int disable_make_offer;

    private boolean enable_display_unitno;

    private int item_limit;

    private String request_id;

    private String status;

    private int installment_status;

    private String sip_a_shops;

    private boolean is_cb;

    private int non_pre_order_dts;

    private long auth_time;

    private long expire_time;

    public Shop() {}
	public void setShop_id(int shop_id){
        this.shop_id = shop_id;
    }
    public int getShop_id(){
        return this.shop_id;
    }
    public void setShop_name(String shop_name){
        this.shop_name = shop_name;
    }
    public String getShop_name(){
        return this.shop_name;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }
    public void setShop_description(String shop_description){
        this.shop_description = shop_description;
    }
    public String getShop_description(){
        return this.shop_description;
    }
    public void setVideos(String videos){
        this.videos = videos;
    }
    public String getVideos(){
        return this.videos;
    }
    public void setImages(String images){
        this.images = images;
    }
    public String getImages(){
        return this.images;
    }
    public void setDisable_make_offer(int disable_make_offer){
        this.disable_make_offer = disable_make_offer;
    }
    public int getDisable_make_offer(){
        return this.disable_make_offer;
    }
    public void setEnable_display_unitno(boolean enable_display_unitno){
        this.enable_display_unitno = enable_display_unitno;
    }
    public boolean getEnable_display_unitno(){
        return this.enable_display_unitno;
    }
    public void setItem_limit(int item_limit){
        this.item_limit = item_limit;
    }
    public int getItem_limit(){
        return this.item_limit;
    }
    public void setRequest_id(String request_id){
        this.request_id = request_id;
    }
    public String getRequest_id(){
        return this.request_id;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setInstallment_status(int installment_status){
        this.installment_status = installment_status;
    }
    public int getInstallment_status(){
        return this.installment_status;
    }
    public void setSip_a_shops(String sip_a_shops){
        this.sip_a_shops = sip_a_shops;
    }
    public String getSip_a_shops(){
        return this.sip_a_shops;
    }
    public void setIs_cb(boolean is_cb){
        this.is_cb = is_cb;
    }
    public boolean getIs_cb(){
        return this.is_cb;
    }
    public void setNon_pre_order_dts(int non_pre_order_dts){
        this.non_pre_order_dts = non_pre_order_dts;
    }
    public int getNon_pre_order_dts(){
        return this.non_pre_order_dts;
    }
    public void setAuth_time(long auth_time){
        this.auth_time = auth_time;
    }
    public long getAuth_time(){
        return this.auth_time;
    }
    public void setExpire_time(long expire_time){
        this.expire_time = expire_time;
    }
    public long getExpire_time(){
        return this.expire_time;
    }
}
