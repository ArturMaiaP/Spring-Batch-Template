package com.template.springbatchtemplate.tasks;

import com.template.springbatchtemplate.domain.Product;
import com.template.springbatchtemplate.service.ProductService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductWriter implements ItemWriter<Product> {

    @Autowired
    ProductService productService;

    @Override
    public void write(List<? extends Product> products){
        for(Product product: products){
            productService.updateProduct(product);
        }
    }
}
