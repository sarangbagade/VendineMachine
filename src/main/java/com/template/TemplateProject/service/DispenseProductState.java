package com.template.TemplateProject.service;

import com.template.TemplateProject.model.Product;
import com.template.TemplateProject.repository.IRepository;
import com.template.TemplateProject.repository.InMemoryRepository;

public class DispenseProductState implements State{

    private IRepository repository;

    private static DispenseProductState singletonInstance;
    private DispenseProductState()
    {
        this.repository = InMemoryRepository.getInstance();
    }
    public static DispenseProductState getInstance()
    {
        if(singletonInstance == null) {
            singletonInstance = new DispenseProductState();
        }
        return singletonInstance;
    }

    @Override
    public void initialize() {
        System.out.println("Dispensing product : " + Util.getInstance().getSelectedProduct().getName());
        Product product = Util.getInstance().getSelectedProduct();
        repository.updateProductQuantity(product.getId(), repository.getProductQuantity(product.getId())-1);
        System.out.println("dispensed product");
        Util.getInstance().setState(IdleState.getInstance());
    }
}
