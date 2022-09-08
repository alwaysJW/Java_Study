package com.pas.dao;

import com.pas.domain.Car;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface CarDao {
    int findTotalCount(Map<String, String[]> condition);

    List<Car> findByPage(int start, int rows, Map<String, String[]> condition);

    void addCar(Car car);

    Car findUserById(int id);

    void updateCar(Car car);

    void deleteCar(int id);

    void deleteCar(int id, Timestamp time);
}
