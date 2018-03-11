package com.vann.RestaurantB.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.vann.RestaurantB.Dao.CartDao;
import com.vann.RestaurantB.Model.Cart;

@Repository("cartDao")
@EnableTransactionManagement

public class CartDaoImpl implements CartDao {
	@Autowired 
	public SessionFactory sessionFactory;
	
	
	public CartDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
@Transactional
	public boolean saveupdate(Cart card)
	{
	sessionFactory.getCurrentSession().saveOrUpdate(card);
		return true;
	}
@Transactional
public boolean delete(String cartId)
{
//System.out.println(CART_ID);
Cart CA =new Cart();
CA.setCartId(cartId);
sessionFactory.getCurrentSession().delete(CA);


	return true;
}
@Transactional
public Cart get(String cartId)
{
System.out.println(cartId);
String hql="from Cart where cartId ='"+cartId+"'";
Query q = sessionFactory.getCurrentSession().createQuery(hql);
List<Cart> list1 = (List<Cart>)q.list();
if(list1 ==null || list1.isEmpty())
{

	return null;
}else{
	return list1.get(0);
}
}

@Transactional
	public List<Cart> list()
	{
	@SuppressWarnings("unchecked")
	List<Cart>listca=(List<Cart>)sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	
		return listca;
	}


}
