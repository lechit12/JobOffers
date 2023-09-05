package org.joboffers.domain.offer;


import java.util.List;
import java.util.Optional;

public interface OfferRepository {

    Optional<Offer> findOfferById(String id);


    Offer save(Offer savedOffer);

    List<Offer> findAllOffers();


}
