package com.poc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.poc.dto.DataTransferObject;
import com.poc.model.Image;
import com.poc.model.ImageDetails;


/**
 * 
 * @author joliveros
 * always add transactional annotation to hibernate dao
 * This Dao uses automatic CRUD of hibernate
 * 
 * this dao tries joining of tables
 * 
 */
@Repository
@Transactional
public class ImageDao extends CustomHibernateDaoSupport{
	
	//hibernate query language
	//this query is same as FETCH_IMAGE
	private static final String FETCH_IMAGEJOIN = "select distinct i from Image i inner join i.imageDetail";	
	private static final String FETCH_IMAGE = "from Image";
	
	private static final String FETCH_IMAGEDETS = "select imagedetails from ImageDetails as imagedetails left join imagedetails.image as image where image.id = 2";
	
	private static final String FETCH_IMAGENATIVE = "select * from tbl_image i";
	
	@SuppressWarnings("unchecked")
	public DataTransferObject fetch(DataTransferObject dto){
		Query query = getSessionFactory().createQuery(FETCH_IMAGEJOIN);
		List<Image> results = query.list();
		DataTransferObject result = new DataTransferObject();
		result.setListImage(results);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public DataTransferObject fetchImageDetails(DataTransferObject dto){
		Query query = getSessionFactory().createQuery(FETCH_IMAGEDETS);
		List<ImageDetails> results = query.list();
		DataTransferObject result = new DataTransferObject();
		result.setListImageDetails(results);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public DataTransferObject fetchImageNative(DataTransferObject dto){
		SQLQuery query = getSessionFactory().createSQLQuery(FETCH_IMAGENATIVE);
		query.addEntity(Image.class);
		List<Image> results = query.list();
		DataTransferObject result = new DataTransferObject();
		result.setListImage(results);
		return result;
	}
	
	public void save(DataTransferObject dto){
		getSessionFactory().save(dto.getImage());
	}
	
}
