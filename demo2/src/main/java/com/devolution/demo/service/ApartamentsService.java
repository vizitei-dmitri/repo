package com.devolution.demo.service;

import com.devolution.demo.entity.Apartaments;
import com.devolution.demo.entity.Hotels;
import com.devolution.demo.repository.ApartamentsRepository;
import com.devolution.demo.repository.HotelsRepository;
import com.devolution.demo.request.ApartamentsRequest;
import com.devolution.demo.request.HotelsRequest;

import java.util.List;
import java.util.Optional;

public class ApartamentsService {
    private final ApartamentsRepository apartamentsRepository;

    public ApartamentsService(ApartamentsRepository apartamentsRepository) {
        this.apartamentsRepository = apartamentsRepository;
    }

    public Apartaments addApartament(ApartamentsRequest apartamentsRequest) {
        Apartaments apartaments = new Apartaments();
        apartaments.setRooms(apartamentsRequest.getRooms());
        apartaments.setSeasight(apartamentsRequest.getSeasight());

        apartaments.setIs_reservated(apartamentsRequest.getIs_reservated());
        apartaments.setReservation_time(apartamentsRequest.getReservation_time());

        apartaments.setHotels(apartamentsRequest.getHotels());
        apartaments.setRooms(apartamentsRequest.getRooms());

        apartamentsRepository.save(apartaments);
        return apartaments;
    }

    public Apartaments updateApartaments(Long id, ApartamentsRequest apartamentsRequest) {
        Optional<Apartaments> apartaments =apartamentsRepository.findById(id);

        if (apartaments.isPresent()) {
            apartaments.get().setRooms(apartamentsRequest.getRooms());
            apartaments.get().setSeasight(apartamentsRequest.getSeasight());
            apartaments.get().setIs_reservated(apartamentsRequest.getIs_reservated());
            apartaments.get().setReservation_time(apartamentsRequest.getReservation_time());

            apartaments.get().setHotels(apartamentsRequest.getHotels());
            apartaments.get().setRooms(apartamentsRequest.getRooms());
            return apartaments.get();
        }
        return new Apartaments();
    }

    public Apartaments getApartaments(Long id) {
        Optional<Apartaments> apartaments = ApartamentsRepository.findById(id);
        return apartaments.orElseGet(Apartaments::new);
    }

    public List<Apartaments> getApartaments() {
        List<Apartaments> apartaments = ApartamentsRepository.findApartaments();
        return apartaments;
    }

    public String deleteApartaments(Long id) {
        Optional<Apartaments> apartaments = apartamentsRepository.findById(id);
        if (apartaments.isPresent()) {
            apartamentsRepository.delete(apartaments.get());
            return "Apartament was deleted successfully";
        }
        return "Apartament was not found";
    }
}
