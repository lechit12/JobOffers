package org.joboffers.domain.offer;

import java.util.List;
import java.util.Optional;

public class OfferFacadeConfiguration {

    OfferFacade offerFacade(OfferFetchable offerFetchable)
    {
        OfferRepository repo=new OfferRepository() {
            @Override
            public Optional<Offer> findOfferById(String id) {
                return Optional.empty();
            }

            @Override
            public Offer save(Offer savedOffer) {
                return null;
            }

            @Override
            public List<Offer> findAllOffers() {
                return null;
            }

            @Override
            public List<Offer> saveAll(List<Offer> offers) {
                return null;
            }

            @Override
            public boolean existsByOfferUrl(String offerUrl) {
                return false;
            }

            @Override
            public Optional<Offer> findByOfferUrl(String offerUrl) {
                return Optional.empty();
            }
        };
        OfferService offerService =new OfferService(offerFetchable,repo);
        return new OfferFacade(repo,offerService);
    }
}
