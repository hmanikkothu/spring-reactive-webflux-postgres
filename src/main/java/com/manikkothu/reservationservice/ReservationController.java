package com.manikkothu.reservationservice;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
class ReservationController {
    private final ReservationRepository reservationRepository;

    @GetMapping("/reservations")
    Flux<Reservation> reservationFlux() {
        return this.reservationRepository.findAll();
    }

    @GetMapping("/hello")
    Flux<Integer> hello() {
        Flux<Integer> ints = Flux.range(1, 3);
        //ints.subscribe(i -> System.out.println(i));
        return ints;
    }
}