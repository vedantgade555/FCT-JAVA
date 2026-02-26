package com.vedant.gade.SpringOrmTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository   // ⭐ THIS IS MISSING
public class ProductDaoImpl implements ProductDao {
    
    @Autowired
    HibernateTemplate hibernateTemplete;

    @Override
    @Transactional
    public int create(Product product) {
        Integer result = (Integer) hibernateTemplete.save(product);
        return result;
    }

    @Override
    @Transactional
    public void update(Product product) {
        hibernateTemplete.update(product);
    }

    @Override
    @Transactional
    public void delete(Product product) {
        hibernateTemplete.delete(product);
    }

    @Override
    public Product find(int id) {
        Product product = hibernateTemplete.get(Product.class,id);
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = hibernateTemplete.loadAll(Product.class);
        return products;
    }
}