package com.example.helloboot.model.order;

import java.util.List;

public class JsonOrders {
	private List<String> errors;
    private List<Orders> orders;
    private String request_id;
    public void setErrors(List<String> errors) {
         this.errors = errors;
     }
     public List<String> getErrors() {
         return errors;
     }

    public void setOrders(List<Orders> orders) {
         this.orders = orders;
     }
     public List<Orders> getOrders() {
         return orders;
     }

    public void setRequest_id(String request_id) {
         this.request_id = request_id;
     }
     public String getRequest_id() {
         return request_id;
     }
}
