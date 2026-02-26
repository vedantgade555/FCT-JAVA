package com.vedant.gade.SpringOrmTest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring.xml");

        ProductDao productDao =
                context.getBean(ProductDao.class);  // ✅ FIXED

        Product product = new Product();
        product.setId(2);
        product.setName("Vivo X200");
        product.setDesc("Best Camera");
        product.setPrice(88000);

        productDao.create(product);

        product.setPrice(90000);
        productDao.update(product);

        List<Product> products = productDao.findAll();
        System.out.println(products);

//        productDao.delete(product);

        System.out.println("Operation Completed Successfully!");
    }
}