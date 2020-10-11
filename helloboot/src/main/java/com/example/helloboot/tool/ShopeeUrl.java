package com.example.helloboot.tool;

public class ShopeeUrl {
	
	public static final String host = "https://partner.uat.shopeemobile.com/";
	
	/**
	 * shopee获取授权
	 */
	public static final String getAuthorizationUrl = "api/v1/shop/auth_partner";
	
	/**
	 * Shopee 取消授权
	 */
	public static final String cancelAuthorizationUrl = "api/v1/shop/cancel_auth_partner";

}
