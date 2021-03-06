package com.lister.product.repository;

import com.lister.product.model.Product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author contains all CRUD operation related to Product
 */
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
	}

	public List<Product> listProduct() {
         Session session = sessionFactory.openSession();
         List<Product> returnprodlist = session.createQuery("from Product").list();
         session.close();
		return	returnprodlist;			
	}

	public void removeProduct(Integer id) {
		Product product = (Product) sessionFactory.openSession().load(
				Product.class, id);
		if (null != product) {
			sessionFactory.getCurrentSession().delete(product);
		}
	}

	public Product getProduct(Integer id) {
		Product product = (Product) sessionFactory.openSession().load(
				Product.class, id);
		// detaching the  product from session, to avoid lazy initialize problem
		//sessionFactory.getCurrentSession().evict(product); 
		return Product.getProduct(product);
	}
}
