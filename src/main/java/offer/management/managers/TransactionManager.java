package offer.management.managers;

import offer.management.models.Merchant;
import offer.management.models.User;
import offer.management.models.offers.Offer;
import offer.management.models.payments.PaymentMode;

public class TransactionManager {

    OfferManager offerManager = new OfferManager();

    public String processPayment(User user, Merchant merchant, PaymentMode paymentMode, int amount) {
        executeTransaction(user, merchant, paymentMode, amount);
        Offer offer = offerManager.getBestOffer(user, amount);
        if(offer == null){
            return "No offer applicable";
        }
        return offer.getDescription();
    }

    private void executeTransaction(User user, Merchant merchant, PaymentMode paymentMode, int amount) {
    }
}
