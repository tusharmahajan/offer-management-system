package offer.management.models.offers;

public interface Offer {

    void storeOfferDetails();
    OfferType getOfferType();
    boolean isOfferApplicable(int amount);
    String getDescription();
}
