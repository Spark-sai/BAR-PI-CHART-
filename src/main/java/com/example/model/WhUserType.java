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
@Table(name = "whuserType_tab")
public class WhUserType {

	@Id
	@GeneratedValue
	@Column(name = "whuser_Type_Col")
	private String UserType;

	@Column(name = "whuser_Code_Col")
	private String UserCode;

	@Column(name = "whuser_For_Col")
	private String UserFor;
	@Column(name = "whuser_Email_Col")
	private String UserEmail;

	@Column(name = "whuser_Contact_Col")
	private Integer UserContact;

	@ElementCollection
	@CollectionTable(name = "whuser_Id_tab",joinColumns = @JoinColumn(name="whuser_Type_Col" ))
	@Column(name = "whuser_IdType_col")
	private List<String> UserIdType;

	@Column(name = "whuser_Ifother_Col")
	private String UserIfOther;

	@Column(name = "whuser_IdNumber_Col")
	private String USerIdNumber;

}
