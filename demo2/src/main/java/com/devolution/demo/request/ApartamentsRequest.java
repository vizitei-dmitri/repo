package com.devolution.demo.request;

import com.devolution.demo.entity.Hotels;
import lombok.Data;
import java.math.BigInteger;
import java.util.Set;

@Data
public class ApartamentsRequest {

    private BigInteger rooms;

    private Boolean seasight;

    private Boolean is_reservated;

    private String reservation_time_start;

    private String reservation_time_finish;

    private Set<Hotels> hotels;
}
