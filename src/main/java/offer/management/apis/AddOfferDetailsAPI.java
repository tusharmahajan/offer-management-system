package offer.management.apis;

import offer.management.factory.OfferFactory;
import offer.management.models.offers.Offer;
import offer.management.models.offers.OfferType;
import offer.management.managers.OfferManager;
import offer.management.managers.UserManager;
import offer.management.models.User;
import offer.management.models.UserType;

public class AddOfferDetailsAPI {


    OfferManager offerManager = new OfferManager();
    UserManager userManager = new UserManager();

    public void addOfferDetails(String userId, String offerName, OfferType offerType,
                                int value, boolean isValuePercent, String description) throws IllegalAccessException {

        User user = userManager.getUserById(userId);
        if(user == null){
            throw new RuntimeException("user doesn't exist in system");
        }

        if(!user.getUserType().equals(UserType.ADMIN)){
            throw new IllegalAccessException("User cant perform this action!");
        }
        Offer offer = OfferFactory.getOfferType(offerName, offerType, value, isValuePercent, description);

        offerManager.addOfferDetails(offer);

    }
}
