package com.example.service.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.IDocumentRepo;
import com.example.model.Document;
import com.example.service.IDocumentService;

@Service
public class DocumentServiceImple implements IDocumentService
{
	@Autowired
	private IDocumentRepo repo;

	@Override
	public void SaveDocument(Document doc) {
		
		repo.save(doc);
	}

	@Override
	public List<Object[]> getDocumentIdAndName() {
		return repo.getDocumentIdAndName();
	}

	@Override
	public Optional<Document> GetOneDocument(Integer id) {
		return repo.findById(id);
	}
	
}
