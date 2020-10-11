package com.example.helloboot.tool;

import org.apache.commons.codec.digest.DigestUtils;

public class ShopeeTool {

	public static final String redirectURL = "http://127.0.0.1:8080";
	public static final String partnerKey = "e037d336bbc0fb5f93da45e0e99800bbd2d30f36fd8c9edbe960fcb448e87469";
	public static final String partnerId = "841956";

	private static String calToken(String redirectURL, String partnerKey) {
		String baseStr = partnerKey + redirectURL;
		return DigestUtils.sha256Hex(baseStr);
	}

	/**
	 * @param urlStr
	 * @return 获取用户授权或则取消授权的uRL 链接
	 */
	public static String getOrCancelAuthorizationUrl(String urlStr) {
		String token = calToken(redirectURL, partnerKey);
		StringBuffer sb = new StringBuffer();
		sb.append(ShopeeUrl.host).append(urlStr).append("?id=").append(partnerId).append("&token=").append(token)
				.append("&redirect=").append(redirectURL);
		return sb.toString();
	}

	public static void main(String[] args) {
		String urlStr = getOrCancelAuthorizationUrl(ShopeeUrl.cancelAuthorizationUrl);
		System.out.println(urlStr);
	}
}
