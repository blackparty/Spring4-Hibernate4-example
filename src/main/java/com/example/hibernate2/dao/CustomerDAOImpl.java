package com.example.hibernate2.dao;

import com.example.hibernate2.model.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by MimiKuchiki on 16/5/2018.
 */


@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers(){
        Session session = sessionFactory.getCurrentSession();
        Query theQuery = session.createQuery("from Customer");
        List<Customer> customers= theQuery.list();
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public boolean loginCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        Query theQuery = session.createQuery("from Customer customer where customer.username =:name and customer.password =:pass");
        theQuery.setString("name",customer.getUsername());
        theQuery.setString("pass",customer.getPassword());
        if(theQuery.list().isEmpty()){
            return false;
        }
        return true;
    }

}
