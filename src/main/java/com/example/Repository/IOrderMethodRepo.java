package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.OrderMethod;

public interface IOrderMethodRepo 
                         extends JpaRepository<OrderMethod, Integer>
{
	

}
