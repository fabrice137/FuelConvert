package com.haguma.FuelConvert;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/convert")
public class Controller {

    @GetMapping("/")
    public String milesToKilometers(){
        return "mtk: multiply by 1.6 \nmpg: divide by 2.35";
    }

    @GetMapping("/mtk/{miles}")
    public String milesToKilometers(@PathVariable double miles){

//        System.out.printf("Value with 3 digits after decimal point %.3f %n", PI);
        double km = miles * 1.60934;
        return miles + " Miles = "+ roundNumber(km) +" Km";
    }

    @GetMapping("/mpg/{mpg}")
    public String mpgToKpl(@PathVariable double mpg){

        double kpl = mpg / 2.352;
        return mpg + " MPG = "+ roundNumber(kpl) +" Kilometers per Litre";
    }


    private String roundNumber(double x){
        String s = String.valueOf(x);
        int dotIndex = s.indexOf(".");
        return s.substring(0, dotIndex + 3);
    }

}
