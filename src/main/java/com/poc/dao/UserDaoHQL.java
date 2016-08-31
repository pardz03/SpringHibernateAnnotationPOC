package com.poc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.poc.dto.DataTransferObject;
import com.poc.model.User;

/**
 * 
 * @author joliveros
 *	this is the Dao for HQL use
 */
@Repository
@Transactional
public class UserDaoHQL extends CustomHibernateDaoSupport{
	
	private static final String USER_UPDATE_HQL = "update User set name=:studentname,age=:studentage where address=:studentaddress";
	private static final String USER_DELETE_HQL = "delete User where name=:studentname";
	private static final String USER_FETCH_HQL = "from User where age=:studentage";
	
	/**
	 *  hibernate doesn't support INSERT into VALUES
	 *  
	 *  forces you to use session.save for inserting record
	 */
	public boolean save(DataTransferObject dto){
		boolean isSuccess = true;
		try{
			getSessionFactory().save(dto.getUser());
		}catch(Exception e){
			isSuccess = false;
		}
		return isSuccess;
	}
	
	/**
	 * 
	 * @param dto haves the model for the query
	 * @return boolean if success or failed queries
	 */
	public boolean update(DataTransferObject dto){
		boolean isSuccess = true;
		try{
			Query query =getSessionFactory().createQuery(USER_UPDATE_HQL);
			query.setParameter("studentname", dto.getUser().getName());
			query.setParameter("studentage", dto.getUser().getAge());
			query.setParameter("studentaddress", dto.getUser().getAddress());
			query.executeUpdate();
		}catch(Exception e){
			isSuccess = false;
		}
		return isSuccess;
	}
	
	/**
	 * 
	 * @param dto haves the model for the query
	 * @return boolean if success or failed queries
	 */
	public boolean delete(DataTransferObject dto){
		boolean isSuccess = true;
		try{
			Query query =getSessionFactory().createQuery(USER_DELETE_HQL);
			query.setParameter("studentname", dto.getUser().getName());
			query.setParameter("studentage", dto.getUser().getAge());
			query.setParameter("studentaddress", dto.getUser().getAddress());
			query.executeUpdate();
		}catch(Exception e){
			isSuccess = false;
		}
		return isSuccess;
	}
	
	/**
	 * 
	 * @param dto haves the model for the query
	 * @return dto haves the model of the fetched model /s
	 *  
	 *  hql always require whole model variable selection
	 *  
	 *  for hql single field select,user must require primitive variables result catcher
	 *  
	 */
	@SuppressWarnings("unchecked")
	public DataTransferObject fetch(DataTransferObject dto){
		Query query = getSessionFactory().createQuery(USER_FETCH_HQL);
		
		if(dto.getUser().getAge() != null)
		query.setParameter("studentage", dto.getUser().getAge());
	
		List<User> userlist =query.list();
		DataTransferObject returnDTO = new DataTransferObject();
		returnDTO.setListUser(userlist);
		
		return returnDTO;
	}
}
