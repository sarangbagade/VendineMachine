package com.template.TemplateProject.service;

import com.template.TemplateProject.repository.IRepository;
import com.template.TemplateProject.repository.InMemoryRepository;


public class DispenseChangeState implements State{

    private IRepository repository;
    private State nextState;

    private static DispenseChangeState singletonInstance;
    private DispenseChangeState()
    {
        this.repository = InMemoryRepository.getInstance();
    }
    public static DispenseChangeState getInstance(State nextState)
    {
        if(singletonInstance == null) {
            singletonInstance = new DispenseChangeState();
        }
        singletonInstance.nextState = nextState;
        return singletonInstance;
    }

    @Override
    public void initialize() {
        System.out.println("Dispensing change : " + Util.getInstance().getDispenseChangeAmount());
        Util.getInstance().setState(this.nextState);
    }
}
