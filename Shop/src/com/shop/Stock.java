package com.shop;

public class Stock {
	private String code;
	private float cost;
	private int qty;
	private String name;

public Stock() {}; 
public Stock(String code, String name, float cost, int qty) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.cost = cost;
		this.qty = qty;
		this.name = name;
	}

public static void main(String[] args) {
	// TODO Auto-generated method stub

}

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public float getCost() {
	return cost;
}

public void setCost(float cost) {
	this.cost = cost;
}

public int getQty() {
	return qty;
}

public void setQty(int qty) {
	this.qty = qty;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}


}

