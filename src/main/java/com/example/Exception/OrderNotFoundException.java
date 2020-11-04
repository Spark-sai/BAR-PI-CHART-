package com.example.Exception;

public class OrderNotFoundException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public OrderNotFoundException() 
	{
		super();
	}
	public OrderNotFoundException(String Message) 
	{
		super(Message);
	}



}
