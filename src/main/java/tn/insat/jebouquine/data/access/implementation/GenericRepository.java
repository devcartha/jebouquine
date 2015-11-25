package tn.insat.jebouquine.data.access.implementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import tn.insat.jebouquine.data.access.facade.IGenericRepository;

public class GenericRepository<T> implements IGenericRepository<T> {

	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> type;

	public GenericRepository(Class<T> type) {
		this.type = type;
	}

	public void add(T entity) {
		this.sessionFactory.getCurrentSession().persist(entity);
	}

	public void update(T entity) {
		this.sessionFactory.getCurrentSession().update(entity);
	}

	public void delete(T entity) {
		this.sessionFactory.getCurrentSession().delete(entity);
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public T getById(Integer id) {
		T entity = (T) this.sessionFactory.getCurrentSession().get(type, id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		List<T> list = (List<T>) this.sessionFactory.getCurrentSession().createQuery("from " + type.getName()).list();
		return list;
	}

	@Override
	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(type);
	}
	
	@SuppressWarnings("unchecked")
	public T getByCriteria(Criteria criteria) {
		List<T> list = criteria.list();
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<T> listByCriteria(Criteria criteria) {
		List<T> list = criteria.list();
		return list;
	}

	

}
