package org.joboffers.domain.offer;


public class OfferNotFoundException extends RuntimeException {

    private final String offerId;
    public OfferNotFoundException(String offerId)
    {
        super(String.format("offer with id %s not found",offerId));
        this.offerId = offerId;
    }




}
