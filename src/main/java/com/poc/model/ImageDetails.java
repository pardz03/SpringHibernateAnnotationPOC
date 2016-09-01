package com.poc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 
 * @author joliveros
 *	mapping for tbl_imagedetails
 *	try for proper joining of tables
 */
@Entity
@Table(name = "tbl_imagedetails")
public class ImageDetails {
	public ImageDetails(){}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_details")
	private int id;
	
	@Column(name = "comment")
	private String comment;
	
	/**
	 * fetch type EAGER automatically query joined tables
	 */
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="tbl_imageinfo",  
    joinColumns={@JoinColumn(name="id_details", referencedColumnName="id_details")},  
    inverseJoinColumns={@JoinColumn(name="id_image", referencedColumnName="id_image")})  
	private Image image;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
