 package com.example.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Order_tab")
public class OrderMethod 
{
	@Id
	@GeneratedValue
	@Column(name = "order_ID_Col")
	private Integer OrderId;
	
	@Column(name = "order_Model_Col")
	private String OrderMode;
	
	@Column(name = "order_Code_Col")
	private String OrderCode;
	
	@Column(name = "order_Type_Col")
	private String OrderType;
	
	@ElementCollection
	@CollectionTable(name = "order_Acpt_tab",
	               joinColumns = @JoinColumn(name ="order_Model_Col"))
	@Column(name = "order_Acpt_Col")
	private List<String> OrderAcpt;
	
	@Column(name = "order_Description_Col")
	private String OrderDescription;

}
