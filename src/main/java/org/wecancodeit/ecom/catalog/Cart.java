package org.wecancodeit.ecom.catalog;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Cart {

	@Id
	@GeneratedValue
	private long id;
	private String name;

	@ManyToMany(mappedBy = "cart")
	private Collection<Product> products;

	public Cart(String name, Product... products) {
		this.name = name;
		this.products = new HashSet<>(Arrays.asList(products));
	}

	public long getId() {
		return id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
