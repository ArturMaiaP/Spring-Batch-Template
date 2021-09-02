package com.template.springbatchtemplate.service;

import com.template.springbatchtemplate.domain.Product;
import com.template.springbatchtemplate.repository.ProductDAO;
import com.template.springbatchtemplate.repository.ProductDAOFactory;
import com.template.springbatchtemplate.repository.ProductDAOImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReaderService {

    ProductDAO<Product> productDAO = ProductDAOFactory.getInstance();
    public List<Product> getProductsBelowPriceThreshold() {
        return productDAO.findBelowThreshold();
    }
}
