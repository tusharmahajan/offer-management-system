package offer.management.models;

import lombok.Getter;

import java.security.Timestamp;

@Getter
public class Transaction {
    private final String id;
    private final String customerId;
    private final int amount;
    private final String merchantId;
    private final MerchantCategory merchantCategory;
    private final String paymentMode;
    private Timestamp timestamp;

    public Transaction(String id, String customerId, int amount, String merchantId,
                       MerchantCategory merchantCategory, String paymentMode, Timestamp timestamp) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.merchantId = merchantId;
        this.merchantCategory = merchantCategory;
        this.paymentMode = paymentMode;
        this.timestamp = timestamp;
    }
}
