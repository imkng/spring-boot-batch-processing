package com.batch.example.BootBatchExample.config;

import com.batch.example.BootBatchExample.model.Product;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Product, Product> {
    @Override
    public Product process(Product item) throws Exception {
        //logic for discounted Price
        try {
            int discountPercentage = Integer.parseInt(item.getDiscount());
            Double original = Double.parseDouble(item.getPrice());
            double discount = ((double) discountPercentage /100)*original;
            double finalPrice = original - discount;
            item.setDiscountedPrice(String.valueOf(finalPrice));
        }catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        System.out.println(item);
        return item;
    }
}
