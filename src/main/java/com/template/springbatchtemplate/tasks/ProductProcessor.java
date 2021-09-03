package com.template.springbatchtemplate.tasks;

import com.template.springbatchtemplate.domain.Product;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import static com.template.springbatchtemplate.shared.Constants.TEN_PERCENT;

@Component
public class ProductProcessor implements ItemProcessor<Product, Product> {

    @Override
    public Product process(Product product){
        System.out.println(product.getName() +  " price: " + product.getPrice());
        double newPrice = product.getPrice() + product.getPrice()*TEN_PERCENT;
        product.setPrice(newPrice);
        return product;
    }
}
