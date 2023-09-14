package offer.management.managers;

import offer.management.data.MerchantStore;
import offer.management.models.Merchant;

public class MerchantManager {

    public Merchant getMerchantById(String merchantId) {
        return MerchantStore.getMerchantById(merchantId);
    }
}
