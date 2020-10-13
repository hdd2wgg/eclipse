package com.example.helloboot.tool;

import java.time.Instant;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

import com.alibaba.fastjson.JSONObject;

public class ShopeeTool {

	public static final String redirectURL = "http://127.0.0.1:8080";
	public static final String Test_partnerKey = "e037d336bbc0fb5f93da45e0e99800bbd2d30f36fd8c9edbe960fcb448e87469";
	public static final int Test_partnerId = 841956;
	
	public static final String Live_partnerKey = "8984856a61c6fb27947a113a99cb279d813c62c75dd4a6ee4581e4a166496073";
	public static final int Live_partnerId = 841682;
	
	public static final String dh = "=";
	public static final String gg = "&";

	private static String calToken(String redirectURL, String partnerKey) {
		String baseStr = partnerKey + redirectURL;
		return DigestUtils.sha256Hex(baseStr);
	}

	/**
	 * @param urlStr
	 * @return 获取用户授权或则取消授权的uRL 链接
	 */
	public static String getOrCancelAuthorizationUrl(String urlStr) {
		String token = calToken(redirectURL, Test_partnerKey);
		StringBuffer sb = new StringBuffer();
		sb.append(ShopeeUrl.host).append(urlStr).append("?id=").append(Test_partnerId).append("&token=").append(token)
				.append("&redirect=").append(redirectURL);
		return sb.toString();
	}
	
	/**
	 * @param conditions 将Map 条件集合转换成字符串的样式
	 * @return
	 */
	public static String mapToStrCondition(Map<String, String> conditions) {
		String res = null;
		
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, String> con : conditions.entrySet()) {
			sb.append(con.getKey()).append(dh).append(con.getValue()).append(gg);
		}
		res = sb.toString();
		res = res.substring(0, res.length() - 1);
		return res;
	}
	
	/**
	 * @param 将map 转换为json 字符串 , 这里添加的是傻逼
	 * @return
	 */
	public static String mapToJsonStr(Map<String,Object> conditions) {
		conditions.put("partner_id", Test_partnerId);
		long currentTimestamp = getCurrentTimestamp();
		conditions.put("timestamp", currentTimestamp);
		JSONObject job = new JSONObject(conditions);
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

		System.out.println(getCurrentTimestamp());
	}
}
