package com.template.TemplateProject.service;

import com.template.TemplateProject.model.Product;
import lombok.Data;

@Data
public class Util {

    private Integer depositedAmount;
    private Integer dispenseChangeAmount;
    private State state;
    private Product selectedProduct;

    private static Util singletonInstance;
    private Util()
    {
        this.depositedAmount = 0;
    }
    public static Util getInstance()
    {
        if(singletonInstance == null) {
            singletonInstance = new Util();
        }
        return  singletonInstance;
    }

    public void setState(State state)
    {
        this.state = state;
        this.state.initialize();
    }
}
