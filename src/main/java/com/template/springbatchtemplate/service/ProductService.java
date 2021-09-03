package com.template.springbatchtemplate.service;

import com.template.springbatchtemplate.domain.Product;
import com.template.springbatchtemplate.repository.ProductDAO;
import com.template.springbatchtemplate.repository.ProductDAOFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductDAO<Product> productDAO = ProductDAOFactory.getInstance();

    public List<Product> getProductsBelowPriceThreshold() {
        return productDAO.findBelowThreshold();
    }

    public void updateProduct(Product product){
        System.out.println("Updating "+product.getName() +" price to: " + product.getPrice());
        productDAO.update(product);
    }
}
