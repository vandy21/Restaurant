
package com.vann.RestaurantB.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.vann.RestaurantB.Dao.ProductDao;
import com.vann.RestaurantB.Model.Product;

@Repository("productDao")
@EnableTransactionManagement
public class ProductDaoImpl implements ProductDao {
	
	@Autowired 
	public SessionFactory sessionFactory;
	
	
	public ProductDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
@Transactional
	public boolean saveupdate(Product pro)
	{
	sessionFactory.getCurrentSession().saveOrUpdate(pro);
		return true;
	}
@Transactional
	public boolean delete(String productId)
	{
	System.out.println(productId);
	Product pro =new Product();
	pro.setProductId(productId);
	sessionFactory.getCurrentSession().delete(pro);
	
		return true;
	}
@Transactional
	public Product get(String productId)
	{
		System.out.println(productId);
		String hql="from Product where productId ='"+productId+"'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list1 = (List<Product>)q.list();
		if(list1 ==null || list1.isEmpty())
		{
		
			return null;
		}else{
			return list1.get(0);
		}
		}
	
		
	
@Transactional
	public List<Product> list()
	{
		@SuppressWarnings("unchecked")
		List<Product>listpro=(List<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
			return listpro;
		}
@Transactional
public boolean delete2(Product product){
	try {
		sessionFactory.getCurrentSession().delete(product);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
}
@Transactional
public Product getCategory(String categoryId){
	String hql= "from Product where categoryId ='"+categoryId+"'";
	Query q =sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Product> list1=(List<Product>)q.list();
	if(list1==null || list1.isEmpty())
	{
		return null;
	}
	else
	{
	  return list1.get(0);
	}
	
}


}
