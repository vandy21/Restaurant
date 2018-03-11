package com.vann.RestaurantB.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.vann.RestaurantB.Dao.UserDao;
import com.vann.RestaurantB.Model.Authentication;
import com.vann.RestaurantB.Model.User;

@Repository("userDao")
@EnableTransactionManagement
public class UserDaoImpl implements UserDao{
	@Autowired
	public SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public boolean saveupdate(User user){
		try {
			//BillingAddress b = U.getBillingAddress();
//					b.setEmail_ID(U.getU_EMAIL());
//					b.setMobile_NO(U.getU_PHONENO());
//					b.setUser(U);
//						
					Authentication	authentication =new Authentication();
					authentication.setUserName(user.getUserEmail());
//					user.getBillingAddress().setUser(user);
//					user.getBillingAddress().setMobileNo(user.getUserMobileNo());
//					user.getBillingAddress().setEmailId(user.getUserEmail());
//					sessionFactory.getCurrentSession().save(user.getBillingAddress());		
//					sessionFactory.getCurrentSession().saveOrUpdate(user.getCart());
					sessionFactory.getCurrentSession().saveOrUpdate(user);
					sessionFactory.getCurrentSession().saveOrUpdate(authentication);
						
						
						
						return true;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return false;
					}
	}
	@Transactional
	public boolean delete(String userId){
		System.out.println(userId);
		User user = new User();
		user.setUserId("use123");
		sessionFactory.getCurrentSession().delete(user);

		return true;
	}
	
	
	@Transactional
	public User get(String userId){
		System.out.println(userId);
		String hql="from Category where userId ='"+userId+"'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list1 = (List<User>)q.list();
		if(list1 ==null || list1.isEmpty())
		{
		
			return null;
		}else{
			return list1.get(0);
		}
		
		
	}
	@Transactional
	public List<User> list(){
		@SuppressWarnings("unchecked")
		List<User>listu=(List<User>)sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
			return listu;
		
		
	}

	@Transactional 
	public User isValidated(String userEmail , String userPassword)
	{
		String sql="from User where userEmail ='"+userEmail+"'and userPassword ='"+userPassword+"'";
		@SuppressWarnings("unchecked")
		Query q4 = sessionFactory.getCurrentSession().createQuery(sql);
		List<User> list = (List<User>)q4.list();
		if(list==null || list.isEmpty()){
			return null;
		}
		else{
			return list.get(0);
		}
	}
@Transactional
	public User getUserEmail(String userEmail) {
		
		String sql="from User where userEmail='"+userEmail+"'";
		@SuppressWarnings("unchecked")
		Query q4 = sessionFactory.getCurrentSession().createQuery(sql);
		List<User> list = (List<User>)q4.list();
		if(list==null || list.isEmpty()){
		// TODO Auto-generated method stub
		return null;
	}
		else{
			return list.get(0);
		}
}

	


}
