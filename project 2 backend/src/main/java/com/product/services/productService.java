package com.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.productUser;
import com.product.repo.productrepo;

@Service
public class productService {
	@Autowired
	private productrepo repo;
	
	public List<productUser> fetchproductUsertList(){
    return  repo.findAll();
    
/*    public product saveproduct(productUser product)
    {
    	return repo.save(product);
    }*/
}

	public productUser saveproductUsertListToDB(productUser product) {
		
		return repo.save(product);
	}
public Optional<productUser> fetchproductUserById(int id) {
		
		return repo.findById(id);
	}

   public String deleteproductUserById(int id) {
	String result;
	   try {
		   repo.deleteById(id);
		   result="product deleted successfully";
	   }
		   catch(Exception e)
	   
		   {
			   result="product with id is not delted ";
		   }
		   return result;
	   }
}

   
   
   
   
   