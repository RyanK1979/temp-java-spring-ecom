package org.wecancodeit.ecom.catalog;

public class Product {

	private String name;

	private Product() {

	}

	Product(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
