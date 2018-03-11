package com.vann.RestaurantB.DaoImpl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.vann.RestaurantB.Dao.SupplierDao;
import com.vann.RestaurantB.Model.Supplier;

@Repository("supplierDao")
@EnableTransactionManagement
public class SupplierDaoImpl implements SupplierDao {
	@Autowired 
	public SessionFactory sessionFactory;	
	public SupplierDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
		
	@Transactional
	public boolean saveupdate(Supplier sup){
		sessionFactory.getCurrentSession().saveOrUpdate(sup);
		return true;		
	}
	
	@Transactional
	public boolean delete(String supplierId){
		System.out.println(supplierId);
		Supplier sup =new Supplier();
		sup.setSupplierId(supplierId);
		sessionFactory.getCurrentSession().delete(sup);		
			return true;		
	}
	
	@Transactional
	public Supplier get(String supplierId){
		System.out.println(supplierId);
		String hql="from Supplier where supplierId ='"+supplierId+"'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> list1 = (List<Supplier>)q.list();
		if(list1 ==null || list1.isEmpty())
		{
		
			return null;
		}else{
			return list1.get(0);
		}
		
	}
	@Transactional
	public List<Supplier> list(){
		@SuppressWarnings("unchecked")
		List<Supplier>listsup=(List<Supplier>)sessionFactory.getCurrentSession().createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

			return listsup;
		}
		
	}



