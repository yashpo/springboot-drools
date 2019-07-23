package com.sb.drools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sb.drools.model.Product;
import com.sb.drools.service.FruitShopService;

@RestController
public class FruitShopController {

	private final FruitShopService fruitShopService;

	@Autowired
	public FruitShopController(FruitShopService fruitShopService) {
		this.fruitShopService = fruitShopService;
	}

	@RequestMapping(value = "/getDiscount", method = RequestMethod.GET, produces = "application/json")
	public Product getQuestions(@RequestParam(required = true) String type) {

		Product product = new Product();
		product.setType(type);

		fruitShopService.getProductDiscount(product);

		return product;
	}

}
