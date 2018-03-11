package com.vann.RestaurantB.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.vann.RestaurantB.Dao.CategoryDao;
import com.vann.RestaurantB.Model.Category;

@Repository("categoryDao")
@EnableTransactionManagement
public class CategoryDaoImpl implements CategoryDao {
	@Autowired 
	public SessionFactory sessionFactory;
	
	
	public CategoryDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public boolean saveupdate(Category category){
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
		
	}
	@Transactional
	public boolean delete(String categoryId){
		Category cat =new Category();
		cat.setCategoryId(categoryId);
		sessionFactory.getCurrentSession().delete(cat);
		
			return true;		
	}
	@Transactional
	public Category get(String categoryId){
		System.out.println(categoryId);
		String hql="from Category where categoryId ='"+categoryId +"'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> list1 = (List<Category>)q.list();
		if(list1 ==null || list1.isEmpty())
		{
		
			return null;
		}else{
			return list1.get(0);
		}
		
	}
	@Transactional
	public List<Category> list(){
		@SuppressWarnings("unchecked")
		List<Category>listcat=(List<Category>)sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
			return listcat;
		}
		
	}



