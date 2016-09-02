package com.restful_server.webserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restful_server.webserver.model.Vehicle;
import com.restful_server.webserver.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	private VehicleRepository vehicleRepository;

	public List<Vehicle> findAll() {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		return vehicles;
	}

	public Vehicle findOne(Long id) {
		Vehicle vehicle = vehicleRepository.findOne(id);
		return vehicle;
	}

	public Vehicle create(Vehicle vehicle) {
		if(vehicle.getId() != null){
			return null;
		}
		Vehicle newVehicle = vehicleRepository.save(vehicle);
		return newVehicle;
	}

	public Vehicle update(Vehicle vehicle) {
		Vehicle originalVehicle = findOne(vehicle.getId());
		if(originalVehicle == null){
			return null;
		}
		originalVehicle.setEngine(vehicle.getEngine());
		Vehicle newVehicle = vehicleRepository.save(originalVehicle);
		return newVehicle;
	}

	public void delete(Long id) {
		vehicleRepository.delete(id);
		
	}
}
