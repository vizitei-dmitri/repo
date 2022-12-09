package com.devolution.demo.controller;

import com.devolution.demo.mapper.Mapper;
import com.devolution.demo.request.ApartamentsRequest;
import com.devolution.demo.request.HotelsRequest;
import com.devolution.demo.request.UserRequest;
import com.devolution.demo.response.ApartamentResponse;
import com.devolution.demo.response.HotelsResponse;
import com.devolution.demo.response.UserResponse;
import com.devolution.demo.service.ApartamentsService;
import com.devolution.demo.service.HotelService;
import com.devolution.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {

    private final Mapper mapper;

    private final UserService userService;

    private final HotelService hotelService;

    private final ApartamentsService apartamentsService;

    public Controller(Mapper mapper, UserService userService, HotelService hotelService, ApartamentsService apartamentsService) {
        this.mapper = mapper;
        this.userService = userService;
        this.hotelService = hotelService;
        this.apartamentsService = apartamentsService;
    }

    @PostMapping("/api/user")
    public UserResponse addUser(@RequestBody UserRequest userRequest) {
        return mapper.map(userService.addUser(userRequest));
    }
    @PostMapping("/api/user/hotels")
    public HotelsResponse addHotel(@RequestBody HotelsRequest hotelsRequest){
        return mapper.map(hotelService.addHotel(hotelsRequest));
    }
    @PostMapping("/api/user/hotels/apartaments")
    public ApartamentResponse addApartament(@RequestBody ApartamentsRequest apartamentsRequest){
        return mapper.map(apartamentsService.addApartament(apartamentsRequest));
    }


    @GetMapping("/api/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers().stream().map(mapper::map).collect(Collectors.toList());
    }
    @GetMapping("/api/user/{id}")
    public UserResponse getUser(@PathVariable("id") Long id) {
        return mapper.map(userService.getUser(id));
    }
    @GetMapping("/api/user/hotels")
    public List<HotelsResponse> getHotels() {
        return hotelService.getHotels().stream().map(mapper::map).collect(Collectors.toList());
    }


    @GetMapping("/api/user/hotels/{id}")
    public HotelsResponse getHotel(@PathVariable("id") Long id) {
        return mapper.map(hotelService.getHotels(id));
    }
    @GetMapping("/api/user/hotels/apartaments")
    public List<ApartamentResponse> getApartamnets() {
        return apartamentsService.getApartaments().stream().map(mapper::map).collect(Collectors.toList());
    }
    @GetMapping("/api/user/hotels/apartaments/{id}")
    public ApartamentResponse getApartament(@PathVariable("id") Long id) {
        return mapper.map(apartamentsService.getApartaments(id));
    }


    @PutMapping("/api/user/{id}")
    public UserResponse updateUser(@PathVariable("id") Long id, @RequestBody UserRequest userRequest) {
        return mapper.map(userService.updateUser(id, userRequest));
    }
    @PutMapping("/api/user/hotels/{id}")
    public HotelsResponse updateHotel(@PathVariable("id") Long id, @RequestBody HotelsRequest hotelsRequest) {
        return mapper.map(hotelService.updateHotels(id, hotelsRequest));
    }
    @PutMapping("/api/user/hotels/apartaments/{id}")
    public ApartamentResponse updateApartament(@PathVariable("id") Long id, @RequestBody ApartamentsRequest apartamentsRequest) {
        return mapper.map(apartamentsService.updateApartaments(id, apartamentsRequest));
    }


    @DeleteMapping("/api/user/{id}")
    public String deleteUser(@PathVariable("id") Long id) throws Exception {
        return userService.deleteUser(id);
    }
    @DeleteMapping("/api/user/hotel/{id}")
    public String deleteHotel(@PathVariable("id") Long id) throws Exception {
        return hotelService.deleteHotels(id);
    }
    @DeleteMapping("/api/user/hotel/apartament/{id}")
    public String deleteApartament(@PathVariable("id") Long id) throws Exception {
        return apartamentsService.deleteApartaments(id);
    }


}
