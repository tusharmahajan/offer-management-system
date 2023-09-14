package offer.management.models;

import lombok.Getter;
import offer.management.models.offers.Offer;

import java.util.List;

@Getter
public class User {

    private final String userId;
    private final String name;
    private final UserType userType;
    private final List<Offer> offers;

    public User(String userId, String name, UserType userType, List<Offer> offers) {
        this.userId = userId;
        this.name = name;
        this.userType = userType;
        this.offers = offers;
    }

    public void enableOffer(Offer offer){
        this.offers.add(offer);
    }

    public void disableOffer(Offer offer) {
        this.offers.remove(offer);
    }
}
