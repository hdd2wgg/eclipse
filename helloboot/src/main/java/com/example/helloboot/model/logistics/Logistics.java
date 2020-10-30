/**
  * Copyright 2020 json.cn 
  */
package com.example.helloboot.model.logistics;
import java.util.List;

/**
 * Auto-generated: 2020-10-30 19:3:17
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Logistics {

    private Weight_limits weight_limits;
    private boolean has_cod;
    private List<String> sizes;
    private String logistic_name;
    private boolean enabled;
    private long logistic_id;
    private boolean preferred;
    private String fee_type;
    
    public Logistics() {}
    
	public void setWeight_limits(Weight_limits weight_limits) {
         this.weight_limits = weight_limits;
     }
     public Weight_limits getWeight_limits() {
         return weight_limits;
     }

    public void setHas_cod(boolean has_cod) {
         this.has_cod = has_cod;
     }
     public boolean getHas_cod() {
         return has_cod;
     }

    public void setSizes(List<String> sizes) {
         this.sizes = sizes;
     }
     public List<String> getSizes() {
         return sizes;
     }

    public void setLogistic_name(String logistic_name) {
         this.logistic_name = logistic_name;
     }
     public String getLogistic_name() {
         return logistic_name;
     }

    public void setEnabled(boolean enabled) {
         this.enabled = enabled;
     }
     public boolean getEnabled() {
         return enabled;
     }

    public void setLogistic_id(long logistic_id) {
         this.logistic_id = logistic_id;
     }
     public long getLogistic_id() {
         return logistic_id;
     }

    public void setPreferred(boolean preferred) {
         this.preferred = preferred;
     }
     public boolean getPreferred() {
         return preferred;
     }

    public void setFee_type(String fee_type) {
         this.fee_type = fee_type;
     }
     public String getFee_type() {
         return fee_type;
     }

}