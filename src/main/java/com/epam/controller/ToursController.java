package com.epam.controller;

import com.epam.model.TourOffer;
import com.epam.service.TourOfferService;
import com.epam.validator.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalDate;
import java.util.List;


@Controller
@Slf4j
public class ToursController {
    private final TourOfferService toursOfferService;
    @Autowired
    ToursController(TourOfferService toursOfferService){
        this.toursOfferService = toursOfferService;
    }

    @GetMapping("/listoftours")
    public ModelAndView getToursList() {
        ModelAndView toursModel = new ModelAndView();
        toursModel.addObject("list",toursOfferService.getTours());
        toursModel.setViewName("tours");
        return toursModel;
    }

    @PostMapping("/searchtours")
    public ModelAndView searchTours(@RequestParam String country, @RequestParam String startDate,
                                    @RequestParam String endDate, @RequestParam String numberOfPeople) {
        ModelAndView toursModel = new ModelAndView();
        toursModel.setViewName("homepage");
        try {
            LocalDate addStartDate = Validator.getDate(startDate,true);
            LocalDate addEndDate = Validator.getDate(endDate,true);
            toursModel.addObject("list",toursOfferService.searchTours(null,addStartDate, addEndDate));
            return toursModel;
        } catch (Exception e){
            toursModel.addObject("result",e.getMessage());
            return toursModel;
        }
    }

    @PostMapping("/deletetour")
    public ModelAndView deleteTour(@RequestParam String idOfTour) {
        ModelAndView toursModel = new ModelAndView();
        toursModel.addObject("result",toursOfferService.deleteTour(Integer.valueOf(idOfTour))==1?"Success":"Failed to delete");
        toursModel.setViewName("redirect:/listoftours");
        return toursModel;
    }

    @PostMapping("/addtour")
    public ModelAndView addTour(@RequestParam String tourType, @RequestParam String startDate, @RequestParam String endDate,
                                @RequestParam String country, @RequestParam String city, @RequestParam String hotel,
                                @RequestParam String pricePerPerson, @RequestParam String discount, @RequestParam String tourDescription){
        ModelAndView toursModel = new ModelAndView();
        toursModel.setViewName("addtour");
        try {
            LocalDate addStartDate = Validator.getDate(startDate,false);
            LocalDate addEndDate = Validator.getDate(endDate,false);
            Integer addPricePerPerson = Validator.getInt(pricePerPerson);
            Validator.checkEmpty(tourType);
            Validator.checkEmpty(tourDescription);
            Validator.checkDateDifferent(addStartDate,addEndDate);
            int result = toursOfferService.addTour(TourOffer.builder()
                    .id(1)
                    .tourType(tourType)
                    .startDate(addStartDate)
                    .endDate(addEndDate)
                    .pricePerUnit(addPricePerPerson)
                    .hotelId(1) //stub
                    .description(tourDescription)
                    .discountId(1) //stub
                    .build());

            toursModel.addObject("result",result==1?"Success":"Failed to add");
            return toursModel;

        } catch (Exception e){
            toursModel.addObject("result",e.getMessage());
            return toursModel;
        }
    }

    @PostMapping("/updatetour")
    public ModelAndView updateTour(@RequestParam String tourId, @RequestParam String tourType, @RequestParam String startDate, @RequestParam String endDate,
                                   @RequestParam String country, @RequestParam String city, @RequestParam String hotel,
                                   @RequestParam String pricePerPerson, @RequestParam String discount, @RequestParam String tourDescription) {
        ModelAndView toursModel = new ModelAndView();
        toursModel.setViewName("updatetour");
        try {
            LocalDate addStartDate = Validator.getDate(startDate,false);
            LocalDate addEndDate = Validator.getDate(endDate,false);
            Integer addPricePerPerson = Validator.getInt(pricePerPerson);
            Validator.checkEmpty(tourType);
            Validator.checkEmpty(tourDescription);
            Validator.checkDateDifferent(addStartDate,addEndDate);
            int result = toursOfferService.updateTour(TourOffer.builder()
                    .id(Integer.valueOf(tourId))
                    .tourType(tourType)
                    .startDate(addStartDate)
                    .endDate(addEndDate)
                    .pricePerUnit(addPricePerPerson)
                    .hotelId(1) //stub
                    .description(tourDescription)
                    .discountId(1) //stub
                    .build());

            toursModel.addObject("result",result==1?"Success":"Failed to update");
            return toursModel;

        } catch (Exception e){
            toursModel.addObject("result",e.getMessage());
            return toursModel;
        }
    }

    @GetMapping("/addtour")
    public String getAddTour(){
        return "addtour";
    }
}
