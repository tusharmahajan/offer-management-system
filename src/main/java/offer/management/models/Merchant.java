package offer.management.models;

import lombok.Getter;

@Getter
public class Merchant {

    private final String id;
    private final String name;
    private final MerchantCategory merchantCategory;

    public Merchant(String id, String name, MerchantCategory merchantCategory) {
        this.id = id;
        this.name = name;
        this.merchantCategory = merchantCategory;
    }
}
