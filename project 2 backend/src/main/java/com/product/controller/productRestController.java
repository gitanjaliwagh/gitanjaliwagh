package com.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.productUser;
import com.product.repo.productrepo;
import com.product.services.productService;

@RestController
public class productRestController {
	
	
	@Autowired
	private productService service;
	
	/*@GetMapping("getproductList")
	public List<productUser> getDetails(){
		List<productUser> ll=new ArrayList<productUser>();
		productUser p1=new productUser();
		p1.setId(1);
		p1.setName("tomato");
		p1.setDes("tomato is available");
		p1.setPrice(40);
		
		productUser p2=new productUser();
		p2.setId(2);
		p2.setName("table");
		p2.setDes("table is available");
		p2.setPrice(250);
		
		productUser p3=new productUser();
		p3.setId(3);
		p3.setName("bed");
		p3.setDes("bed is available");
		p3.setPrice(656);
		ll.add(p1);
		ll.add(p2);
		ll.add(p3);
		return ll;
	}*/
	

	@GetMapping("/getproductList")
	@CrossOrigin(origins="http://localhost:4200")
	public List<productUser> fetchproductUsertList(){
		List<productUser> products=new ArrayList<productUser>();
		products=service. fetchproductUsertList();
    return  products;
	}
    
    @PostMapping("/addproduct")
    @CrossOrigin(origins="http://localhost:4200")
	public productUser saveproductUsertList(@RequestBody productUser product){
		return service.saveproductUsertListToDB(product);
		
		}
    
    @GetMapping("/getproductbyid/{id}")
    @CrossOrigin(origins="http://localhost:4200")
	public productUser fetchproductUserById(@PathVariable int id){
		return	service.fetchproductUserById(id).get();
    }
		
	 @GetMapping("/deleteproductbyid/{id}")
	 @CrossOrigin(origins="http://localhost:4200")
			public String DeleteproductUsertById(@PathVariable int id){
				return	service. deleteproductUserById(id);
				
   
	}

}
