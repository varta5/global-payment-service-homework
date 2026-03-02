package com.global_payment_service_homework.backend.dtos;

import com.global_payment_service_homework.backend.enums.Currency;

public class PostAccountRequestDto {

    private Currency currency;

    public Currency getCurrency() {
        return this.currency;
    }

}
