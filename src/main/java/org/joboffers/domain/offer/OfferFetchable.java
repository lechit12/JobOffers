package org.joboffers.domain.offer;

import org.joboffers.domain.offer.dto.JobOfferResponseDto;

import java.util.List;

public interface OfferFetchable {

    List<JobOfferResponseDto> fetchOffers();
}
