package com.mooop.m.j8.oop.fm;

public abstract class Factory {

    public final Product create(String owner){
        Product p = createProduct(owner);
        registryProduct(p);
        return p;
    }


    public abstract Product createProduct(String owner);
    public abstract void registryProduct(Product product);
}
