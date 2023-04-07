package com.template.TemplateProject.service;

import com.template.TemplateProject.model.CashValue;

public class IdleState implements State{

    private static IdleState singletonInstance;
    private IdleState()
    {

    }
    public static IdleState getInstance()
    {
        if(singletonInstance == null) {
            singletonInstance = new IdleState();
        }
        return singletonInstance;
    }
    @Override
    public void initialize() {
        System.out.println("Insert notes of 1, 2, 5, 10, 50, 100");
        Util.getInstance().setDepositedAmount(0);
    }

    @Override
    public void cashInserted(CashValue cashAmount) {

        Util.getInstance().setDepositedAmount(cashAmount.getValue());
        Util.getInstance().setState(SelectProductState.getInstance());
    }

    @Override
    public void numberClicked(Integer number) {
        System.out.println("insert money first");
    }
}
