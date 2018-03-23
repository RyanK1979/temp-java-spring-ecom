package org.wecancodeit.ecom.catalog;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {

	@Id
	@GeneratedValue
	private long Id;
	private Product product;

	@OneToMany(mappedBy = "cart")
	private Collection<Product> products;

	public Cart(Product... product) {

	}

	public Product getProducts() {

		return product;
	}

}
