package com.example.helloboot.model.item;


/**
 * Auto-generated: 2020-10-20 20:53:29
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Logistics {

    private String logistic_name;   		// 物流名称
    private boolean is_free;				// 是否免运
    private double estimated_shipping_fee;	// 运费
    private long logistic_id;				// 物流ID
    private boolean enabled;				// 是否可用
    public void setLogistic_name(String logistic_name) {
         this.logistic_name = logistic_name;
     }
     public String getLogistic_name() {
         return logistic_name;
     }

    public void setIs_free(boolean is_free) {
         this.is_free = is_free;
     }
     public boolean getIs_free() {
         return is_free;
     }

    public void setEstimated_shipping_fee(double estimated_shipping_fee) {
         this.estimated_shipping_fee = estimated_shipping_fee;
     }
     public double getEstimated_shipping_fee() {
         return estimated_shipping_fee;
     }

    public void setLogistic_id(long logistic_id) {
         this.logistic_id = logistic_id;
     }
     public long getLogistic_id() {
         return logistic_id;
     }

    public void setEnabled(boolean enabled) {
         this.enabled = enabled;
     }
     public boolean getEnabled() {
         return enabled;
     }

}
