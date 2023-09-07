package org.joboffers.domain.offer;

import org.joboffers.domain.offer.dto.OfferRequestDto;
import org.joboffers.domain.offer.dto.OfferResponseDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class OfferFacadeTest {

    @Test
    public void it_should_return_all_offers()
    {
        OfferFacade offerFacade = new OfferFacadeTestConfiguration(List.of()).offerFacadeForTests();
    }
    @Test
    public void it_should_return_offer_by_id()
    {
        OfferFacade offerFacade=new OfferFacadeTestConfiguration(List.of()).offerFacadeForTests();
        OfferResponseDto offerResponseDto = offerFacade.saveOffer(new OfferRequestDto("id","asds","sds","1"));

        OfferResponseDto offerById=offerFacade.findOfferById(offerResponseDto.id());


        assertThat(offerById).isEqualTo(OfferResponseDto.builder()
                .id(offerResponseDto.id())
                .companyName("id")
                .position("asds")
                .salary("sds")
                .offerUrl("1")
                .build()
        );
    }

}