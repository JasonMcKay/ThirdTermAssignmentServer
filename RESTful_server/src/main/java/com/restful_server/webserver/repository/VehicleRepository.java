package com.restful_server.webserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restful_server.webserver.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
