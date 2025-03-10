package com.epam.service;

import com.epam.model.Hotel;
import com.epam.repository.HotelDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class HotelService {

    private final HotelDAO hotelDAO;
    @Autowired
    public HotelService(HotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }

    public List<Hotel> getHotels(){ return hotelDAO.getHotels(); }

    public List<Hotel> getHotelsByCountry (String country) {
        if (country != null) {
            return hotelDAO.getHotelsByCountry(country);
        }
        else {
            throw new IllegalArgumentException("Country must be specified");
        }
    }

    public Hotel getHotelById (Integer id) {
        if (id != null) {
            return hotelDAO.getHotelById(id);
        }
        else {
            throw new IllegalArgumentException("Id must be specified");
        }
    }

    public Integer createHotel(Hotel hotel) {
        if (hotel.getName() != null) {
            if (hotel.getCountry() != null) {
                return hotelDAO.createHotel(hotel);
            }
            else {
                throw new IllegalArgumentException("Country must be specified");
            }
        } else {
            throw new IllegalArgumentException("Name must be specified");
        }
    }

    public Integer updateHotel (Hotel hotel) {
        if (hotel.getName() != null) {
            if (hotel.getCountry() != null)
                return hotelDAO.updateHotel(hotel);
            else throw new IllegalArgumentException("Country must be specified");
        } else throw new IllegalArgumentException("Name must be specified");
    }

    public Integer deleteHotel (Integer id) {
        if (id != null) {
            return hotelDAO.deleteHotel(id);
        }
        else {
            throw new IllegalArgumentException("Id must be specified");
        }
    }

}