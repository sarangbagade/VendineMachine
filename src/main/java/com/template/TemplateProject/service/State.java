package com.template.TemplateProject.service;

import com.template.TemplateProject.model.CashValue;

public interface State {

    void initialize();
    default void cashInserted(CashValue cashAmount){
        System.out.println("invalid input");
    }
    default void numberClicked(Integer number)
    {
        System.out.println("invalid input");
    }
    default void enterClicked()
    {
        System.out.println("invalid input");
    }
    default void clearClicked()
    {
        System.out.println("invalid input");
    }
    default void cancelClicked()
    {
        System.out.println("invalid input");
    }
}
