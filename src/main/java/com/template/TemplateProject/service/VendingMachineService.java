package com.template.TemplateProject.service;

import com.template.TemplateProject.model.CashValue;

public class VendingMachineService {

    public void cashInserted(CashValue cashAmount){
        Util.getInstance().getState().cashInserted(CashValue.HUNDRED);
    }
    public void numberClicked(Integer number)
    {
        Util.getInstance().getState().numberClicked(number);
    }
    public void enterClicked()
    {
        Util.getInstance().getState().enterClicked();
    }
    public void clearClicked()
    {
        Util.getInstance().getState().clearClicked();
    }
    public void cancelClicked()
    {
        Util.getInstance().getState().cancelClicked();
    }

    private static VendingMachineService singletonInstance;
    private VendingMachineService()
    {
        Util.getInstance().setState(IdleState.getInstance());
    }
    public static VendingMachineService getInstance()
    {
        if(singletonInstance == null) {
            singletonInstance = new VendingMachineService();
        }
        return  singletonInstance;
    }
}
