package com.vann.RestaurantB.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.vann.RestaurantB.Dao.OrderDao;
import com.vann.RestaurantB.Model.Order;

@Repository("orderDao")
@EnableTransactionManagement
public class OrderDaoImpl implements OrderDao{
	@Autowired 
	public SessionFactory sessionFactory;
	
	
	public OrderDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public boolean saveupdate(Order  order){
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		return true;
	}
	
	@Transactional
	public boolean delete(String orderId){
		Order OR =new Order();
		OR.setOrderId(orderId);
		sessionFactory.getCurrentSession().delete(OR);

		
			return true;

	}
	@Transactional
	public Order get(String orderId){
		System.out.println(orderId);
		String hql="from Order where orderId ='"+orderId+"'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<Order> list1 = (List<Order>)q.list();
		if(list1 ==null || list1.isEmpty())
		{
		
			return null;
		}else{
			return list1.get(0);
		}
		
	}
	@Transactional
	public List<Order> list(){
		@SuppressWarnings("unchecked")
		List<Order>listorder=(List<Order>)sessionFactory.getCurrentSession().createCriteria(Order.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
			return listorder;
		}


}
