package com.template.springbatchtemplate.repository;

import com.template.springbatchtemplate.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;
import static com.template.springbatchtemplate.shared.Constants.PRICE_THRESHOLD;

public class ProductDAOImpl implements ProductDAO<Product>{

    private List<Product> products = new ArrayList<Product>();

    public ProductDAOImpl() {
        // TODO Auto-generated constructor stub
        Product p1 = new Product("Headphone", 40.00 );
        products.add(p1);

        Product p2 = new Product("Chrome Cast",100.00 );
        products.add(p2);

        Product p3 = new Product("Keyboard",48.00);
        products.add(p3);
    }

    @Override
    public Optional<Product> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return this.products;
    }

    @Override
    public void save(Product product) {
        this.products.add(product);
    }

    @Override
    public void update(Product product) {
        int index = this.products.indexOf(product);
        this.products.set(index, product);
    }

    @Override
    public void delete(Product product) {
        this.products.remove(product);
    }

    @Override
    public List<Product> findBelowThreshold(){
        List<Product> response = newArrayList();
        for (Product p : products){
            if(p.getPrice() < PRICE_THRESHOLD){
                response.add(p);
            }
        }
        return response.isEmpty() ? null : response;
    }
}
