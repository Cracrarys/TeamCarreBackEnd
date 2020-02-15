package com.adaming.rh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.rh.dao.DocumentIDAO;
import com.adaming.rh.entities.DocumentRH;

@Service
public class DocumentService {
	@Autowired
	private DocumentIDAO docDAO;

	public DocumentIDAO getDocDAO() {
		return docDAO;
	}

	public void setDocDAO(DocumentIDAO docDAO) {
		this.docDAO = docDAO;
	}

	public void AjoutDocumentService(DocumentRH doc) {
		docDAO.save(doc);
	}

	public void SupprimerDocumentService(DocumentRH doc) {
		docDAO.delete(doc);
	}

	public DocumentRH GetByIdDocument(Long idDocument) {
		return docDAO.getOne(idDocument);
	}

	public List<DocumentRH> GetAllDocument() {
		return docDAO.findAll();
	}

	public void UpdateDocumentService(DocumentRH doc) {
		docDAO.saveAndFlush(doc);
	}
}
