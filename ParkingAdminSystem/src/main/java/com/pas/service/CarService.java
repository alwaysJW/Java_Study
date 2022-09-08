package com.pas.service;

import com.pas.domain.Car;
import com.pas.domain.PageBean;

import java.util.Map;

public interface CarService {
    PageBean<Car> findCarByPage(String currentPage, String rows, Map<String, String[]> condition);

    void addCar(Car car);

    Car findUserById(String id);

    void updateCar(Car car);

    void deleteCar(String id);

    void outCar(String id);
}
