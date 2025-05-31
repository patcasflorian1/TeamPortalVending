package org.eurovending.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.eurovending.model.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class ElementDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Transactional
	public void createElement(Element element) {
		this.hibernateTemplate.save(element);
	}
	public List<Element> getAllElements() {
		return this.hibernateTemplate.loadAll(Element.class);
	}
	@Transactional
	public void deleteElement(int idElement) {
		Element element = this.hibernateTemplate.load(Element.class, idElement);
		this.hibernateTemplate.delete(element);
	}
	@Transactional
	public Element getSingleElement(int idElement) {
		return this.hibernateTemplate.get(Element.class, idElement);
	}
	@Transactional
	public void updateElement(Element element) {
		this.hibernateTemplate.update(element);
	}

}
