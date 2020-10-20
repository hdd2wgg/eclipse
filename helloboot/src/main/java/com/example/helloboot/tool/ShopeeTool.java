package com.example.helloboot.tool;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.digest.DigestUtils;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import com.alibaba.fastjson.JSONObject;

public class ShopeeTool {

	public static final String redirect_URL = "http://3r47665h74.wicp.vip";
	public static final String Test_partnerKey = "e037d336bbc0fb5f93da45e0e99800bbd2d30f36fd8c9edbe960fcb448e87469";
	public static final int Test_partnerId = 841956;
	
	public static final int shopid = 129877668;
	
	public static final String Live_partnerKey = "8984856a61c6fb27947a113a99cb279d813c62c75dd4a6ee4581e4a166496073";
	public static final int Live_partnerId = 841682;
	
	public static final String dh = "=";
	public static final String gg = "&";

	private static String calToken(String redirectURL, String partnerKey) {
		String baseStr = partnerKey + redirectURL;
		return DigestUtils.sha256Hex(baseStr);
	}
	
	public static String HmacSHA256(String data, String key)  {
	    Mac sha256_HMAC = null;
	    StringBuilder sb = new StringBuilder();
		try {
			sha256_HMAC = Mac.getInstance("HmacSHA256");
			SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
		    sha256_HMAC.init(secret_key);
		    byte[] array = sha256_HMAC.doFinal(data.getBytes(StandardCharsets.UTF_8));
		    for (byte item : array) {
		        sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
		    }
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
			e.printStackTrace();
		}
	    return sb.toString();
	}

	/**
	 * @param urlStr
	 * @return 获取用户授权或则取消授权的uRL 链接
	 */
	public static String getOrCancelAuthorizationUrl(String host,String redirectURL,int partenerId,String partnerKey,String urlStr) {
		String token = calToken(redirectURL, partnerKey);
		StringBuffer sb = new StringBuffer();
		sb.append(host).append(urlStr).append("?id=").append(partenerId).append("&token=").append(token)
				.append("&redirect=").append(redirectURL);
		return sb.toString();
	}
	
	public static String getSignBaseStr() {
		Map<String,Object> conditions = new HashMap<String, Object>();
		conditions.put("shopid", shopid);
		
		String jsonData = mapToJsonStr(conditions);
		String url =ShopeeUrl.live_host +  ShopeeUrl.GetShopInfo;
		String baseUrl = url + "|" + jsonData;
		System.out.println(url);
		String authorization = HmacSHA256(baseUrl, Live_partnerKey);
		
        Connection connection = Jsoup.connect(url)
        		.ignoreContentType(true)
                .header("Host", "partner.shopeemobile.com")
        		.header("Content-Type", "application/json; charset=UTF-8")
                .header("Authorization",authorization)
                .requestBody(jsonData)
                .method(Connection.Method.POST);
 
        try {
			Response response = connection.execute();
			System.out.println(response.body());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	/**
	 * 获取Shopee 数据
	 * @param shopeeUrl
	 * @param conditions
	 * @return
	 */
	public static String getShopeeData(String shopeeUrl,Map<String, Object> conditions) {
		String dataUrl = ShopeeUrl.live_host + shopeeUrl;
		String jsonData = mapToJsonStr(conditions);
		String baseSginUrl = dataUrl + "|" + jsonData;
		String authorization = HmacSHA256(baseSginUrl, Live_partnerKey);
		return getJsonData(dataUrl, authorization, jsonData);
	}
	
	public static String getJsonData(String urlStr,String authorization,String jsonData) {
		Connection connection = Jsoup.connect(urlStr)
                .header("Host", "partner.shopeemobile.com")
        		.header("Content-Type", "application/json; charset=UTF-8")
                .header("Authorization",authorization)
                .requestBody(jsonData)
                .method(Connection.Method.POST);
        try {
			Response response = connection.ignoreContentType(true).execute();
			return response.body();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return null;
	}
	
	/*
	 * @param conditions 将Map 条件集合转换成字符串的样式
	 * @return
	 */
	/*public static String mapToStrCondition(Map<String, String> conditions) {
		String res = null;
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, String> con : conditions.entrySet()) {
			sb.append(con.getKey()).append(dh).append(con.getValue()).append(gg);
		}
		res = sb.toString();
		res = res.substring(0, res.length() - 1);
		return res;
	}*/
	
	/**
	 * @param 将map 转换为json 字符串 , 这里添加的是傻逼
	 * @return
	 */
	public static String mapToJsonStr(Map<String,Object> conditions) {
		conditions.put("partner_id", Live_partnerId);
		long currentTimestamp = getCurrentTimestamp();
		conditions.put("timestamp", currentTimestamp);
		JSONObject job = new JSONObject(conditions);
		System.out.println(job.toJSONString());
		return job.toJSONString();
	}
	
	/**
	 * @return 获取当前时间戳 10 位
	 */
	public static long getCurrentTimestamp() {
		Instant instant = Instant.now();
		long timeStampMillis = instant.toEpochMilli();
		return timeStampMillis / 1000;
	}
	
	public static void main(String[] args) {
		Map<String, Object> conditions = new HashMap<String,Object>();
		String[] ordersn_list = {"201014A50JJKJE"};
		conditions.put("shopid", shopid);
//		conditions.put("ordersn_list", ordersn_list);
		conditions.put("item_id", 7723519760L);
		String shopeeUrl = ShopeeUrl.GetItemDetail;
		String res = getShopeeData(shopeeUrl, conditions);
		System.out.println(res);
	}
}
