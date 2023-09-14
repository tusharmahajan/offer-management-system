package offer.management.managers;

import offer.management.data.UserStore;
import offer.management.models.offers.Offer;
import offer.management.models.User;

import java.util.List;

public class UserManager {

    OfferManager offerManager = new OfferManager();
    public User getUserById(String userId) {
        return UserStore.getUserById(userId);
    }

    public void enableOfferForCustomers(List<String> customerIds, String offerName) {

        Offer offer = null;
        try{
            offer = offerManager.getOfferByName(offerName);
        }
        catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

        for(String customerId : customerIds){
            User user = UserStore.getUserById(customerId);
            if(user == null) throw new RuntimeException("User with id: " + customerId + " doesn't exist");
            user.enableOffer(offer);
        }
    }

    public void disableOfferForCustomers(List<String> customerIds, String offerName) {

        Offer offer = null;
        try{
            offer = offerManager.getOfferByName(offerName);
        }
        catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

        for(String customerId : customerIds){
            User user = UserStore.getUserById(customerId);
            if(user == null) throw new RuntimeException("User with id: " + customerId + " doesn't exist");
            user.disableOffer(offer);
        }
    }
}
