package com.restful_server.webserver.service;

import java.util.List;

import com.restful_server.webserver.model.Vehicle;

public interface VehicleService {

	List<Vehicle> findAll();
	Vehicle findOne(Long id);
	Vehicle create(Vehicle vehicle);
	Vehicle update(Vehicle vehicle);
	void delete(Long id);
}
