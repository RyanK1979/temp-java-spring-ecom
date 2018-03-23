package org.wecancodeit.ecom.catalog;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductMappingTest {

	@Resource
	private CrudRepository<Product, Long> productRepo;

	@Resource
	private CrudRepository<Cart, Long> cartRepo;

	@Test
	public void shouldAddItemsToCart() {
		Product shoes = productRepo.save(new Product("shoes"));
		Cart cart = new Cart("willie", 1, shoes);
		cartRepo.save(cart);

		assertThat(cart.getProducts(), contains(shoes));
	}

	@Test
	public void shouldAddMultipleItemsToCart() {
		Product shoes = productRepo.save(new Product("shoes"));
		Product backpack = productRepo.save(new Product("backpack"));
		Cart cart = new Cart("ryans", 2, shoes, backpack);
		cartRepo.save(cart);

		assertThat(cart.getProducts(), containsInAnyOrder(shoes, backpack));

	}

	@Test
	public void shouldClearCart() {
		Product shoes = productRepo.save(new Product("shoes"));
		Product backpack = productRepo.save(new Product("backpack"));

		Cart cart = cartRepo.save(new Cart("go", 2, shoes, backpack));
		cart.clearCart();

		assertThat(cart.getProducts(), not(containsInAnyOrder(shoes, backpack)));
	}

}
