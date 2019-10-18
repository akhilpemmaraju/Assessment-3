package com.shop;

public class ProductSales extends Stock {
	String pcode;
	String name;
	int quantity;
	float cost;



public ProductSales(String bc, String name1, int qty, float cost1) {
		// TODO Auto-generated constructor stub
		this.pcode = bc;
		this.name=name1;
		this.quantity=qty;
		this.cost=cost1;
	}

public String getPcode() {
	return pcode;
}

public void setPcode(String pcode) {
	this.pcode = pcode;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public float getCost() {
	return cost;
}

public void setCost(float cost) {
	this.cost = cost;
}

public static void main(String[] args) {
	// TODO Auto-generated method stub


}

}