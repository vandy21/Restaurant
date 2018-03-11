package com.vann.RestaurantB.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.vann.RestaurantB.Dao.CardDao;
import com.vann.RestaurantB.Model.Card;

@Repository("cardDao")
@EnableTransactionManagement
@Transactional
public class CardDaoImpl implements CardDao{
	@Autowired 
	public SessionFactory sessionFactory;
	
	
	public CardDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
public boolean saveupdate(Card card){
	sessionFactory.getCurrentSession().saveOrUpdate(card);
	return true;

	}
	@Transactional
	public boolean delete(String cardId){
		Card CARD =new Card();
		CARD.setCardId(cardId);
		sessionFactory.getCurrentSession().delete(CARD);

		
			return true;

	}
	@Transactional
	public Card get(String cardId){
		System.out.println(cardId);
		String hql="from Card where cardId ='"+cardId+"'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<Card> list1 = (List<Card>)q.list();
		if(list1 ==null || list1.isEmpty())
		{
		
			return null;
		}else{
			return list1.get(0);
		}
		
	}
	@Transactional
	public List<Card> getlistbyU_Id(String userId){
		System.out.println(userId);
		String hql="from Card where userId ='"+userId+"'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<Card> list1 = (List<Card>)q.list();
		if(list1 ==null || list1.isEmpty())
		{
		
			return null;
		}else{
			return list1;
		}
		
	}
	@Transactional	
	public List<Card> list(){
		@SuppressWarnings("unchecked")
		List<Card>listcard=(List<Card>)sessionFactory.getCurrentSession().createCriteria(Card.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
			return listcard;
		}


}
