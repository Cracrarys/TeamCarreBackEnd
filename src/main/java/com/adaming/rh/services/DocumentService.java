package com.adaming.rh.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
	
	public List<DocumentRH> getDocByEmploye(String name){
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
