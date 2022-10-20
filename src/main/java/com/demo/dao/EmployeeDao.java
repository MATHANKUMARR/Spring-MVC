package com.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.demo.model.Employee;

@Component
public class EmployeeDao {

	
	@Autowired
	HibernateTemplate hiberneteTemplate;
	
	@Transactional
	public void addEmployee(Employee emp)
	{
		hiberneteTemplate.save(emp);
	}
	
	public List<Employee> getAllEmp()
	{
		return hiberneteTemplate.loadAll(Employee.class);
	}
	
	@Transactional
	public Employee getEmpById(Long id)
	{
		
		
		Employee emp= hiberneteTemplate.get(Employee.class, id);
		return emp;
	}
	
	@Transactional
	public void updateEmp(Employee emp)
	{
		hiberneteTemplate.update(emp);
	}
	
	@Transactional
	public void deleteEmp(Long id)
	{
		hiberneteTemplate.delete(hiberneteTemplate.load(Employee.class, id));
	}
	
}
