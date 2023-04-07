package com.template.TemplateProject.repository;

import com.template.TemplateProject.model.CashValue;
import com.template.TemplateProject.model.Product;

import java.util.Map;

public interface IRepository {

    int getProductQuantity(String productId);
    void addProduct(Product product);
    void updateProductQuantity(String productId, Integer quantity);
    Product getProductDetails(String productId);
    Map<CashValue, Integer> getChangeInventory();
    Map<String, Product> getProductMap();
}
