package com.intango.favoritecar.car;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class CarController {

    private SimpMessagingTemplate template;
    private CarRepository carRepository;

    @Autowired
    public CarController(SimpMessagingTemplate template, CarRepository carRepository){
        this.template = template;
        this.carRepository = carRepository;

    }
    @MessageMapping("cars/vote")
    @SendTo("/topic/carUpdate")
    public Car vote(Car car) throws Exception {
       this.carRepository.save(car);
        return car;
    }

    @GetMapping("cars/getAll")
    @CrossOrigin(origins = "*")
    public List<Car> getAllCars(){
      return this.carRepository.findAll();
    }
}
