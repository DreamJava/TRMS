package com.moflexy.dao;

import java.util.List;

import com.moflexy.domain.Car;
import com.moflexy.exception.CarInsertionException;

public interface EventDAO {
	
	public List<Car> retrieveAllCars();
	
	public void insertCar(Car car) throws CarInsertionException;

}
