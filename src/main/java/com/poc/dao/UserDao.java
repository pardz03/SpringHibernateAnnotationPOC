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
 * always add transactional annotation to hibernate dao
 * This Dao uses automatic CRUD of hibernate
 * 
 */
@Repository
@Transactional
public class UserDao extends CustomHibernateDaoSupport{
	
	//hibernate query language
	private static final String FETCH_USERDATA = "from User where id=:iduser";
	
	/**
	 *  save all the information, just add basic info to the entity model 
	 */
	public boolean save(DataTransferObject dto){
		boolean isSaved = true;
		try{
			getSessionFactory().save(dto.getUser());
		}catch(Exception e){
			isSaved = false;
		}
		return isSaved;
	}
	
	/**
	 * automatically updates the table binded with the entity model and the where clause will be the primary key
	 * 
	 * problem is you have to complete all the details of entity model because it can loss data
	 * and where clause is limited to its primary key
	 */
	public boolean update(DataTransferObject dto){
		boolean isUpdated = true;
		try{
			getSessionFactory().update(dto.getUser());
		}catch(Exception e){
			isUpdated = false;
		}
		return isUpdated;
	}
	
	/**
	 * automatically updates the table binded with the entity model and the where clause will be the primary key
	 * 
	 * problem is where clause is limited to its primary key
	 */
	public boolean delete(DataTransferObject dto){
		boolean isUpdated = true;
		try{
			getSessionFactory().delete(dto.getUser());
		}catch(Exception e){
			isUpdated = false;
		}
		return isUpdated;
	}
	
	/**
	 * fetch via table mapping and hibernate query language
	 */
	@SuppressWarnings("unchecked")
	public DataTransferObject fetch(DataTransferObject dto){
		Query query = getSessionFactory().createQuery(FETCH_USERDATA);
		query.setParameter("iduser", dto.getUser().getId());
		List<User> results = query.list();
		DataTransferObject result = new DataTransferObject();
		result.setListUser(results);
		return result;
	}
}
