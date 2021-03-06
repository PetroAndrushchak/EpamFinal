package com.epam.project.db.model;

import java.io.Serializable;

import com.epam.project.db.model.annotation.Column;
import com.epam.project.db.model.annotation.Format;
import com.epam.project.db.model.annotation.Presence;
import com.epam.project.db.model.annotation.Size;
import com.epam.project.db.model.annotation.Table;
import com.epam.project.db.model.validator.Validator;

@Table(name = "language")
public class Language extends Validator implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(value = "id")
	private Integer id;

	@Column(value = "name")
	@Presence
	@Size(min=1,max=15)
	@Format(format="^[^<^>]*$")
	private String name;

	@Column(value = "language")
	@Presence
	@Size(min=2,max=2)
	@Format(format="^[a-z]{2}$")
	private String language;
	
	@Column(value = "country")
	@Presence
	@Size(min=2,max=2)
	@Format(format="^[A-Z]{2}$")
	private String country;

	@Column(value = "file")
	@Presence
	private String file;

	@Column(value = "img")
	@Format(format="png|jpg|jpeg$")
	private String image;

	@Column(value = "active")
	private Boolean active;
	public Language() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Language [id=" + id + ", name=" + name + ", language="
				+ language + ", country=" + country + ", file=" + file
				+ ", image=" + image + ", active=" + active + "]";
	}

	

}