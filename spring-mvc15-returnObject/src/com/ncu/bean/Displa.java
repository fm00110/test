package com.ncu.bean;

public class Displa {
	
		private String inv;
		private String date;
		private String name;
		private String amount;
		private String price;
		private String cost;
		private String note;
		public String getInv() {
			return inv;
		}
		public void setInv(String inv) {
			this.inv = inv;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getCost() {
			return cost;
		}
		public void setCost(String cost) {
			this.cost = cost;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		public Displa(String inv, String date, String name, String amount, String price, String cost, String note) {
			super();
			this.inv = inv;
			this.date = date;
			this.name = name;
			this.amount = amount;
			this.price = price;
			this.cost = cost;
			this.note = note;
		}
		
		
		
}
