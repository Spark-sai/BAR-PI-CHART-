package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Document;

public interface IDocumentService 
{
	void SaveDocument(Document doc);
	List<Object[]>getDocumentIdAndName();
	Optional<Document>GetOneDocument(Integer id);

}
