/**
  * Copyright 2020 json.cn 
  */
package com.example.helloboot.model.logistics;

/**
 * Auto-generated: 2020-10-30 19:3:17
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Weight_limits {

	private long logistic_id;
    private double item_min_weight;
    private int item_max_weight;
    
    public Weight_limits() {}
    
	public long getLogistic_id() {
		return logistic_id;
	}

	public void setLogistic_id(long logistic_id) {
		this.logistic_id = logistic_id;
	}

	public void setItem_min_weight(double item_min_weight) {
         this.item_min_weight = item_min_weight;
     }
     public double getItem_min_weight() {
         return item_min_weight;
     }

    public void setItem_max_weight(int item_max_weight) {
         this.item_max_weight = item_max_weight;
     }
     public int getItem_max_weight() {
         return item_max_weight;
     }

}