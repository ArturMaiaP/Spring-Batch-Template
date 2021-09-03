package com.template.springbatchtemplate.tasks;

import com.template.springbatchtemplate.domain.Product;
import com.template.springbatchtemplate.service.ProductService;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.template.springbatchtemplate.shared.ListUtil.listIsNullOrEmpty;

@Component
public class ProductReader implements ItemReader<Product> {

    @Autowired
    private ProductService productReaderService;
    @Override
    public Product read() throws UnexpectedInputException, ParseException, NonTransientResourceException {
        System.out.println("READING PRODUCTS");

        List<Product> productList = productReaderService.getProductsBelowPriceThreshold();

        return listIsNullOrEmpty(productList) ? null: productList.get(0);
    }
}
