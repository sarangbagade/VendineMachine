package com.template.TemplateProject.service;

import com.template.TemplateProject.model.Product;
import com.template.TemplateProject.repository.IRepository;
import com.template.TemplateProject.repository.InMemoryRepository;

import java.util.Map;

public class SelectProductState implements State{

    private IRepository repository;
    private StringBuilder enteredPin;

    private static SelectProductState singletonInstance;
    private SelectProductState()
    {
        this.repository = InMemoryRepository.getInstance();
    }
    public static SelectProductState getInstance()
    {
        if(singletonInstance == null) {
            singletonInstance = new SelectProductState();
        }
        return  singletonInstance;
    }

    @Override
    public void initialize() {
        this.enteredPin = new StringBuilder();
        for(Map.Entry<String, Product> entry : this.repository.getProductMap().entrySet())
        {
            System.out.println(entry.getKey() + " : " + entry.getValue().getName());
        }
    }

    @Override
    public void numberClicked(Integer number) {

        this.enteredPin.append(number);
    }

    @Override
    public void enterClicked() {

        Product product = this.repository.getProductDetails(enteredPin.toString());
        if (Util.getInstance().getDepositedAmount() < product.getAmount()) {
                System.out.println("product amount is more than deposited amount");
                return;
            }
        if(repository.getProductQuantity(product.getId()) == 0) {
            System.out.println("product is not there in the inventory. select different product");
            return;
        }
        Util.getInstance().setSelectedProduct(product);
        Util.getInstance().setDispenseChangeAmount(Util.getInstance().getDepositedAmount() - product.getAmount());
        Util.getInstance().setState(DispenseChangeState.getInstance(DispenseProductState.getInstance()));
    }

    @Override
    public void clearClicked() {
        this.enteredPin = new StringBuilder();
        System.out.println("entered value is cleared");
    }

    @Override
    public void cancelClicked() {
        // in cancellation, return whole amount entered and go to initial state
        Util.getInstance().setDispenseChangeAmount(Util.getInstance().getDepositedAmount());
        Util.getInstance().setState(DispenseChangeState.getInstance(IdleState.getInstance()));
    }
}
