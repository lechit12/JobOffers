package org.joboffers.domain.offer;

import lombok.AllArgsConstructor;
import org.joboffers.domain.offer.dto.JobOfferResponseDto;
import org.joboffers.domain.offer.dto.OfferRequestDto;
import org.joboffers.domain.offer.dto.OfferResponseDto;

import java.util.List;

@AllArgsConstructor
public class OfferFacade {

    private final OfferRepository repository;
    private final OffersFetcher offersFetcher;


    public List<OfferResponseDto> findAllOffers()
    {
        return repository.findAllOffers()
                .stream()
                .map(OfferMapper::mapFromOfferToOfferDto)
                .toList();
    }

    public OfferResponseDto findOfferById(String id) {

        return repository.findOfferById(id)
                .map(OfferMapper::mapFromOfferToOfferDto)
                .orElseThrow(() -> new OfferNotFoundException(id));
    }

    public OfferResponseDto saveOffer(OfferRequestDto offerRequestDto) {
        final Offer offer = OfferMapper.mapFromOfferDtoToOffer(offerRequestDto);
        final Offer save = repository.save(offer);
        return OfferMapper.mapFromOfferToOfferDto(save);
    }
    public List<OfferResponseDto> fetchAllOffersAndSaveAllIfNotExists()
    {

    }

}
