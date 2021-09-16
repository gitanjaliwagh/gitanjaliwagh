package com.product.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.productUser;

public interface productrepo extends JpaRepository<productUser,Integer>{
	public default List<productUser> fetchproducUsertList(){
		List<productUser> products=new ArrayList<productUser>();
		return products;
	 
		
	}

}
