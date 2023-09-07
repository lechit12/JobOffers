package org.joboffers.domain.offer;

import lombok.AllArgsConstructor;
import org.joboffers.domain.offer.dto.OfferResponseDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


public class InMemoryOfferRepository implements OfferRepository {

    Map<String, Offer> database = new ConcurrentHashMap<>();

    @Override
    public Optional<Offer> findOfferById(String id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public Offer save(Offer savedOffer) {
        if (database.values().stream().anyMatch(offer -> offer.offerUrl().equals(savedOffer.offerUrl()))) {
            throw new OfferDuplicateException(savedOffer.offerUrl());
        }
        UUID id = UUID.randomUUID();
        Offer offer = new Offer(id.toString(),
                savedOffer.companyName(),
                savedOffer.position(),
                savedOffer.salary(),
                savedOffer.offerUrl()
        );
        database.put(id.toString(),offer);
        return offer;
    }

    @Override
    public List<Offer> findAllOffers() {
        return database.values().stream().toList();
    }

    @Override
    public List<Offer> saveAll(List<Offer> offers) {
        return offers.stream()
                .map(this::save)
                .toList();
    }

    @Override
    public boolean existsByOfferUrl(String offerUrl) {
        long count = database.values()
                .stream()
                .filter(offer -> offer.offerUrl().equals(offerUrl))
                .count();
        return count == 1;
    }

    @Override
    public Optional<Offer> findByOfferUrl(String offerUrl) {
        return Optional.of(database.get(offerUrl));
    }
}
