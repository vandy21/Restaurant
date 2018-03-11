package com.vann.RestaurantB.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.vann.RestaurantB.Dao.CartItemDao;
import com.vann.RestaurantB.Model.CartItem;

@Repository("cartItemDao")
@EnableTransactionManagement
public class CartItemDaoImpl implements CartItemDao {
	@Autowired 
	public SessionFactory sessionFactory;
	
	
	public CartItemDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
@Transactional
	public boolean saveupdate(CartItem cartItem)
	{
	sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
		return true;
	}

@Transactional
	public boolean delete(String cartItemId)
	{
//	System.out.println(CAT_ID);
	CartItem CARTI =new CartItem();
	CARTI.setCartItemId(cartItemId);
	sessionFactory.getCurrentSession().delete(CARTI);

	
		return true;
	}
@Transactional
	public CartItem get(String cartItemId)
	{
	System.out.println(cartItemId);
	String hql="from CartItem where cartItemId='"+cartItemId+"'";
	Query q = sessionFactory.getCurrentSession().createQuery(hql);
	List<CartItem> list1 = (List<CartItem>)q.list();
	if(list1 ==null || list1.isEmpty())
	{
	
		return null;
	}else{
		return list1.get(0);
	}
	}


@Transactional
	public List<CartItem> list()
	{
	@SuppressWarnings("unchecked")
	List<CartItem>listcarti=(List<CartItem>)sessionFactory.getCurrentSession().createCriteria(CartItem.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	
		return listcarti;
	}
@Transactional
public List<CartItem> getlistbyproId(String productId) {
	System.out.println(productId);
	String hql="from CartItem where productId ='"+productId+"'";
	Query q = sessionFactory.getCurrentSession().createQuery(hql);
	List<CartItem> list1 = (List<CartItem>)q.list();
	if(list1 ==null || list1.isEmpty())
	{
	
		return null;
	}else{
		return list1;
	}
}

@Transactional
public List<CartItem> getlistbycartId(String cartId)
{
	String hql="from CartItem where cartId='"+cartId+"'";
	Query q = sessionFactory.getCurrentSession().createQuery(hql);
	List<CartItem> list1 = (List<CartItem>)q.list();
	if(list1 ==null || list1.isEmpty())
	{
	
		return null;
	}else{
		return list1;
	}
}
@Transactional
public CartItem getListall(String cartItemId,String productId){
	String hql="from CartItem where cartItemId ='"+cartItemId+"' and productId = '"+productId+"'";
	Query q = sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<CartItem> list1 = (List<CartItem>)q.list();
	if(list1 ==null || list1.isEmpty())
	{
	
		return null;
	}else{
		return list1.get(0);
	}}
	


}
