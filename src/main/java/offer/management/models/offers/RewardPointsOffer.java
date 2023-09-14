package offer.management.models.offers;

import offer.management.data.OfferStore;

public class RewardPointsOffer implements Offer {

    private final String offerName;
    private final int value;
    private final String description;

    public RewardPointsOffer(String offerName, int value, String description) {
        this.offerName = offerName;
        this.value = value;
        this.description = description;
    }

    @Override
    public void storeOfferDetails() {
        OfferStore.addRewardPointsOffers(this);
    }

    @Override
    public OfferType getOfferType() {
        return OfferType.REWARD_POINTS;
    }

    @Override
    public boolean isOfferApplicable(int amount) {
        return amount >= value;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public String getOfferName() {
        return offerName;
    }
}
