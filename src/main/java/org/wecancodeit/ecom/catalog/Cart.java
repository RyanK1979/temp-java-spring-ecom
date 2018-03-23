package org.wecancodeit.ecom.catalog;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Cart {

	@Id
	@GeneratedValue
	private long Id;
	private String name;

	@ManyToMany(mappedBy = "cart")
	private Collection<Product> products;

	public Cart(Product... product) {

	}

	public Collection<Product> getProducts() {

		return products;
	}

	@SuppressWarnings("unused")
	private Cart() {
	}

	public String getName() {
		return name;
	}

	public void addOrder(Product product) {
		products.add(product);
	}

}
