package com.global_payment_service_homework.backend.dtos;

import java.util.UUID;

public class TransferMoneyDto {
    private UUID sourceAccountId;
    private UUID targetAccountId;
    private float amount;

    public UUID getSourceAccountId() {
        return this.sourceAccountId;
    }

    public UUID getTargetAccountId() {
        return this.targetAccountId;
    }

    public float getAmount() {
        return this.amount;
    }

}
