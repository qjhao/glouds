package sin.glouds.bean;

import java.util.List;

public class CallBackData {
	private String order_id;
	private String order_status;
	private String weight;
	private String transport_service_code;
	private String transport_order_id;
	private String order_items;
	private List<Item> items;
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getTransport_service_code() {
		return transport_service_code;
	}
	public void setTransport_service_code(String transport_service_code) {
		this.transport_service_code = transport_service_code;
	}
	public String getTransport_order_id() {
		return transport_order_id;
	}
	public void setTransport_order_id(String transport_order_id) {
		this.transport_order_id = transport_order_id;
	}
	public String getOrder_items() {
		return order_items;
	}
	public void setOrder_items(String order_items) {
		this.order_items = order_items;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
}
