package org.wecancodeit.ecom.catalog;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductPopulator implements CommandLineRunner {

	@Resource
	private ProductRepository productRepo;

	@Resource
	private CartRepository cartRepo;

	@Resource
	private CategoryRepository categoryRepo;

	@Override
	public void run(String... args) throws Exception {

		Product shoes = productRepo.save(new Product("shoes"));

		Cart cart = new Cart("go", shoes);
		cart = cartRepo.save(cart);
	}
}