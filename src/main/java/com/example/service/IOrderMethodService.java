package com.example.service;

import java.util.List;

import com.example.model.OrderMethod;

public interface IOrderMethodService {

	public Integer SaveOrder(OrderMethod OM);

	public void UpdateOrder(OrderMethod OM);

	public OrderMethod EditOrder(Integer id);

	public void DeleteOrder(Integer id);

	public List<OrderMethod> GetAllOrder();

	public OrderMethod GetOneOrder(Integer id);

}
