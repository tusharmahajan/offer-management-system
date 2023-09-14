package offer.management.apis;

import offer.management.managers.UserManager;
import offer.management.models.User;
import offer.management.models.UserType;

import java.util.List;

public class DisableOfferAPI {

    UserManager userManager = new UserManager();

    public void disableOffer(String userId, List<String> customerIds, String offerName) throws IllegalAccessException {

        if(userId == null || userId.equals("")) throw new IllegalArgumentException("User id is empty");

        User user = userManager.getUserById(userId);
        if(user == null){
            throw new RuntimeException("user doesn't exist in system");
        }

        if(!user.getUserType().equals(UserType.ADMIN)){
            throw new IllegalAccessException("User cant perform this action!");
        }

        userManager.disableOfferForCustomers(customerIds, offerName);
    }
}
