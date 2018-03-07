package sin.glouds.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "OrderSku")
public class OrderSku {
	public String sku_key;
	public String product_name;
	public String origin_price;
	public String count;
	public String real_totle_price;
	public String activity__totle_amount;
	public String goods_no;
	public String coupon_totle_amount;
	public String barcode;
	public String getSku_key() {
		return sku_key;
	}
	public void setSku_key(String sku_key) {
		this.sku_key = sku_key;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getOrigin_price() {
		return origin_price;
	}
	public void setOrigin_price(String origin_price) {
		this.origin_price = origin_price;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getReal_totle_price() {
		return real_totle_price;
	}
	public void setReal_totle_price(String real_totle_price) {
		this.real_totle_price = real_totle_price;
	}
	public String getActivity__totle_amount() {
		return activity__totle_amount;
	}
	public void setActivity__totle_amount(String activity__totle_amount) {
		this.activity__totle_amount = activity__totle_amount;
	}
	public String getGoods_no() {
		return goods_no;
	}
	public void setGoods_no(String goods_no) {
		this.goods_no = goods_no;
	}
	public String getCoupon_totle_amount() {
		return coupon_totle_amount;
	}
	public void setCoupon_totle_amount(String coupon_totle_amount) {
		this.coupon_totle_amount = coupon_totle_amount;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
}
