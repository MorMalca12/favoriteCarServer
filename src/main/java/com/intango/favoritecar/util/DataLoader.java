package com.intango.favoritecar.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intango.favoritecar.car.Car;
import com.intango.favoritecar.car.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    private final CarRepository carRepository;

    private static ObjectMapper objectMapper;


    @Autowired
    public DataLoader(CarRepository carRepository){
        this.carRepository = carRepository;
        objectMapper = new ObjectMapper();
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(this.carRepository.count() == 0) {
            String file = "src/main/resources/static/cars.json";
            String jsonString = readFileAsString(file);
            this.carRepository.saveAll(Arrays.asList(objectMapper.readValue(jsonString, Car[].class)));
        }

    }

    public String readFileAsString(String file) throws Exception {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}
