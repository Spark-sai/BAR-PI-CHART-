package com.example.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.WhUserRepo;
import com.example.model.WhUserType;
import com.example.service.WhUserTypeService;

@Service
public class WhUserTypeServiceImple  implements WhUserTypeService
{
	
	@Autowired
	private WhUserRepo repo;

	@Override
	public Integer SaveWhUser(WhUserType whuser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void UpdateWhUser(WhUserType Whuser)
	{
		return null;
		 
	}

	@Override
	public List<WhUserType> GetALLWhUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WhUserType GetOneWhUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void DeleteWhUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
