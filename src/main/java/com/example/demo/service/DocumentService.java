package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DocumentIDAO;
import com.example.demo.entity.DocumentRH;

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

	public void ajoutDocumentService(DocumentRH doc) {
		docDAO.save(doc);
	}

	public void supprimerDocumentService(DocumentRH doc) {
		docDAO.delete(doc);
	}

	public DocumentRH getByIdDocument(Long idDocument) {
		return docDAO.getOne(idDocument);
	}

	public List<DocumentRH> getAllDocument() {
		return docDAO.findAll();
	}

	public void updateDocumentService(DocumentRH doc) {
		docDAO.saveAndFlush(doc);
	}
	
	public List<DocumentRH> getDocByName(String name){
		List<DocumentRH> lstDocRH = docDAO.findAll();
		if (name!=null) {
			List<DocumentRH> lstF = new ArrayList<>();
			ListIterator<DocumentRH> lstIt = lstDocRH.listIterator();
			while (lstIt.hasNext()) {
				DocumentRH doc = lstIt.next();
				if (doc.getEmploye().getNomEmploye().contains(name)) {
					lstF.add(doc);
				}
			}
			return lstF;
		}else {
			return lstDocRH;
		}
	}
	
}
