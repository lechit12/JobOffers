package org.joboffers.domain.offer;


import org.joboffers.domain.offer.dto.JobOfferResponseDto;
import org.joboffers.domain.offer.dto.OfferRequestDto;
import org.joboffers.domain.offer.dto.OfferResponseDto;

public class OfferMapper {

    public static OfferResponseDto mapFromOfferToOfferDto(Offer offer) {
        return OfferResponseDto.builder()
                .id(offer.id())
                .companyName(offer.companyName())
                .position(offer.position())
                .salary(offer.salary())
                .offerUrl(offer.offerUrl())
                .build();
    }

    public static Offer mapFromOfferDtoToOffer(OfferRequestDto offerRequestDto) {
        return Offer.builder()
                .companyName(offerRequestDto.companyName())
                .salary(offerRequestDto.salary())
                .position(offerRequestDto.position())
                .offerUrl(offerRequestDto.offerUrl())
                .build();
    }

    public static Offer mapFromJobOfferResponseToOffer(JobOfferResponseDto jobOfferResponseDto) {
        return Offer.builder()
                .companyName(jobOfferResponseDto.company())
                .salary(jobOfferResponseDto.salary())
                .position(jobOfferResponseDto.title())
                .offerUrl(jobOfferResponseDto.offerUrl())
                .build();
    }
}
