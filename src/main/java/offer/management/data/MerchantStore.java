package offer.management.data;

import offer.management.models.Merchant;

import java.util.ArrayList;
import java.util.List;

public class MerchantStore {

    private static final List<Merchant> merchants = new ArrayList<>();

    public static Merchant getMerchantById(String merchantId) {
        return merchants.stream().filter(s -> s.getId().equals(merchantId)).findFirst().orElse(null);
    }

    public static void addUser(Merchant merchant){
        merchants.add(merchant);
    }

}
