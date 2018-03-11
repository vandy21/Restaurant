package com.vann.RestaurantB.Config;
import javax.sql.DataSource;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.vann.RestaurantB.Dao.AuthenticationDao;
import com.vann.RestaurantB.Dao.BillingAddressDao;
import com.vann.RestaurantB.Dao.CardDao;
import com.vann.RestaurantB.Dao.CartDao;
import com.vann.RestaurantB.Dao.CartItemDao;
import com.vann.RestaurantB.Dao.CategoryDao;
import com.vann.RestaurantB.Dao.OrderDao;
import com.vann.RestaurantB.Dao.OrderItemDao;
import com.vann.RestaurantB.Dao.PayDao;
//import com.vann.RestaurantB.Dao.OrderDao;
import com.vann.RestaurantB.Dao.ProductDao;
import com.vann.RestaurantB.Dao.ShippingAddressDao;
import com.vann.RestaurantB.Dao.SupplierDao;
import com.vann.RestaurantB.Dao.UserDao;
import com.vann.RestaurantB.DaoImpl.AuthenticationDaoImpl;
import com.vann.RestaurantB.DaoImpl.BillingAddressDaoImpl;
import com.vann.RestaurantB.DaoImpl.CardDaoImpl;
import com.vann.RestaurantB.DaoImpl.CartDaoImpl;
import com.vann.RestaurantB.DaoImpl.CartItemDaoImpl;
import com.vann.RestaurantB.DaoImpl.CategoryDaoImpl;
import com.vann.RestaurantB.DaoImpl.OrderDaoImpl;
import com.vann.RestaurantB.DaoImpl.OrderItemDaoImpl;
import com.vann.RestaurantB.DaoImpl.PayDaoImpl;
//import com.vann.RestaurantB.DaoImpl.OrderDaoImpl;
import com.vann.RestaurantB.DaoImpl.ProductDaoImpl;
import com.vann.RestaurantB.DaoImpl.ShippingAddressDaoImpl;
import com.vann.RestaurantB.DaoImpl.SupplierDaoImpl;
import com.vann.RestaurantB.DaoImpl.UserDaoImpl;
import com.vann.RestaurantB.Model.Authentication;
import com.vann.RestaurantB.Model.BillingAddress;
import com.vann.RestaurantB.Model.Card;
import com.vann.RestaurantB.Model.Cart;
import com.vann.RestaurantB.Model.CartItem;
import com.vann.RestaurantB.Model.Category;
import com.vann.RestaurantB.Model.Order;
import com.vann.RestaurantB.Model.OrderItem;
import com.vann.RestaurantB.Model.Pay;
//import com.vann.RestaurantB.Model.Order;
import com.vann.RestaurantB.Model.Product;
import com.vann.RestaurantB.Model.ShippingAddress;
import com.vann.RestaurantB.Model.Supplier;
import com.vann.RestaurantB.Model.User;

@Configuration
@ComponentScan("com.vann.*")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/vanndb");
		dataSource.setUsername("vann");
		dataSource.setPassword("vann");
//		Properties connectionProperties = new Properties();
//		connectionProperties.setProperty("hibernate.connection.pool_size", "10");
//		connectionProperties.setProperty("hibernate.hbm2ddl.auto", "update");
//		connectionProperties.setProperty("hibernate.show_sql", "true");
//		connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect");
		return dataSource;
	}
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.connection.pool_size", "10");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

		return properties;
	}
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
        sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(CartItem.class);
		sessionBuilder.addAnnotatedClass(BillingAddress.class);
		sessionBuilder.addAnnotatedClass(Card.class);
//		sessionBuilder.addAnnotatedClass(Order.class);
		sessionBuilder.addAnnotatedClass(OrderItem.class);
		sessionBuilder.addAnnotatedClass(Pay.class);
		sessionBuilder.addAnnotatedClass(Authentication.class);
		sessionBuilder.addAnnotatedClass(ShippingAddress.class);
//		// sessionBuilder.buildMapping(net.viralpatel.hibernate.UserDetails2);
		return sessionBuilder.buildSessionFactory();
	}
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	@Autowired
	@Bean(name = "categoryDao")
	public CategoryDao getcategoryDao(SessionFactory sessionFactory) {
		return new CategoryDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "productDao")
	public ProductDao getProductDao(SessionFactory sessionFactory) {
		return new ProductDaoImpl(sessionFactory);
		}

		@Autowired
	@Bean(name = "supplierDao")
	public SupplierDao getSupplierDao(SessionFactory sessionFactory) {
		return new SupplierDaoImpl(sessionFactory);
		}

		@Autowired
		@Bean(name = "userDao")
		public UserDao getUserDao(SessionFactory sessionFactory) {
			return new UserDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean(name = "authenticationDao")
		public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory) {
			return new AuthenticationDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean(name = "billingAddressDao")
		public BillingAddressDao getBillingAddressDao(SessionFactory sessionFactory) {
			return new BillingAddressDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean(name = "cardDao")
		public CardDao getCardDao(SessionFactory sessionFactory) {
			return new CardDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean(name = "cartDao")
		public CartDao getCartDao(SessionFactory sessionFactory) {
			return new CartDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean(name = "cartItemDao")
		public CartItemDao getCartItemDao(SessionFactory sessionFactory) {
			return new CartItemDaoImpl(sessionFactory);
		}
//		@Autowired
//		@Bean(name = "orderDao")
//		public OrderDao getOrderDao(SessionFactory sessionFactory) {
//			return new OrderDaoImpl(sessionFactory);
//		}
		@Autowired
		@Bean(name = "orderItemDao")
		public OrderItemDao getrOderItemDao(SessionFactory sessionFactory) {
			return new OrderItemDaoImpl(sessionFactory);
		
	
}
		@Autowired
		@Bean(name = "payDao")
		public PayDao getrPayDao(SessionFactory sessionFactory) {
			return new PayDaoImpl(sessionFactory);
		
	
	
}@Autowired
		@Bean(name = "shippingAddressDao")
		public ShippingAddressDao getShippingAddressDao(SessionFactory sessionFactory) {
			return new ShippingAddressDaoImpl(sessionFactory);
		
	
	
}
		}
