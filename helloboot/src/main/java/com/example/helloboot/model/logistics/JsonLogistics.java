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
public class JsonLogistics {

    private List<Logistics> logistics;
    private String request_id;
    public void setLogistics(List<Logistics> logistics) {
         this.logistics = logistics;
     }
     public List<Logistics> getLogistics() {
         return logistics;
     }

    public void setRequest_id(String request_id) {
         this.request_id = request_id;
     }
     public String getRequest_id() {
         return request_id;
     }

}