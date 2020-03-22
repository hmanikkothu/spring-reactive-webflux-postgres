package com.manikkothu.reservationservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Log4j2
@Component
@RequiredArgsConstructor
class SampleDataInitializer{

    private final ReservationRepository reservationRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void ready() {

        var saved = Flux.just("ABC", "DEF", "GHI", "KLM", "NOP", "QRS", "TUV")
                .map(name -> new Reservation(null, name))
                .flatMap(r -> this.reservationRepository.save(r));

        this.reservationRepository
                .deleteAll()
                .thenMany(saved)
                .thenMany(this.reservationRepository.findAll())
                .subscribe(log::info);
    }
}
