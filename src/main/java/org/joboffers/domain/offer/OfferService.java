package org.joboffers.domain.offer;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
 class OfferService {

    private final OfferFetchable offerFetchable;
    private final OfferRepository offerRepository;
    List<Offer> fetchAllOffersAndSaveAllIfNotExists()  {
        List<Offer> jobOffers = fetchOffers();
        final List<Offer> offers = filterNotExistingOffers(jobOffers);
        try{
            return offerRepository.saveAll(offers);
        }
        catch (OfferDuplicateException duplicateException)
        {
            throw new OfferSavingException(duplicateException.getMessage(),jobOffers);
        }
    }

    private List<Offer> filterNotExistingOffers(List<Offer> jobOffers) {
        return jobOffers.stream()
                .filter(offerDto->!offerDto.offerUrl().isEmpty())
                .filter(offerDto->!offerRepository.existsByOfferUrl(offerDto.offerUrl()))
                .collect(Collectors.toList());
    }

    private List<Offer> fetchOffers() {
        return offerFetchable.fetchOffers()
                .stream()
                .map(OfferMapper::mapFromJobOfferResponseToOffer)
                .toList();
    }
}
