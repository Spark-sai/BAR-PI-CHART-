package com.example.Controller;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Util.ShipmentUtil;
import com.example.model.Shipment;
import com.example.service.IShipmentService;

@Controller
@RequestMapping("/Shipment")
public class ShipmentControll
{
	@Autowired
	private IShipmentService service;
	
	@Autowired
	private ShipmentUtil util;
	
	@Autowired
	private ServletContext sc;

	@GetMapping("/Register")
	public String RegisterShipment( Model model)
	{
		model.addAttribute("ship", new Shipment());
		return "ShipmentRegister";
	}
	
	@PostMapping("/save")
	public String SaveShipment(@ModelAttribute Shipment ship, Model model)
	{
		Integer id=service.SaveShipment(ship);
		
		String message= "shiment is register '"+id+"'";
		
		model.addAttribute("F1", message);
		
		model.addAttribute("ship", new Shipment());
		return "ShipmentRegister";
	}
	
	
	@GetMapping("/all")
	public String GetAllShipment(@ModelAttribute Shipment ship, Model model)
	{
		List<Shipment> list=service.GetAllShipment();
		
		model.addAttribute("F2", list);
		
		return "ShipmentData";
	}
	
	@GetMapping("/Edit")
	public String EditShipment(@RequestParam Integer id,
			Model model)
	{
		Shipment s=service.GetOneShipment(id);
		model.addAttribute("F3",s);
		return "ShipmentEdit";
	}
	
	@GetMapping("/Deleted")
	public String DeleteShipment(@RequestParam Integer id,
			Model model)
	{
		service.deleteShipment(id);
		model.addAttribute("F4","Shipment is '"+id+"'  deleted");
		model.addAttribute("F2", service.GetAllShipment());
		return "ShipmentData";	
	}
	
	@PostMapping("/Update")
	public String UpdateShipment(@ModelAttribute Shipment shipment,
			Model model)
	{
		service.UpdateShipment(shipment);
		model.addAttribute("F5","Shipment is  '"+shipment.getShipmentID()+"' is updated");
		model.addAttribute("F2", service.GetAllShipment());
		return "ShipmentData";
	}
	
	
	
	/**
	 * this method takes the http request 
	 * and call the service method 
	 * @param Code it takes the true are flase 
	 * 
	 * @return  if condition is true and return the message 
 	 */
	
	
	@GetMapping("/validate")
	public @ResponseBody String ValidateShipmentCode(
			@RequestParam String Code)
	{
		String Message= "";	
		if (service.IsShipmentIsExit(Code)) 
		{
			Message= "SHIPMENT CODE IS ALREADY REGISTER '"+Code+"'";
		}
	return Message;
	}
	
	
	@GetMapping("/charts")
	public String ShipmentCharts()
	{
		List<Object[]> data=service.getShipmentModeAndCount();
		
		String path=sc.getRealPath("/");
		util.generatepic(path, data);
		util.Generatebar(path, data);
		
		return "Shipmentcharts";
	}
	
}

