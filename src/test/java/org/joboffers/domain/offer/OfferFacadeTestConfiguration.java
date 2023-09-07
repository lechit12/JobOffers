package org.joboffers.domain.offer;


import org.joboffers.domain.offer.dto.JobOfferResponseDto;

import java.util.List;

public class OfferFacadeTestConfiguration {

    private final InMemoryFetcherTestImpl inMemoryFetcherTest;
    private final InMemoryOfferRepository offerRepository;

    OfferFacadeTestConfiguration() {
        this.inMemoryFetcherTest = new InMemoryFetcherTestImpl(
                List.of(
                        new JobOfferResponseDto("id", "id", "asds", "1"),
                        new JobOfferResponseDto("assd", "id", "asds", "2"),
                        new JobOfferResponseDto("asddd", "id", "asds", "3"),
                        new JobOfferResponseDto("asfd", "id", "asds", "4"),
                        new JobOfferResponseDto("agsd", "id", "asds", "5"),
                        new JobOfferResponseDto("adfvsd", "id", "asds", "6")
                )
        );
        this.offerRepository = new InMemoryOfferRepository();
    }

    OfferFacadeTestConfiguration(List<JobOfferResponseDto> remoteClientOffers) {
        this.inMemoryFetcherTest = new InMemoryFetcherTestImpl(remoteClientOffers);
        this.offerRepository = new InMemoryOfferRepository();
    }

    OfferFacade offerFacadeForTests() {
        return new OfferFacade(offerRepository, new OfferService(inMemoryFetcherTest, offerRepository));
    }
}