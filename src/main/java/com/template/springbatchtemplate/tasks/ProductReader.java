package com.template.springbatchtemplate.tasks;

import com.template.springbatchtemplate.domain.Product;
import com.template.springbatchtemplate.service.ProductReaderService;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.template.springbatchtemplate.shared.ListUtil.listIsNullOrEmpty;

public class ProductReader implements ItemReader<Product> {

    @Autowired
    private ProductReaderService productReaderService;
    @Override
    public Product read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        System.out.println("READING PRODUCTS");

        List<Product> productList = productReaderService.getProductsBelowPriceThreshold();

        return listIsNullOrEmpty(productList) ? null: productList.get(0);
    }
}
