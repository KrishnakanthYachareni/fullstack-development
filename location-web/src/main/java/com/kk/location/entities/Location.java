/*
 * Copyright (c) 2020. Krishnakanth Yachareni
 */

package com.kk.location.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

// Use @Table, @Colummn when names are not matches with actual names in the database.
@javax.persistence.Entity
@Table(name = "location")
public class Location {

	@Id
	private int id;
	@Column(name = "code")
	private String code;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
