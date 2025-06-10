package com.employee.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private static final org.hibernate.SessionFactory sessionFactory =
        new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.openSession();
        List<Employee> list = session.createQuery("from Employee", Employee.class).list();
        session.close();
        return list;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(employee);
        tx.commit();
        session.close();
    }

    @Override
    public void updateEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(employee);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        if (employee != null) {
            session.delete(employee);
        }
        tx.commit();
        session.close();
    }
}