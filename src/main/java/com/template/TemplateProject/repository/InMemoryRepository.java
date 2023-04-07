package com.template.TemplateProject.repository;

import com.template.TemplateProject.model.CashValue;
import com.template.TemplateProject.model.Product;

import java.util.HashMap;
import java.util.Map;

public class InMemoryRepository implements IRepository{

    private static InMemoryRepository singletonInstance;
    private InMemoryRepository()
    {
        this.productMap = new HashMap<>();
        this.productInventory = new HashMap<>();
        this.changeInventory = new HashMap<>();
        this.changeInventory.put(CashValue.FIFTY, 1);
    }
    public static InMemoryRepository getInstance()
    {
        if(singletonInstance == null) {
            singletonInstance = new InMemoryRepository();

        }
        return  singletonInstance;
    }
    Map<String, Product> productMap;
    Map<String, Integer> productInventory;
    Map<CashValue, Integer> changeInventory;

    @Override
    public int getProductQuantity(String productId) {
        return productInventory.get(productId);
    }

    @Override
    public void addProduct(Product product) {
        this.productMap.put(product.getId(), product);
        this.productInventory.put(product.getId(), this.productInventory.getOrDefault(product.getId(), 0)+1);
    }

    @Override
    public void updateProductQuantity(String productId, Integer quantity) {
        this.productInventory.put(productId, quantity);
    }

    @Override
    public Product getProductDetails(String productId) {
        return this.productMap.get(productId);
    }

    @Override
    public Map<CashValue, Integer> getChangeInventory() {
        return new HashMap<>(this.changeInventory);
    }

    @Override
    public Map<String, Product> getProductMap() {
        return new HashMap<>(this.productMap);
    }
}
