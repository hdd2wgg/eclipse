package com.example.helloboot.tool;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.digest.DigestUtils;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.helloboot.model.item.Item;
import com.example.helloboot.model.item.JsonItem;
import com.example.helloboot.model.order.Items;
import com.example.helloboot.model.order.JsonOrders;
import com.example.helloboot.model.order.Orders;

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
	
	/**
     * 复杂json格式字符串与JavaBean_obj之间的转换
     */
    public static void testComplexJSONStrToJavaBean(String json){

        Item item = JSON.parseObject(json, new TypeReference<Item>() {});
    }
    
    
    /**
     * 	多线程批量更新item 中 variation 的数据
     * @throws InterruptedException 
     * @throws ExecutionException 
     */
    public static void batchUpdateVariation(List<Item> items) throws InterruptedException, ExecutionException {
    	if(items == null || items.size()==0) {
    		return;
    	}
    	
    	int threadSize = 50;//每500条数据开启一个线程
    	int remainder = items.size()%threadSize;
		int threadNum  = 0;//线程数
		if(remainder == 0){
			threadNum  = items.size()/threadSize;
		} else {
			threadNum  = items.size()/threadSize + 1;
		}
		
		ExecutorService eService = Executors.newFixedThreadPool(threadNum );//创建一个线程池
		
		List<Callable<String>> cList = new ArrayList<>(); 
		Callable<String> task = null;
		List<Item> sList = null;
		
		for(int i=0;i<threadNum;i++){
			if(i == threadNum - 1){
				sList = items.subList(i*threadSize, items.size());
			} else {
				sList = items.subList(i*threadSize, (i+1)*threadSize);
			}
			final List<Item> nowList = sList;
			task = new Callable<String>() {
				@Override
				public String call() throws Exception {
					StringBuffer sb = new StringBuffer();
					for(int j=0;j<nowList.size();j++){
						sb.append(""+nowList.get(j));
					}
					return sb.toString();
				}
			};
			cList.add(task);
		}
		List<Future<String>> results = eService.invokeAll(cList);
		for(Future<String> str:results){
			System.out.println(str.get());
		}
		eService.shutdown();
    	
    }
    
    public static String get_image_url(int shopId,long item_id,String option) {
    	Map<String, Object> cons = new HashMap<String,Object>();
    	cons.put("shopid", shopId);
    	cons.put("item_id", item_id);
    	String jsonS = getShopeeData(ShopeeUrl.GetVariations, cons);
    	JSONObject job  = JSONObject.parseObject(jsonS);
    	JSONObject joa = (JSONObject)job.getJSONArray("tier_variation").get(0);
//    	String json_options_str = JSONObject.toJSONString(json_options, SerializerFeature.WriteClassName); 
    	List<String> options = jarr_to_list(joa.getJSONArray("options"));
    	List<String> images_url = jarr_to_list(joa.getJSONArray("images_url"));
    	String image_url = null;
    	for (int i = 0; i < options.size(); i++) {
			if(option.equals(options.get(i))) {
				image_url = images_url.get(i);
				break;
			}
		}
    	return image_url;
    }
    
    /**
     * @param jsonArr
     * @return 将 JSONArray 转换成  List:String
     */
    private static  List<String> jarr_to_list(JSONArray jsonArr){
    	List<String> res= null;
    	String jStr = jsonArr.toJSONString();
    	res = JSONObject.parseArray(jStr, String.class);
    	return res;
    }
    
    /**
     * @param condition
     * @return 根据条件获取Shopee 的基本信息
     */
    public static JsonOrders getJsonOrders(Map<String,Object> condition) {
    	String json_str = getShopeeData(ShopeeUrl.GetOrdersList,condition);
    	return  JSON.parseObject(json_str, new TypeReference<JsonOrders>() {});
    }
    
    /**
     * @param condition
     * @return 根据条件获取Shopee 订单的详细的订单信息
     */
    public static JsonOrders getJsonOrdersDetails(int shopId,List<String> ordersnList) {
    	Map<String,Object> condition = new HashMap<>();
    	condition.put("shopid", shopId);
    	condition.put("ordersn_list", ordersnList);
    	String json_str = getShopeeData(ShopeeUrl.GetOrderDetails,condition);
    	return  JSON.parseObject(json_str, new TypeReference<JsonOrders>() {});
    }
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		Map<String, Object> conditions = new HashMap<String,Object>();
//		String[] ordersn_list = {"201014A50JJKJE"};
////		String[] images = {"https://cbu01.alicdn.com/img/ibank/2020/184/736/20244637481_1972197700.400x400.jpg","http://3r47665h74.wicp.vip:35704/sss.jpeg"};
//		conditions.put("shopid", shopid);
////		conditions.put("ordersn_list", ordersn_list);
////		conditions.put("images", images);
//		conditions.put("item_id", 7723519760L);
//		String shopeeUrl = ShopeeUrl.GetVariations;
//		String res = getShopeeData(shopeeUrl, conditions);
//		
//		String option = "1 #";
//		long over = 0;
//		for (int i = 0; i < 500; i++) {
//			long begin_time = System.currentTimeMillis();
//			String image_url = get_image_url(shopid, 7723519760L, option);
////			JsonItem jsonjsonItem = JSON.parseObject(res, new TypeReference<JsonItem>() {});
//			long end_time = System.currentTimeMillis();
//			over += (end_time - begin_time);
//			System.out.println(image_url);
//		}
//		
//		System.out.println("总时间 =" + over);
		
		List<String> allList = new ArrayList<>();
		allList.add("fdsfsd");
		allList.add("rwts");
		allList.add("jig");
		allList.add("option");
		
		List<String> partList = new ArrayList<>();
		partList.add("fdsfsd");
		partList.add("rwts");
		
		List<String> exceptList = getExceptList(allList, partList);
		for (String except : exceptList) {
			System.out.println(except);
		}
		
	}
	
	/**
	 * 获取两个List 差集   list1:String - list2:String
	 * @param allList
	 * @param partList
	 * @return
	 */
	public static List<String> getExceptList(List<String> allList, List<String> partList) {
		return allList.stream().filter(item ->!partList.contains(item)).collect(Collectors.toList());
    }
	
	/**
	 * @param ordersList
	 * @return 提取ordersList 中的 ordersn
	 */
	public static List<String> getAllList(List<Orders> ordersList) {
		return ordersList.stream().map(Orders::getOrdersn).collect(Collectors.toList());
    }
	
	/**
	 * @param ordersList
	 * @param partList
	 * @return 提取出只需要更新的List:Orders
	 */
	public static List<Orders> getUpdateOrdersList(List<Orders> ordersList,List<String> partList){
		return ordersList.stream().filter(item -> partList.contains(item.getOrdersn())).collect(Collectors.toList());
	}
	
	public static List<Items> getInsertOrderItems(List<Orders> ordersList){
		List<Items> itemsList = new ArrayList<>();
		for (Orders orders : ordersList) {
			itemsList.addAll(orders.getItems());
		}
		return itemsList;
	}
	
	
	
	/*
	 * 1.获取数据源
	 * 2.提取ordersn list[ordersn1,ordersn2,ordersn3,.........]
	 * 3.查询需要更新的list[ordersn1,ordersn2,.......]
	 * 4.提取出需要插入的list[]
	 * 5.更新数据库
	 * 6.插入新ordersn到数据库
	 * 
	 * */
	
	
}
