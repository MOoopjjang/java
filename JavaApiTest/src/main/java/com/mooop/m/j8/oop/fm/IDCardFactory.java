package com.mooop.m.j8.oop.fm;

import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory{
    List<Product> owners = new ArrayList<>();
    @Override
    public Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    public void registryProduct(Product product) {
        owners.add(product);
    }
}
