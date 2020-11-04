package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Shipment;

public interface IShipmentRepo extends JpaRepository<Shipment, Integer> {
	/**
	 * this method and query fetch the ShipmentCode count from Shipment table
	 * 
	 * @param ShipmentCode
	 * @return count number
	 */
	@Query("SELECT COUNT(ShipmentCode) FROM Shipment where ShipmentCode=:ShipmentCode")
	Integer GetShipmentCodeCount(String ShipmentCode);

	@Query("SELECT ShipmentMode, count(ShipmentMode) from Shipment group by ShipmentMode")
	List<Object[]> GetShipmentModeAndCount();
}
