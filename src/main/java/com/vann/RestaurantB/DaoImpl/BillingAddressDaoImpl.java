package com.vann.RestaurantB.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.vann.RestaurantB.Dao.BillingAddressDao;
import com.vann.RestaurantB.Model.BillingAddress;

public class BillingAddressDaoImpl implements BillingAddressDao {
	@Autowired 
	public SessionFactory sessionFactory;
	
	
	public BillingAddressDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    @Transactional	
	public boolean saveupdate(BillingAddress BillingAdd){
    	sessionFactory.getCurrentSession().saveOrUpdate(BillingAdd);
		return true;
				
	}

    @Transactional
    public boolean delete(String billingId){
    	BillingAddress BILL =new BillingAddress();
    	BILL.setBillingId(billingId);
    	sessionFactory.getCurrentSession().delete(BILL);
    	
    		return true;
		
	}
    
    @Transactional
	public BillingAddress get(String userId){
    	System.out.println(userId);
    	String bl="from BillingAddress where userId ='"+userId+"'";
    	Query q = sessionFactory.getCurrentSession().createQuery(bl);
    	List<BillingAddress> list1 = (List<BillingAddress>)q.list();
    	if(list1 ==null || list1.isEmpty())
    	{
    	
    		return null;
    	}else{
    		return list1.get(0);
    	}

		
	}
    @Transactional
	public List<BillingAddress> list(){
    	@SuppressWarnings("unchecked")
    	List<BillingAddress>listbl=(List<BillingAddress>)sessionFactory.getCurrentSession().createCriteria(BillingAddress.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    	
    		return listbl;
    	}


}
