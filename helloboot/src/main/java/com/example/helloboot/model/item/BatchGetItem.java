package com.example.helloboot.model.item;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BatchGetItem {

	
	public static List<Item> batchGetItemList(List<Long> itemIds) throws Exception {
		List<Item> itemDetailList = new ArrayList<Item>();
		//创建线程池
        ExecutorService exec = Executors.newFixedThreadPool(10);
        CompletionService<List<Item>> cpiService =new ExecutorCompletionService<>(exec);
        int f=0;
        int i =0 ;
        int shopid = 129877668;
        //分发线程
        while (true){
            f=f+1;
            int g=(i+20)>itemIds.size()?(itemIds.size()):(i+20);

            SyncGetItemList callable=new SyncGetItemList(itemIds.subList(i,g), shopid);
            if(!exec.isShutdown()){
                cpiService.submit(callable);
            }
            i=(g);
            if(i>=(itemIds.size()))
                break;
        }
        
      //获取线程处理结果
        for(int h=0;h<f;h++){
            List<Item> itemList=cpiService.take().get();
            itemDetailList.addAll(itemList);
        }
        //关闭多线程池
        exec.shutdown();
        
        return itemDetailList;

	}
	
}
