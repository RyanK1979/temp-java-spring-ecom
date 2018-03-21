package org.wecancodeit.ecom.catalog;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrowseController {

	@Resource
	private CrudRepository<Product, Long> productRepo;

	@RequestMapping("/products")
	public Iterable<Product> findProducts() {
		return productRepo.findAll();
	}

	@RequestMapping("/products/{id}")
	public Product findProduct(@PathVariable(name = "id") long id) {
		Product selectedProduct = productRepo.findOne(id);
		if (selectedProduct != null) {
			return selectedProduct;
		}
		throw new ProductNotFoundException();

	}

	public class ProductNotFoundException extends RuntimeException {

	}

}