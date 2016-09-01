package com.poc.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 
 * @author joliveros
 *	mapping for tbl_image
 *	try for proper joining of tables
 */
@Entity
@Table(name = "tbl_image")
public class Image {
	public Image(){}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_image")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "path")
	private String path;
	
	/**
	 * reference column name is where the name of the column of tbl_image
	 * name is where the joined table is joinedcolumn
	 */
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="tbl_imageinfo",  
    joinColumns={@JoinColumn(name="id_image", referencedColumnName="id_image")},  
    inverseJoinColumns={@JoinColumn(name="id_details", referencedColumnName="id_details")})  
	private Set<ImageDetails> imageDetail;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Set<ImageDetails> getImageDetail() {
		return imageDetail;
	}

	public void setImageDetail(Set<ImageDetails> imageDetail) {
		this.imageDetail = imageDetail;
	}

	
}
