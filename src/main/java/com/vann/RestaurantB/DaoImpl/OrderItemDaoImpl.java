package com.vann.RestaurantB.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.vann.RestaurantB.Dao.OrderItemDao;
import com.vann.RestaurantB.Model.OrderItem;

@Repository("orderItemDao")
@EnableTransactionManagement
public class OrderItemDaoImpl implements OrderItemDao{
	@Autowired 
	public SessionFactory sessionFactory;
	
	
	public OrderItemDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
@Transactional
public boolean saveupdate(OrderItem orderItem){
	sessionFactory.getCurrentSession().saveOrUpdate(orderItem);
	return true;
}
@Transactional
public boolean delete(String orderItemId){
	OrderItem OITEM =new OrderItem();
	OITEM.setOrderItemId(orderItemId);
	sessionFactory.getCurrentSession().delete(OITEM);

	
		return true;

}

@Transactional
public OrderItem get(String orderItemId){
	System.out.println(orderItemId);
	String hql="from Category where orderItemId ='"+orderItemId+"'";
	Query q = sessionFactory.getCurrentSession().createQuery(hql);
	List<OrderItem> list1 = (List<OrderItem>)q.list();
	if(list1 ==null || list1.isEmpty())
	{
	
		return null;
	}else{
		return list1.get(0);
	}
	
}
@Transactional
public List<OrderItem> list(){
	@SuppressWarnings("unchecked")
	List<OrderItem>listoi=(List<OrderItem>)sessionFactory.getCurrentSession().createCriteria(OrderItem.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	
		return listoi;
	}


}
