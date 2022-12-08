package com.devolution.demo.service;

import com.devolution.demo.entity.Apartaments;
import com.devolution.demo.entity.Purchase;
import com.devolution.demo.repository.ApartamentsRepository;
import com.devolution.demo.request.ApartamentsRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ApartamentsService {
    private final ApartamentsRepository apartamentsRepository;

    public ApartamentsService(ApartamentsRepository apartamentsRepository) {
        this.apartamentsRepository = apartamentsRepository;
    }

    public Apartaments addApartament(ApartamentsRequest apartamentsRequest) {
        Apartaments apartaments = new Apartaments();
        Purchase purchase = new Purchase();

        apartaments.setRooms(apartamentsRequest.getRooms());
        apartaments.setSeasight(apartamentsRequest.getSeasight());

        apartaments.setIs_reservated(apartamentsRequest.getIs_reservated());
        apartaments.setReservation_time(apartamentsRequest.getReservation_time());

        apartaments.setHotels(apartamentsRequest.getHotels());
        apartaments.setRooms(apartamentsRequest.getRooms());

        if (apartaments.getIs_reservated()!=false){
            apartamentsRepository.save(apartaments);
            return apartaments;
        }
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
        Optional<Apartaments> apartaments = apartamentsRepository.findById(id);
        return apartaments.orElseGet(Apartaments::new);
    }

    public List<Apartaments> getApartaments() {
        List<Apartaments> apartaments = apartamentsRepository.findAll();
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
