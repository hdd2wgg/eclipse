package com.example.helloboot.model.order;

import java.util.List;

/**
 * 	该类的作用实用与Shopee 平台数据对接，并将数据存入到数据库中，在本地数据库中查询数据的时候使用类：Orders
 * @author 黄大大的男神
 *
 */
public class Shopee_Orders {
	
	private String estimated_shipping_fee;
	   private String order_flag;
	   private String payment_method;
	   private long update_time;
	   private String message_to_seller;
	   private String shipping_carrier;
	   private String currency;
	   private long create_time;
	   private long pay_time;
	   private String note;
	   private String credit_card_number;
	   private int days_to_ship;
	   private boolean is_split_up;
	   private long ship_by_date;
	   private String escrow_tax;
	   private String tracking_no;
	   private String order_status;
	   private long note_update_time;
	   private String fm_tn;
	   private String dropshipper_phone;
	   private String cancel_reason;
	   private String recipient_address; //
	   private String cancel_by;
	   private String escrow_amount;
	   private String buyer_cancel_reason;
	   private boolean goods_to_declare;
	   private String total_amount;
	   private String service_code;
	   private List<Items> items;//
	   private String actual_shipping_cost;
	   private boolean cod;
	   private String country;
	   private String ordersn;
	   private String dropshipper;
	   private boolean is_actual_shipping_fee_confirmed;
	   private String buyer_username;
	public Shopee_Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEstimated_shipping_fee() {
		return estimated_shipping_fee;
	}
	public void setEstimated_shipping_fee(String estimated_shipping_fee) {
		this.estimated_shipping_fee = estimated_shipping_fee;
	}
	public String getOrder_flag() {
		return order_flag;
	}
	public void setOrder_flag(String order_flag) {
		this.order_flag = order_flag;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public long getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(long update_time) {
		this.update_time = update_time;
	}
	public String getMessage_to_seller() {
		return message_to_seller;
	}
	public void setMessage_to_seller(String message_to_seller) {
		this.message_to_seller = message_to_seller;
	}
	public String getShipping_carrier() {
		return shipping_carrier;
	}
	public void setShipping_carrier(String shipping_carrier) {
		this.shipping_carrier = shipping_carrier;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public long getCreate_time() {
		return create_time;
	}
	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}
	public long getPay_time() {
		return pay_time;
	}
	public void setPay_time(long pay_time) {
		this.pay_time = pay_time;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getCredit_card_number() {
		return credit_card_number;
	}
	public void setCredit_card_number(String credit_card_number) {
		this.credit_card_number = credit_card_number;
	}
	public int getDays_to_ship() {
		return days_to_ship;
	}
	public void setDays_to_ship(int days_to_ship) {
		this.days_to_ship = days_to_ship;
	}
	public boolean isIs_split_up() {
		return is_split_up;
	}
	public void setIs_split_up(boolean is_split_up) {
		this.is_split_up = is_split_up;
	}
	public long getShip_by_date() {
		return ship_by_date;
	}
	public void setShip_by_date(long ship_by_date) {
		this.ship_by_date = ship_by_date;
	}
	public String getEscrow_tax() {
		return escrow_tax;
	}
	public void setEscrow_tax(String escrow_tax) {
		this.escrow_tax = escrow_tax;
	}
	public String getTracking_no() {
		return tracking_no;
	}
	public void setTracking_no(String tracking_no) {
		this.tracking_no = tracking_no;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public long getNote_update_time() {
		return note_update_time;
	}
	public void setNote_update_time(long note_update_time) {
		this.note_update_time = note_update_time;
	}
	public String getFm_tn() {
		return fm_tn;
	}
	public void setFm_tn(String fm_tn) {
		this.fm_tn = fm_tn;
	}
	public String getDropshipper_phone() {
		return dropshipper_phone;
	}
	public void setDropshipper_phone(String dropshipper_phone) {
		this.dropshipper_phone = dropshipper_phone;
	}
	public String getCancel_reason() {
		return cancel_reason;
	}
	public void setCancel_reason(String cancel_reason) {
		this.cancel_reason = cancel_reason;
	}
	public String getRecipient_address() {
		return recipient_address;
	}
	public void setRecipient_address(String recipient_address) {
		this.recipient_address = recipient_address;
	}
	public String getCancel_by() {
		return cancel_by;
	}
	public void setCancel_by(String cancel_by) {
		this.cancel_by = cancel_by;
	}
	public String getEscrow_amount() {
		return escrow_amount;
	}
	public void setEscrow_amount(String escrow_amount) {
		this.escrow_amount = escrow_amount;
	}
	public String getBuyer_cancel_reason() {
		return buyer_cancel_reason;
	}
	public void setBuyer_cancel_reason(String buyer_cancel_reason) {
		this.buyer_cancel_reason = buyer_cancel_reason;
	}
	public boolean isGoods_to_declare() {
		return goods_to_declare;
	}
	public void setGoods_to_declare(boolean goods_to_declare) {
		this.goods_to_declare = goods_to_declare;
	}
	public String getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	public String getService_code() {
		return service_code;
	}
	public void setService_code(String service_code) {
		this.service_code = service_code;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	public String getActual_shipping_cost() {
		return actual_shipping_cost;
	}
	public void setActual_shipping_cost(String actual_shipping_cost) {
		this.actual_shipping_cost = actual_shipping_cost;
	}
	public boolean isCod() {
		return cod;
	}
	public void setCod(boolean cod) {
		this.cod = cod;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getOrdersn() {
		return ordersn;
	}
	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}
	public String getDropshipper() {
		return dropshipper;
	}
	public void setDropshipper(String dropshipper) {
		this.dropshipper = dropshipper;
	}
	public boolean isIs_actual_shipping_fee_confirmed() {
		return is_actual_shipping_fee_confirmed;
	}
	public void setIs_actual_shipping_fee_confirmed(boolean is_actual_shipping_fee_confirmed) {
		this.is_actual_shipping_fee_confirmed = is_actual_shipping_fee_confirmed;
	}
	public String getBuyer_username() {
		return buyer_username;
	}
	public void setBuyer_username(String buyer_username) {
		this.buyer_username = buyer_username;
	}
	   
	   

}
