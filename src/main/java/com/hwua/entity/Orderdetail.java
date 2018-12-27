package com.hwua.entity;

public class Orderdetail {
	private Integer id;//编号

	private Orders orders;//订单编号

	private Items itemss;//商品编号

	private Integer itemsNum;//商品购买数量

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getItemsNum() {
		return itemsNum;
	}

	public void setItemsNum(Integer itemsNum) {
		this.itemsNum = itemsNum;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Items getItemss() {
		return itemss;
	}

	public void setItemss(Items itemss) {
		this.itemss = itemss;
	}

	public Orderdetail(Integer id, Orders orders, Items itemss, Integer itemsNum) {
		super();
		this.id = id;
		this.orders = orders;
		this.itemss = itemss;
		this.itemsNum = itemsNum;
	}

	public Orderdetail() {
		super();
	}

	@Override
	public String toString() {
		return "Orderdetail [id=" + id + ", orders=" + orders + ", itemss=" + itemss + ", itemsNum=" + itemsNum + "]";
	}
	

}