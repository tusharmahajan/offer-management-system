package offer.management.factory;

import offer.management.models.offers.CashBackOffer;
import offer.management.models.offers.Offer;
import offer.management.models.offers.OfferType;
import offer.management.models.offers.RewardPointsOffer;

public class OfferFactory {

    private OfferFactory(){}

    public static Offer getOfferType(String offerName, OfferType offerType, int value, boolean isValuePercent, String description){

        if(offerType.equals(OfferType.CASHBACK)){
            return new CashBackOffer(offerName, value, isValuePercent, description);
        }
        else if(offerType.equals(OfferType.REWARD_POINTS)){
            return new RewardPointsOffer(offerName, value, description);
        }
        else throw new IllegalArgumentException("Offer type not found");
    }
}
