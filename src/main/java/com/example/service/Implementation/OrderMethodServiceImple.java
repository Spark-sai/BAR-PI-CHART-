package com.example.service.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.OrderNotFoundException;
import com.example.Exception.ShipmentNotFoundException;
import com.example.Repository.IOrderMethodRepo;
import com.example.model.OrderMethod;
import com.example.service.IOrderMethodService;

@Service
public class OrderMethodServiceImple implements IOrderMethodService 
{
	@Autowired
	private IOrderMethodRepo repo;

	@Override
	public Integer SaveOrder(OrderMethod OM) 
	{
		return repo.save(OM).getOrderId();
	}

	@Override
	public void UpdateOrder(OrderMethod OM) 
	{
		repo.save(OM);
		
	}

	
	  @Override public OrderMethod EditOrder(Integer id) { return
	  repo.findById(id).orElseThrow(()->new
	  OrderNotFoundException("Order Not Found"));
	  
	  }
	 
	@Override
	public void DeleteOrder(Integer id) 
	{
		Optional<OrderMethod> om=repo.findById(id);
		if(om.isPresent())repo.delete(om.get());
		else throw new OrderNotFoundException("Order is '"+id+"' deleted");
	}

	@Override
	public List<OrderMethod> GetAllOrder() 
	{
		List<OrderMethod> list=repo.findAll();
		list.sort((l1,l2)->l1.getOrderId()-l2.getOrderId());
		return list;
	}

	@Override
	public OrderMethod GetOneOrder(Integer id) 
	{
		return repo.findById(id).
				orElseThrow(() -> new ShipmentNotFoundException("Order not '" + id + "' Found"));
		
	}

	

}
