package com.example.service;

import java.util.List;

import com.example.model.Shipment;

public interface IShipmentService {

	public Integer SaveShipment(Shipment ship);

	public List<Shipment> GetAllShipment();

	public Shipment GetOneShipment(Integer id);

	public void UpdateShipment(Shipment ship);

	void deleteShipment(Integer id);
	
	
	/**
	 * this method is check the  ShipmentCode is exit  are not based on the count
	 * @param ShipmentCode  if count 0 is not exit  1 is exit
	 * @return   true or flase
	 */

	public boolean IsShipmentIsExit(String ShipmentCode);
	
	
	
	
	public List<Object[]> getShipmentModeAndCount();

}
