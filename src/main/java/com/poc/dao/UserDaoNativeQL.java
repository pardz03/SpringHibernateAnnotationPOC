package com.poc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.poc.dto.DataTransferObject;
import com.poc.model.User;

/**
 * 
 * @author joliveros
 * this is Dao for Native QUERY use
 * 
 * NATIVE query is only supported for select statements
 */
@Repository
@Transactional
public class UserDaoNativeQL extends CustomHibernateDaoSupport{
	
	private static final String USER_FETCH_HQL="select * from student_info where student_age=:studentage";
	
	/**
	 * 
	 * @param dto haves the model for the query
	 * @return dto haves the model of the fetched model /s
	 * 
	 *  for native sql single field select,user is not required to select all fields. user must add entity to the query for result casting
	 *  
	 *  NOTE: CreateSQLQuery method returns SQLQuery object... not Query
	 *  NOTE: mapping for the query is handled by Entity mapping so query is not forced to use Entity Name
	 *  
	 */
	@SuppressWarnings("unchecked")
	public DataTransferObject fetch(DataTransferObject dto){
		SQLQuery query = getSessionFactory().createSQLQuery(USER_FETCH_HQL);
		query.addEntity(User.class);
		
		if(dto.getUser().getAge() != null)
		query.setParameter("studentage", dto.getUser().getAge());
	
		List<User> userlist =query.list();
		DataTransferObject returnDTO = new DataTransferObject();
		returnDTO.setListUser(userlist);
		
		return returnDTO;
	}
}
