package com.example.service;

import java.util.List;

import com.example.model.WhUserType;

public interface WhUserTypeService {

	/*
	 * This method read the whuser data and perform the save operation 
	 * And return Integer id
	 */
	Integer SaveWhUser(WhUserType whuser);

	Void UpdateWhUser(WhUserType Whuser);

	List<WhUserType> GetALLWhUser();

	WhUserType GetOneWhUser(Integer id);

	Void DeleteWhUser(Integer id);

}
