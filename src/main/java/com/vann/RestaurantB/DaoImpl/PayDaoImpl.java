package com.vann.RestaurantB.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.vann.RestaurantB.Dao.PayDao;
import com.vann.RestaurantB.Model.Pay;

@Repository("payDao")
@EnableTransactionManagement
public class PayDaoImpl implements PayDao{
	@Autowired 
	public SessionFactory sessionFactory;	
	
	public PayDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
	@Transactional
	public boolean saveupdate(Pay pay){
		sessionFactory.getCurrentSession().saveOrUpdate(pay);
		return true;
		
	}
	@Transactional
	public boolean delete(String payId){
		Pay PAY =new Pay();
		PAY.setPayId(payId);
		sessionFactory.getCurrentSession().delete(PAY);
		
			return true;
		
	}
	@Transactional
	public Pay get(String payId){
		System.out.println(payId);
		String hql="from Pay where PAYId ='"+payId+"'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<Pay> list1 = (List<Pay>)q.list();
		if(list1 ==null || list1.isEmpty())
		{
		
			return null;
		}else{
			return list1.get(0);
		}
		
	}
	@Transactional
	public List<Pay> list(){
		@SuppressWarnings("unchecked")
		List<Pay>listp=(List<Pay>)sessionFactory.getCurrentSession().createCriteria(Pay.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
			return listp;
		}

	

}
