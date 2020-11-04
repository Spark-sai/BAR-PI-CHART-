package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Uom;

public interface UomRepo extends JpaRepository<Uom, Integer>
{	
	/**
	 * this method and query fetch the UomModel count from Uom table
	 * @param UomModel
	 * @return  count number
	 */
	
	
	@Query("SELECT COUNT(UomModel) FROM Uom WHERE UomModel=:UomModel")
	Integer getUomModelCount(String UomModel);
	
	
		@Query("SELECT UomType , COUNT(UomType) FROM Uom GROUP BY UomType")
		List<Object[]> getUomTypeAndCount();

}
