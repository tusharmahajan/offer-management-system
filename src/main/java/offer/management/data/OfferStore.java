package offer.management.data;

import offer.management.models.offers.CashBackOffer;
import offer.management.models.offers.Offer;
import offer.management.models.offers.RewardPointsOffer;

import java.util.ArrayList;
import java.util.List;

public class OfferStore {

    private final static List<CashBackOffer> cashBackOffers = new ArrayList<>();
    private final static List<RewardPointsOffer> rewardPointsOffers = new ArrayList<>();

    public static void addCashBackOffers(CashBackOffer cashBackOffer) {
        cashBackOffers.add(cashBackOffer);
    }

    public static void addRewardPointsOffers(RewardPointsOffer rewardPointsOffer) {
        rewardPointsOffers.add(rewardPointsOffer);
    }

    public static Offer getOfferDetailsByName(String offerName) {

        Offer offer;
        offer = cashBackOffers.stream().filter(s -> s.getOfferName().equals(offerName)).findFirst().orElse(null);

        if(offer == null){
            offer = rewardPointsOffers.stream().filter(s -> s.getOfferName().equals(offerName)).findFirst().orElse(null);
        }

        if(offer == null){
            throw new IllegalArgumentException("No offer found");
        }
        return offer;
    }
}
