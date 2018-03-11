package com.vann.RestaurantB.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.vann.RestaurantB.Dao.ShippingAddressDao;
import com.vann.RestaurantB.Model.ShippingAddress;

@Repository("ShippingAddressDao")
@EnableTransactionManagement
public class ShippingAddressDaoImpl implements ShippingAddressDao{
	@Autowired 
	public SessionFactory sessionFactory;
	
	
	public ShippingAddressDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
@Transactional
public boolean saveupdate( ShippingAddress shippingAddress){
	sessionFactory.getCurrentSession().saveOrUpdate(shippingAddress);
	return true;
}
@Transactional
public boolean delete(String shippingId){
	ShippingAddress SA =new ShippingAddress();
	SA.setShippingId(shippingId);
	sessionFactory.getCurrentSession().delete(SA);

	
		return true;

	
}
@Transactional
public ShippingAddress get(String shippingId){
	System.out.println(shippingId);
	String hql="from shippingAddress where shippingId ='"+ shippingId+"'";
	Query q = sessionFactory.getCurrentSession().createQuery(hql);
	List<ShippingAddress> list1 = (List<ShippingAddress>)q.list();
	if(list1 ==null || list1.isEmpty())
	{
	
		return null;
	}else{
		return list1.get(0);
	}
	
}
@Transactional
public List<ShippingAddress> list(){
	@SuppressWarnings("unchecked")
	List<ShippingAddress>lists=(List<ShippingAddress>)sessionFactory.getCurrentSession().createCriteria(ShippingAddress.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	
		return lists;
	}
@Transactional
public List<ShippingAddress> getlistbyU_Id(String userId){
	String hql="from ShippingAddress where userId ='"+userId+"'";
	Query q = sessionFactory.getCurrentSession().createQuery(hql);
	List<ShippingAddress> list1 = (List<ShippingAddress>)q.list();
	if(list1 ==null || list1.isEmpty())
	{
	
		return null;
	}else{
		return list1;
	
	
}

	
}

}
