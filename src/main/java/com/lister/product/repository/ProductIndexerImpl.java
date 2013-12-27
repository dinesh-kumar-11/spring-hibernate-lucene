package com.lister.product.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lister.product.model.Product;

@Repository
@Transactional
public class ProductIndexerImpl implements ProductIndexer {
	
	
	@Autowired
    private SessionFactory sessionFactory;
	
	
	public void addProduct(Product Product) {
		Session session = sessionFactory.openSession();
        
        FullTextSession fullTextSession = Search.getFullTextSession(session);
        try {
			fullTextSession.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
         
        fullTextSession.close();
	}
}
