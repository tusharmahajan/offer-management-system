package offer.management.models.offers;

import offer.management.data.OfferStore;

public class CashBackOffer implements Offer {


    private final String offerName;
    private final int value;
    private final boolean isValuePercent;
    private final String description;

    public CashBackOffer(String offerName, int value, boolean isValuePercent, String description) {
        this.offerName = offerName;
        this.value = value;
        this.isValuePercent = isValuePercent;
        this.description = description;
    }

    @Override
    public void storeOfferDetails() {
        OfferStore.addCashBackOffers(this);
    }

    @Override
    public OfferType getOfferType() {
        return OfferType.CASHBACK;
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
