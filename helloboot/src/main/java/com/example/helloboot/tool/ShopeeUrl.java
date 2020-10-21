package com.example.helloboot.tool;

public class ShopeeUrl {
	
	/**
	 * 测试链接的host 
	 */
	public static final String test_host = "https://partner.uat.shopeemobile.com/";
	
	/**
	 *  生产环境的host
	 */
	public static final String live_host = "https://partner.shopeemobile.com/";
	
	/**
	 * shopee获取授权
	 */
	public static final String getAuthorizationUrl = "api/v1/shop/auth_partner";
	
	
	
	/**
	 * Shopee 取消授权
	 */
	public static final String cancelAuthorizationUrl = "api/v1/shop/cancel_auth_partner";
	
	/**
	 * 获取店铺的基本信息
	 */
	public static final String GetShopInfo = "api/v1/shop/get";
	
	/**
	 * 更新店铺的基本信息
	 */
	public static final String UpdateShopInfo = "api/v1/shop/update";
	
	/**
	 * 获取订单信息
	 */
	public static final String GetOrdersList = "api/v1/orders/basics";
	
	/**
	 * 获取订单的详细描述
	 */
	public static final String GetOrderDetails = "api/v1/orders/detail";
	
	
	public static final String GetItemsList = "api/v1/items/get";
	
	public static final String GetItemDetail ="api/v1/item/get";
	
	/**
	 * 上传图片
	 */
	public static final String UploadImg = "api/v1/image/upload";

}
