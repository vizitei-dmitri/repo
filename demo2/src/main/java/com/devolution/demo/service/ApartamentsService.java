package com.devolution.demo.service;

import com.devolution.demo.entity.Apartaments;
import com.devolution.demo.repository.ApartamentsRepository;
import com.devolution.demo.request.ApartamentsRequest;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ApartamentsService {
    private final ApartamentsRepository apartamentsRepository;

    public ApartamentsService(ApartamentsRepository apartamentsRepository) {
        this.apartamentsRepository = apartamentsRepository;
    }

    public Apartaments addApartament(ApartamentsRequest apartamentsRequest) throws ParseException {
        Apartaments apartaments = new Apartaments();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/hh:mm");

        String dataDate = apartamentsRequest.getReservation_time_start();
        String dataDateEnd = apartamentsRequest.getReservation_time_finish();
//
        apartaments.setReservation_time_start(apartamentsRequest.getReservation_time_start());
        apartaments.setReservation_time_finish(apartamentsRequest.getReservation_time_finish());
//
        String localDate = apartamentsRequest.getReservation_time_start();
        String localDateEnd = apartamentsRequest.getReservation_time_finish();

        Date l1 = sdf.parse(localDate);
        Date l2 = sdf.parse(localDateEnd);
        Date d1 = sdf.parse(dataDate);
        Date d2 = sdf.parse(dataDateEnd);

        if ((l1.before(d1) && l2.before(d2)) || (l1.after(d1) && l2.after(d2))) {
            long diff = l2.getTime() - l1.getTime();
            System.out.println("your time is:" + diff / (1000 * 3600));
            apartaments.setIs_reservated(apartamentsRequest.getIs_reservated());
            apartaments.setRooms(apartamentsRequest.getRooms());
            apartaments.setSeasight(apartamentsRequest.getSeasight());
            apartaments.setHotels(apartamentsRequest.getHotels());

        } else {
            System.out.println("no time available");
        }
//        apartaments.setReservation_time(apartamentsRequest.getReservation_time());

        if (apartaments.getIs_reservated() != false) {
            apartamentsRepository.save(apartaments);
            return apartaments;
        }
        return apartaments;
    }

    public Apartaments updateApartaments(Long id, ApartamentsRequest apartamentsRequest) {
        Optional<Apartaments> apartaments = apartamentsRepository.findById(id);

        if (apartaments.isPresent()) {
            apartaments.get().setRooms(apartamentsRequest.getRooms());
            apartaments.get().setSeasight(apartamentsRequest.getSeasight());
            apartaments.get().setIs_reservated(apartamentsRequest.getIs_reservated());
            apartaments.get().setReservation_time_start(apartamentsRequest.getReservation_time_start());
            apartaments.get().setReservation_time_finish(apartamentsRequest.getReservation_time_finish());

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