package org.wecancodeit.ecom.catalog;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@JsonTest
public class cartTest {

	@Resource
	private CrudRepository<Product, Long> productRepo;

	@Resource
	private CrudRepository<Cart, Long> cartRepo;

	@Test
	public void shouldAddItemToCart() {
		Product shoes = productRepo.save(new Product("shoes"));
		Cart cart = new Cart(shoes);
		cartRepo.save(cart);

		assertThat(cart.getProducts(), is("shoes"));
	}

}
