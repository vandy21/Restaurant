package com.vann.RestaurantB.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.vann.RestaurantB.Dao.AuthenticationDao;
import com.vann.RestaurantB.Model.Authentication;

@Repository("AuthenticationDao")
@EnableTransactionManagement
public class AuthenticationDaoImpl implements AuthenticationDao {
	@Autowired
	SessionFactory sessionFactory ;
	
	public AuthenticationDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean saveupdate(Authentication authentication){
		sessionFactory.getCurrentSession().saveOrUpdate(authentication);
		return true;
}
		
		
	@Transactional
	public boolean delete(String roleId){
		Authentication a = new Authentication();
		a.setRoleId(roleId);
		sessionFactory.getCurrentSession().delete(a);
		return true;
	
		
	}
	@Transactional
	public Authentication get(String roleId){
		String g = "From Authentication where roleId = '"+roleId +"'";
		Query q =sessionFactory.getCurrentSession().createQuery(g);
		@SuppressWarnings("unchecked")
		List<Authentication> list = (List<Authentication>)q.list();
		if(list ==null || list.isEmpty()){
			return null;
		}
				
				else
				{
				return list.get(0);	
				}
	}
		
	
	@Transactional
	public List<Authentication> list(){
		@SuppressWarnings("unchecked")
		List<Authentication> LA= (List<Authentication>) sessionFactory.getCurrentSession().createCriteria(Authentication.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return LA;
	}
	}


