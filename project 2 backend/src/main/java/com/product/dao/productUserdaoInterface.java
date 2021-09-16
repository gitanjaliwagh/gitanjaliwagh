package com.product.dao;

import com.product.entity.productUser;

public interface productUserdaoInterface {

	int addproductListDAO(productUser pu);
	productUser  viewproductListDAO(String pu);
	int deleteproductListDAO(String pu);
	int editproductListDAO(String pu);


}
