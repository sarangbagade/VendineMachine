package com.template.TemplateProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CashValue {

    ONE(1), TWO(2), FIVE(5), TEN(10), FIFTY(50), HUNDRED(100);

    private int value;
}
