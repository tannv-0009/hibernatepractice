package com.example.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.example.entity.Customer;
import com.example.entity.Transaction;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public abstract class AbstractHibernateDao<T extends Serializable> {
    private Class<T> clazz;
    static SessionFactory sessionFactory;
    static Session sessionObj;
    
    public final static Logger logger = Logger.getLogger(AbstractHibernateDao.class);

	@SuppressWarnings("unchecked")
	public AbstractHibernateDao() {
		this.clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		  loadSessionFactory();
	}

    public void loadSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
		configuration.addResource("address.hbm.xml");
		configuration.addResource("user.hbm.xml");
		configuration.addPackage("com.example.entity");
		configuration.addAnnotatedClass(Transaction.class);
		configuration.addAnnotatedClass(Customer.class);


				ServiceRegistry srvcReg =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(srvcReg);
    }
    
    public void setClazz(Class< T > clazzToSet){
       this.clazz = clazzToSet;
    }
 
    public T findOne(long id){
    	sessionObj= sessionFactory.openSession();
    	T  object= sessionObj.get(clazz, id);
    	sessionObj.close();
      return object;
    }
 
    public List<T> findAll() {
    	
    	sessionObj= sessionFactory.openSession();
    	List<T>  objects= sessionObj.createQuery("from " + clazz.getName()).list();
    	sessionObj.close();
    	
        return objects;
    }
 
    public T create(T entity) {
        try {
            sessionObj = sessionFactory.openSession();
            sessionObj.beginTransaction();
       
            sessionObj.saveOrUpdate(entity);
            
            sessionObj.getTransaction().commit();
            logger.info("\nSuccessfully Created Records In The Database!\n");
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
        	
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
        
        return entity;
        
    }
 
    public T update(T entity) {
	    try {
	        sessionObj = sessionFactory.openSession();
	        sessionObj.beginTransaction();
	        
	        sessionObj.merge(entity);
	        
	        sessionObj.getTransaction().commit();
	        logger.info("\nSuccessfully Updated Records In The Database!\n");
	    } catch(Exception sqlException) {
	        if(null != sessionObj.getTransaction()) {
	            logger.info("\n.......Transaction Is Being Rolled Back.......\n");
	            sessionObj.getTransaction().rollback();
	        }
	        sqlException.printStackTrace();
	    } finally {
	    	
	        if(sessionObj != null) {
	            sessionObj.close();
	        }
	    }
	    
	    return entity;
    }
    
 
    public void delete(T entity) {
	    try {
	        sessionObj = sessionFactory.openSession();
	        sessionObj.beginTransaction();
	        
	        sessionObj.delete(entity);
	        
	        sessionObj.getTransaction().commit();
	        logger.info("\nSuccessfully Deleted Records In The Database!\n");
	    } catch(Exception sqlException) {
	        if(null != sessionObj.getTransaction()) {
	            logger.info("\n.......Transaction Is Being Rolled Back.......\n");
	            sessionObj.getTransaction().rollback();
	        }
	        sqlException.printStackTrace();
	    } finally {
	    	
	        if(sessionObj != null) {
	            sessionObj.close();
	        }
	    }
	   
    }
 
    public void deleteById(long entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }
 
    protected Session getCurrentSession() {
        return sessionFactory.openSession();
    }
}