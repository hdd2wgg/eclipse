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
import java.util.Set;
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
import com.example.helloboot.model.item.BatchGetItem;
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
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	

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
	private static String getShopeeData(String shopeeUrl,Map<String, Object> conditions) {
		String dataUrl = ShopeeUrl.live_host + shopeeUrl;
		String jsonData = mapToJsonStr(conditions);
		String baseSginUrl = dataUrl + "|" + jsonData;
		String authorization = HmacSHA256(baseSginUrl, Live_partnerKey);
		
		try {
			return getJsonData(dataUrl, authorization, jsonData);
		} catch (IOException e) {
			try {
				return getJsonData(dataUrl, authorization, jsonData);
			} catch (IOException e1) {
				return null;
			}
		}
	}
	
	private static String getJsonData(String urlStr,String authorization,String jsonData) throws IOException  {
		Connection connection = Jsoup.connect(urlStr)
                .header("Host", "partner.shopeemobile.com")
                .header("Connection", "close")
        		.header("Content-Type", "application/json; charset=UTF-8")
        		.timeout(30000)
                .header("Authorization",authorization)
                .requestBody(jsonData)
                .method(Connection.Method.POST);
			Response response = connection.ignoreContentType(true).execute();
			return response.body();
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
    	System.out.println(joa.toJSONString());
//    	String json_options_str = JSONObject.toJSONString(json_options, SerializerFeature.WriteClassName); 
    	List<String> options = jarr_to_list(joa.getJSONArray("options"));
    	List<String> images_url = jarr_to_list(joa.getJSONArray("images_url"));
    	String image_url = null;
    	if(images_url != null) {
    		for (int i = 0; i < options.size(); i++) {
    			if(option.equals(options.get(i))) {
    				image_url = images_url.get(i);
    				break;
    			}
    		}
    	}
    	return image_url;
    }
    
    /**
     * @param jsonArr
     * @return 将 JSONArray 转换成  List:String
     */
    private static  List<String> jarr_to_list(JSONArray jsonArr){
    	if(jsonArr == null || jsonArr.size() == 0) {
    		return null;
    	}
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
    //////////////////////////////Items////////////////////////////////////////////////////////
    
    /**
     * Use this call to get a list of items
     * 	使用此调用获取商品列表
     * @param shopId
     * @param pagination_offset
     */
    public static JsonItem getItemsList(int shopId,int pagination_offset) {
    	JsonItem jsonItem = null;
    	Map<String,Object> conditions = new HashMap<>();
    	conditions.put("pagination_offset", pagination_offset);
    	conditions.put("pagination_entries_per_page", 100);
    	conditions.put("shopid", shopId);
//    	conditions.put("need_deleted_item", true);
    	String res = getShopeeData(ShopeeUrl.GetItemsList, conditions);
    	jsonItem = JSON.parseObject(res, new TypeReference<JsonItem>() {});
    	return jsonItem;
    }
    
    /**
     * 	提取出Item 列表中 item_id 放入一个List 中
     * @param itemsList
     * @return
     */
    public static List<Long> getItemsListOf_ItemID(List<Item> itemsList){
    	return itemsList.stream().map(Item::getItem_id).collect(Collectors.toList());
    }
    
    /**
     * 	获取 详细的item 产品列表
     * @param shopId
     * @param itemsList
     * @return
     */
    public static List<Item> getItemDetailList(int shopId,List<Item> itemsList){
    	List<Long> itemIds = getItemsListOf_ItemID(itemsList);
    	if(itemIds != null && itemIds.size() > 0) {
    		List<Item> itemList = new ArrayList<>();
    		Item item;
    		for (Long itemId : itemIds) {
    			item = getItemDetail(shopId, itemId);
    			if(item != null) {
    				itemList.add(item);
    			}
			}
    		return itemList;
    	}
    	return null;
    }
    
    /**
     * Use this call to get detail of item
     * 	使用此调用获取项目的详细信息
     * @param shopId
     * @param item_id
     */
    public static Item getItemDetail(int shopId,long itemId) {
    	Item item = null;
    	Map<String,Object> conditions = new HashMap<>();
    	conditions.put("item_id", itemId);
    	conditions.put("shopid", shopId);
    	String res = getShopeeData(ShopeeUrl.GetItemDetail, conditions);
    	if(res != null) {
    		JsonItem jsonItem = JSON.parseObject(res, new TypeReference<JsonItem>() {});
        	item = jsonItem.getItem();
        	if(item.getIs_2tier_item()) {
        		item.setTier_variation(getVariations(itemId, shopId));
        	}
        	return item;
    	}
    	return null;
    }
    
    /**
     * 	获取item 的子选项的图片集合
     * @param itemId
     * @param shopId
     * @return
     */
    public static String getVariations(long itemId,int shopId) {
    	Map<String,Object> conditions = new HashMap<>();
    	conditions.put("item_id", itemId);
    	conditions.put("shopid", shopId);
    	String res = getShopeeData(ShopeeUrl.GetVariations, conditions);
    	return JSONObject.parseObject(res).getJSONArray("tier_variation").toJSONString();
    }
    
    
    ////////////////////////////////Logistics////////////////////////////////////////////////////
    
    /**
     * 	根据店铺ID 来获取该店铺所支持的物流方式
     */
    public static void getLogistics(int shopId) {
    	Map<String,Object> con = new HashMap<>();
    	con.put("shopid", shopId);
    	String res = getShopeeData(ShopeeUrl.GetLogistics, con);
    	System.out.println(res);
    }
	
	public static void main(String[] args){
//		getItemsList(shopid, 0);
		long begin = System.currentTimeMillis();
		
		int page = 0;
		boolean more = true;
		Set<String> ott = new HashSet<>();
		do {
			JsonItem jsonItem = getItemsList(shopid, page);
//			List<Item> itemList = getItemDetailList(shopid, jsonItem.getItems());
			more = jsonItem.isMore();
			page += 100;
			System.out.println(page);
			List<Long> itemIds = getItemsListOf_ItemID(jsonItem.getItems());
			try {
				
				List<Item> itemList = BatchGetItem.batchGetItemList(itemIds);
				for (Item item : itemList) {
					ott.add(item.getItem_sku());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (more);
		System.out.println("数据总条数：" + ott.size());
		long end = System.currentTimeMillis();
		System.out.println("执行时间:" + (end - begin));
		
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
		if(partList == null || partList.size()==0) {
			return null;
		}
		return ordersList.stream().filter(item -> partList.contains(item.getOrdersn())).collect(Collectors.toList());
	}
	
	/**
	 * @param ordersList
	 * @return	提取出订单中的items放入一个List中
	 */
	public static List<Items> getInsertOrderItems(List<Orders> ordersList){
		List<Items> itemsList = new ArrayList<>();
		for (Orders orders : ordersList) {
			itemsList.addAll(orders.getItems());
		}
		return itemsList;
	}
	
	
	/**
	 * 	初始化每个订单中items中的图片 地址
	 * @param ordersList
	 */
	public static void initItemsImage_url(int shopId,List<Items> itemsList) {
		for (Items items : itemsList) {
			items.setImage_url(ShopeeTool.get_image_url(shopId, items.getItem_id(), items.getVariation_name()));
		}
			
	}
	
	/**
	 * 	初始化items 中与它对应订单的订单号
	 * @param ordersList
	 */
	public static void initItemsOrdersn(List<Orders> ordersList) {
		if(ordersList != null && ordersList.size() != 0) {
			for (Orders orders : ordersList) {
				for (Items items : orders.getItems()) {
					items.setOrdersn(orders.getOrdersn());
				}
			}
		}
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
