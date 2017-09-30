/**
 * 
 */
package com.akhil.todo.entiities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author akhilajay
 *
 */
@Entity
public class Task {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	private boolean iscompleted=false;
	private boolean ispending=true;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the iscompleted
	 */
	public boolean isIscompleted() {
		return iscompleted;
	}

	/**
	 * @param iscompleted
	 *            the iscompleted to set
	 */
	public void setIscompleted(boolean iscompleted) {
		this.iscompleted = iscompleted;
	}

	/**
	 * @return the ispending
	 */
	public boolean isIspending() {
		return ispending;
	}

	/**
	 * @param ispending
	 *            the ispending to set
	 */
	public void setIspending(boolean ispending) {
		this.ispending = ispending;
	}

}
