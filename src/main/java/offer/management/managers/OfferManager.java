package offer.management.managers;

import offer.management.data.OfferStore;
import offer.management.models.offers.Offer;
import offer.management.models.User;
import offer.management.models.offers.OfferType;

import java.util.List;
import java.util.Optional;

public class OfferManager {

    UserManager userManager = new UserManager();

    public void addOfferDetails(Offer offer) {
        offer.storeOfferDetails();
    }

    public Offer getOfferByName(String offerName){
        return OfferStore.getOfferDetailsByName(offerName);
    }

    public Offer getBestOffer(User user, int amount) {
        List<Offer> offers = getOffers(user.getUserId());
        if(offers.isEmpty()){
            throw new RuntimeException("No offers applicable for this user: " + user.getUserId());
        }

        Optional<Offer> cashbackOffer = offers.stream().filter( x->
                        x.getOfferType().equals(OfferType.CASHBACK) && x.isOfferApplicable(amount)).findFirst();

        if(cashbackOffer.isPresent()) return cashbackOffer.get();


        Optional<Offer> rewardPointsOffer = offers.stream().filter( x->
                x.getOfferType().equals(OfferType.REWARD_POINTS) && x.isOfferApplicable(amount)).findFirst();

        return rewardPointsOffer.get();
    }

    public List<Offer> getOffers(String userId){
        User user = userManager.getUserById(userId);
        return user.getOffers();
    }
}
