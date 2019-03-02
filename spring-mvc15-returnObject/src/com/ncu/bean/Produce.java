package com.ncu.bean;

public class Produce {
	
	private String itemid;
	private String productid;
	private String listprice;
	private String  unitcost;
	private String attr1;
	private String status;
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getListprice() {
		return listprice;
	}
	public void setListprice(String listprice) {
		this.listprice = listprice;
	}
	public String getUnitcost() {
		return unitcost;
	}
	public void setUnitcost(String unitcost) {
		this.unitcost = unitcost;
	}
	public String getAttr1() {
		return attr1;
	}
	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Produce(String itemid, String productid, String listprice, String unitcost, String attr1, String status) {
		super();
		this.itemid = itemid;
		this.productid = productid;
		this.listprice = listprice;
		this.unitcost = unitcost;
		this.attr1 = attr1;
		this.status = status;
	}
	

}
