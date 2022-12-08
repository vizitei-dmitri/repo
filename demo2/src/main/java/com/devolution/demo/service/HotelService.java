package com.devolution.demo.service;

import com.devolution.demo.entity.Hotels;
import com.devolution.demo.repository.HotelsRepository;
import com.devolution.demo.request.HotelsRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class HotelService {
    private final HotelsRepository hotelsRepository;

    public HotelService(HotelsRepository hotelsRepository) {
        this.hotelsRepository = hotelsRepository;
    }

    public Hotels addHotel(HotelsRequest hotelsRequest) {
        Hotels hotels = new Hotels();
        hotels.setName(hotelsRequest.getName());
        hotels.setCity(hotelsRequest.getCity());
        hotels.setCountry(hotelsRequest.getCountry());
        hotels.setStars(hotelsRequest.getStars());

        hotels.setApartaments(hotelsRequest.getApartaments());
        hotels.setPurchases(hotelsRequest.getPurchases());

        hotelsRepository.save(hotels);
        return hotels;
    }

    public Hotels updateHotels(Long id, HotelsRequest hotelsRequest) {
        Optional<Hotels> hotels = hotelsRepository.findById(id);

        if (hotels.isPresent()) {
            hotels.get().setName(hotelsRequest.getName());
            hotels.get().setCity(hotelsRequest.getCity());
            hotels.get().setCountry(hotelsRequest.getCountry());
            hotels.get().setStars(hotelsRequest.getStars());

            hotels.get().setApartaments(hotelsRequest.getApartaments());
            hotels.get().setPurchases(hotelsRequest.getPurchases());
            return hotels.get();
        }
        return new Hotels();
    }

    public Hotels getHotels(Long id) {
        Optional<Hotels> hotels = hotelsRepository.findById(id);
        return hotels.orElseGet(Hotels::new);
    }

    public List<Hotels> getHotels() {
        List<Hotels> hotels = hotelsRepository.findAll();
        return hotels;
    }

    public String deleteHotels(Long id) {
        Optional<Hotels> hotels = hotelsRepository.findById(id);
        if (hotels.isPresent()) {
            hotelsRepository.delete(hotels.get());
            return "Hotel was deleted successfully";
        }
        return "Hotel was not found";
    }

}
