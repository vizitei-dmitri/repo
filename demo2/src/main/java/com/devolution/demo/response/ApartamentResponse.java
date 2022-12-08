package com.devolution.demo.response;

import com.devolution.demo.entity.Hotels;
import lombok.Data;
import java.math.BigInteger;
import java.util.Set;
@Data
public class ApartamentResponse {

    private BigInteger rooms;

    private Boolean seasight;

    private Boolean is_reservated;

    private BigInteger reservation_time;

    private Set<Hotels> hotels;
}
