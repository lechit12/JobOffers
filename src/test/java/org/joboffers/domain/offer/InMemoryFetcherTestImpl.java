package org.joboffers.domain.offer;

import org.joboffers.domain.offer.dto.JobOfferResponseDto;

import java.util.List;

public class InMemoryFetcherTestImpl implements OfferFetchable {
    List<JobOfferResponseDto> listOfOffers;

    @Override
    public List<JobOfferResponseDto> fetchOffers() {
        return listOfOffers;
    }

    InMemoryFetcherTestImpl(List<JobOfferResponseDto> listOfOffers) {
        this.listOfOffers = listOfOffers;
    }
}
