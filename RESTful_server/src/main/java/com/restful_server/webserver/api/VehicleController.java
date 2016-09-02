package com.restful_server.webserver.api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restful_server.webserver.model.Vehicle;
import com.restful_server.webserver.service.VehicleService;

@SuppressWarnings("all")
@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(value="api/vehicles", method=RequestMethod.GET)
	public ResponseEntity<List<Vehicle>> getVehicles(){
		System.out.println("in getAll" );
		List<Vehicle> vehicles = vehicleService.findAll();
		System.out.println("in getAll size: " + vehicles.size() );
		return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
	}
	
	@RequestMapping(value="api/vehicles/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<Vehicle>> getVehicle(@PathVariable("id") Long id){
		System.out.println("id: " + id);
		Vehicle vehicle = vehicleService.findOne(id);
		List<Vehicle> veh = new ArrayList<Vehicle>();
		veh.add(vehicle);
		if(vehicle == null){
			return new ResponseEntity<List<Vehicle>>(HttpStatus.NOT_FOUND);
		}
		System.out.println("in getOne : " + vehicle.getEngine());

		return new ResponseEntity<List<Vehicle>>(veh, HttpStatus.OK);				
	}
	
	@RequestMapping(value="/api/vehicles", method=RequestMethod.POST)
	public ResponseEntity<List<Vehicle>> createVehicle(@RequestBody Vehicle vehicle){
		System.out.println(vehicle.getEngine() + "***" + vehicle.getDoors());
		Vehicle newVehicle = vehicleService.create(vehicle);
		List<Vehicle> veh = new ArrayList<Vehicle>();
		veh.add(newVehicle);
		System.out.println("in create : " + newVehicle.getEngine() + "***" + newVehicle.getId());
		return new ResponseEntity<List<Vehicle>>(veh, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/api/vehicles/{id}", method=RequestMethod.PUT)
	public ResponseEntity<List<Vehicle>> updateVehicle(@RequestBody Vehicle vehicle){
		System.out.println(vehicle.getEngine());
		Vehicle modifiedVehicle = vehicleService.update(vehicle);
		if(modifiedVehicle == null){
			return new ResponseEntity<List<Vehicle>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		List<Vehicle> veh = new ArrayList<Vehicle>();
		veh.add(modifiedVehicle);
		System.out.println("in modify : " + modifiedVehicle.getEngine());
		return new ResponseEntity<List<Vehicle>>(veh, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/vehicles/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Vehicle> deleteVehicle(@PathVariable("id") Long id){
		vehicleService.delete(id);
		return new ResponseEntity<Vehicle>(HttpStatus.OK);
	}
}




































