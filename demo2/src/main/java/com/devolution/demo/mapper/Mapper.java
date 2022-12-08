package com.devolution.demo.mapper;

import com.devolution.demo.entity.*;
import com.devolution.demo.response.*;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
public class Mapper {

    public UserResponse map(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setAge(user.getAge());
        userResponse.setName(user.getName());
        if (user.getPurchaseSet() != null && !user.getPurchaseSet().isEmpty())
            userResponse.setPurchaseSet(user.getPurchaseSet().stream().map(this::map).collect(Collectors.toSet()));
        return userResponse;
    }

    public PurchaseResponse map(Purchase purchase) {
        PurchaseResponse purchaseResponse = new PurchaseResponse();
        purchaseResponse.setName(purchase.getName());
        purchaseResponse.setDateCreated(map(purchase.getDateCreated()));
        purchaseResponse.setDateUpdated(map(purchase.getDateUpdated()));
        if (purchase.getHotels() != null && !purchase.getHotels().isEmpty())
            purchaseResponse.setHotels(purchase.getHotels().stream().map(this::map).collect(Collectors.toSet()));
        return purchaseResponse;
    }

    public LocalDateTime map(Timestamp timestamp) {
        if (timestamp != null) {
            return timestamp.toLocalDateTime();
        }
        return null;
    }

    public HotelsResponse map(Hotels hotels){
        HotelsResponse hotelsResponse = new HotelsResponse();
        hotelsResponse.setCity(hotels.getCity());
        hotelsResponse.setCountry(hotels.getCountry());
        hotelsResponse.setStars(hotels.getStars());
        hotelsResponse.setName(hotelsResponse.getName());
        if (hotels.getApartaments() != null && !hotels.getApartaments().isEmpty())
            hotelsResponse.setApartaments(hotels.getApartaments());
        return hotelsResponse;
    }


    public ApartamentResponse map(Apartaments apartaments){
        ApartamentResponse apartamentResponse = new ApartamentResponse();
        apartamentResponse.setRooms(apartaments.getRooms());
        apartamentResponse.setSeasight(apartaments.getSeasight());
        apartamentResponse.setIs_reservated(apartaments.getIs_reservated());
        return apartamentResponse;

    }


}
