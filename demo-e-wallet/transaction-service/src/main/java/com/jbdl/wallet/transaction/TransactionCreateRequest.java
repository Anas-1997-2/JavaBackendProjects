package com.jbdl.wallet.transaction;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionCreateRequest {
	@Positive
    private Integer senderUserId;

    @Positive
    private Integer receiverUserId;

    @Positive
    private Double amount;

    private String purpose;

    public Transaction to(){
        return Transaction.builder()
                .senderUserId(senderUserId)
                .receiverUserId(receiverUserId)
                .amount(amount)
                .purpose(purpose)
                .build();
    }
}
