package com.template.springbatchtemplate.repository;

import com.template.springbatchtemplate.domain.Product;

//Singleton
public class ProductDAOFactory {

    private static ProductDAO<Product> products = null;

    public static ProductDAO<Product> getInstance() {
        if (ProductDAOFactory.products == null) {
            ProductDAOFactory.products = new ProductDAOImpl();
        }

        return products;
    }
}
