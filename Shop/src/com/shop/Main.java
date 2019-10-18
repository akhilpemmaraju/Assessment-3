package com.shop;

import java.util.*;
import java.util.regex.Pattern;


public class Main {

	static List<Stock> Stocks = new ArrayList<>();
	Stock s = new Stock();
	static float totalcost = 0;
	static ArrayList<ProductSales> arrlist = new ArrayList<>();
	class CodeException extends Exception {
		public CodeException(String message) {
			super(message);
		}
	}

	class NameException extends Exception {
		public NameException(String message) {
			super(message);
		}
	}

	public boolean validateName(String name) {
		Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z\\s]+$");
		try {
			if (p.matcher(name).matches()) {
				return false;
			}
			if (!(p.matcher(name).matches())) {
				throw new NameException("Name Should not contain numbers or special characters or be null");
			} else {
				return false;
			}
		} catch (NameException e) {
			System.err.println(e.getMessage());
			return true;
		}
	}

	public boolean validateCode(String code) {
		Pattern p = Pattern.compile("^\\d{3}$");
		try {
			if (p.matcher(code).matches()) {
				return false;
			}
			if (!(p.matcher(code).matches())) {
				throw new CodeException("Product Code must be all digits and of length 3");
			} else {
				return false;
			}
		} catch (CodeException e) {
			System.err.println(e.getMessage());
			return true;
		}
	}

	public void addStock(String code, String name, float cost, int qty) {
		Stock s = new Stock(name, code, cost, qty);

		Stocks.add(s);
	}

	private void viewStock(Stock s) {
		System.out.println(
				"----------------------------------------------------------------------------------------------------");
		System.out.printf("%70s\n", "Product Details");
		System.out.println(
				"----------------------------------------------------------------------------------------------------");
		System.out.printf("Product Code : %-30s Product Name : %-1s\n", s.getCode(), s.getName());
		System.out.printf("Product Price : %-27s Product Quantity : %-1s\n", String.valueOf(s.getCost()),
				String.valueOf(s.getQty()));
		System.out.println(
				"----------------------------------------------------------------------------------------------------");
	}

	private void updateStock(String uc) {
		Scanner b = new Scanner(System.in);
		System.out.printf("%70s\n", "Enter details of Product");
		System.out.println("Name of product : ");
		String name = b.nextLine();
		while (validateName(name)) {
			System.out.println("Please enter valid Name of product : ");
			name = b.nextLine();
		}
		System.out.println("Code of Product : ");
		String code = b.nextLine();
		while (validateCode(code)) {
			System.out.println("Please enter valid Code : ");
			code = b.nextLine();
		}
		System.out.println("Cost of Product: ");
		float cost = b.nextFloat();
		System.out.println("Quantity of Product: ");
		int qty = b.nextInt();
		for (Stock s : Stocks) {
			if (s.getCode().equals(uc)) {
				s.setName(name);
				s.setCode(code);
				s.setCost(cost);
				s.setQty(qty);
			}

		}
		System.out.println("Details of product updated successfully");
	}

	private void removeProduct(Stock s) {
		Stocks.remove(s);
	}
	
	private void makeSale(String code) {
		Scanner a = new Scanner(System.in);
		System.out.println("Enter quantity of product : ");
		int qty = a.nextInt();
		for(Stock s: Stocks) {
			
		
			
		totalcost = qty * s.getCost();
		System.out.println("Total cost is : " + totalcost);
		System.out.println(s.getName());
		System.out.println(qty);
	}}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		Scanner sc = new Scanner(System.in);
		int input = -1;
		do {
			System.out.println("\n");
			System.out.println("Press 1 to Enter new product details");
			System.out.println("Press 2 to view stock");
			System.out.println("Press 3 to update product details");
			System.out.println("Press 4 to delete product");
			System.out.println("Press 5 to make a sale");
			System.out.println("Press 0 to exit");
			System.out.println("\n");
			System.out.println("Please enter your option");
			input = sc.nextInt();
			sc.nextLine();
			switch (input) {
			case 1:
				System.out.printf("%70s\n", "Enter details of Product");
				System.out.println("Name of product : ");
				String name = sc.nextLine();
				while (m.validateName(name)) {
					System.out.println("Please enter valid Name of product : ");
					name = sc.nextLine();
				}
				System.out.println("Enter code of product : ");
				String code = sc.nextLine();
				while (m.validateCode(code)) {
					System.out.println("Please enter valid product code : ");
					code = sc.nextLine();
				}
				System.out.println("Enter cost of product : ");
				float cost = sc.nextFloat();
				System.out.println("Enter quantity of product : ");
				int qty = sc.nextInt();
				m.addStock(name, code, cost, qty);
				break;
			case 2:
				System.out.printf("%70s\n", "Available Stock");
				for (Stock st : m.Stocks) {
					m.viewStock(st);
				}
				break;
			case 3:
				System.out.println("Enter code of product to update");
				for (Stock stk : m.Stocks) {
					String uc = sc.nextLine();
					if (stk.getCode().equals(uc)) {
						m.updateStock(uc);
					} else {
						System.out.println("Enter valid code");
					}
				}

				break;
			case 4:
				System.out.println("Enter code of product to delete");
				String remc = sc.nextLine();
				for (Stock sto : m.Stocks) {
					if (sto.getCode().equals(remc)) {
						m.removeProduct(sto);
					}
				}
				break;
			case 5:
				System.out.println("Enter code of product to buy");
				String bc = sc.nextLine();
				System.out.println("Enter product quantity : ");
				qty = sc.nextInt();
				for(Stock sk: Stocks) {
					if(sk.getCode().equals(bc)) {
						String name1=sk.getName();
						float cost1=sk.getCost();
						totalcost+=qty*sk.getCost();
						arrlist.add(new ProductSales(bc,name1,qty,cost1));
					}
				}
				break;
			case 6:
				for(ProductSales p: arrlist) {
					System.out.println(p.getCode() + p.getName() + p.getCost());
				}
			case 0:
				input = 0;
			default:
				System.out.println("Please enter valid option");
			}
		} while (input != 0);

	}
}
