package offer.management.apis;

import offer.management.managers.MerchantManager;
import offer.management.managers.TransactionManager;
import offer.management.managers.UserManager;
import offer.management.models.Merchant;
import offer.management.models.payments.PaymentMode;
import offer.management.models.User;

public class TransactionProcessorAPI {

    UserManager userManager = new UserManager();
    MerchantManager merchantManager = new MerchantManager();
    TransactionManager transactionManager = new TransactionManager();

    public String processPayment(String customerId, String merchantId, PaymentMode paymentMode, int amount){

        if(customerId == null || merchantId == null || customerId.isEmpty() || merchantId.isEmpty()){
            throw new IllegalArgumentException("Invalid customer or merchant id");
        }

        Merchant merchant = merchantManager.getMerchantById(merchantId);
        if(merchant == null) throw new RuntimeException("Merchant not found");

        User user = userManager.getUserById(customerId);
        if(user == null){
            throw new RuntimeException("user doesn't exist in system");
        }

        return transactionManager.processPayment(user, merchant, paymentMode, amount);
    }
}


