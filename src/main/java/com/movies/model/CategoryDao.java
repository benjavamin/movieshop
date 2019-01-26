package com.movies.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class CategoryDao {


    @Autowired
    SessionFactory sessionFactory;

    public List<Category> find() {

        Session session = sessionFactory.getCurrentSession();
        //session.beginTransaction();
        /*CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Category> criteriaQuery = builder.createQuery(Category.class);
        //criteria.from(Category.class);
        List<Category> result = session.createQuery(criteriaQuery).getResultList();*/
        
        List<Category> result = session.createCriteria(Category.class).list();
        //session.getTransaction().commit();
        return result;

    }
    
    public Category getById(int id){
        return (Category)sessionFactory.getCurrentSession().get(Category.class, id);
    }
    
    
    public void update(Category category){   
        sessionFactory.getCurrentSession().update(category);    
    }
    
    
}
