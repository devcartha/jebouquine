package tn.insat.jebouquine.data.access.facade;

import java.util.*;

import org.hibernate.Criteria;

public interface IGenericRepository<T> {
	public void add(T entity);
	public void update(T entity);
	public T getById(Integer id);
	public List<T> getAll();
	public Criteria getCriteria();
	public T getByCriteria(Criteria criteria);
	public List<T> listByCriteria(Criteria criteria);
	public void delete(T entity);
}
