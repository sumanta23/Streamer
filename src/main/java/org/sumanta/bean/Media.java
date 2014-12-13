package org.sumanta.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity(name="MediaFiles")
public class Media {

	
	//@TableGenerator(name="id", table="fileidtab", pkColumnName="fileid",
	//	pkColumnValue="idvalue", allocationSize=1)
	//@GeneratedValue(strategy=GenerationType.TABLE,generator="id")
	@Id
	@Column (name="ID")
	@TableGenerator(name="id", table="fileidtab", pkColumnName="fileid",
	pkColumnValue="idvalue", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="id")
	private int id;
	@Column(name="PATHTOFILE")
	private String path;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
