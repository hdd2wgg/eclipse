package com.example.helloboot.tool;

public class ShopeeUrl {
	
	public static final String test_host = "https://partner.uat.shopeemobile.com/";
	
	public static final String live_host = "https://partner.shopeemobile.com/";
	
	/**
	 * shopee获取授权
	 */
	public static final String getAuthorizationUrl = "api/v1/shop/auth_partner";
	
	
	
	/**
	 * Shopee 取消授权
	 */
	public static final String cancelAuthorizationUrl = "api/v1/shop/cancel_auth_partner";
	
	public static final String GetShopInfo = "api/v1/shop/get";
	
	
	/**
	 * 获取订单信息
	 */
	public static final String GetOrdersList = "api/v1/orders/basics";

}
