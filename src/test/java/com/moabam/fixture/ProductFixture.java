package com.moabam.fixture;

import com.moabam.api.domain.entity.Product;
import com.moabam.api.domain.entity.enums.ProductType;

public class ProductFixture {

	public static final String BUG_PRODUCT_NAME = "X10";
	public static final int BUG_PRODUCT_PRICE = 3000;
	public static final int BUG_PRODUCT_QUANTITY = 10;

	public static Product bugProduct() {
		return Product.builder()
			.type(ProductType.BUG)
			.name(BUG_PRODUCT_NAME)
			.price(BUG_PRODUCT_PRICE)
			.quantity(BUG_PRODUCT_QUANTITY)
			.build();
	}
}