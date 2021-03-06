package com.lister.product.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lister.product.model.Product;
import com.lister.product.service.ProductService;



@Component
@Path("/product")
public class ProductServices {

	
	 @Autowired
	    ProductService productService;
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getPayment() {
		return productService.listProduct();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	  public Product getTodo(@PathParam("id") Integer id) {
	    return productService.getProduct((id));
	  }
}
