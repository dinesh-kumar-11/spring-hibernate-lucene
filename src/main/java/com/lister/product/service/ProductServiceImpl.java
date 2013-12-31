package com.lister.product.service;

import com.lister.product.index.ProductIndexer;
import com.lister.product.model.Product;
import com.lister.product.repository.ProductRepository;
import com.lister.product.search.ProductSearcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 *
 * contains the bussiness logic to be handled related to Product CRUD
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository ProductRepository;
    
    @Autowired
    ProductIndexer productindexer;
    
    @Autowired
    ProductSearcher productseacher;
    
    @Override
    public void addProduct(Product product) {
        if(product != null){
            ProductRepository.addProduct(product);
        }
        else {
            throw new NullPointerException("Product value can not be done!");
        }

    }

    @Override
    public List<Product> listProduct() {
        return ProductRepository.listProduct();
    }

    @Override
    public void removeProduct(Integer id) {
        if(id < 0 || id == null)
            throw new IllegalArgumentException("Id value not properly formed!");
        else
            ProductRepository.removeProduct(id);
    }
    
    @Override
    public Product getProduct(Integer id) {
        if(id < 0 || id == null)
            throw new IllegalArgumentException("Id value not properly formed!");
        else
            return ProductRepository.getProduct(id);
    }
    
    public void indexProduct() {
    	productindexer.indexProduct();
    }

	@Override
	public List<Product> searchProduct(String Name) {
      return productseacher.searchProduct(Name);
	}
}
