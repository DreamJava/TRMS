package com.moflexy.domain;

import java.sql.Date;

import com.moflexy.dao.FormDAOPostgres;

public class Form {

	private final int FORM_ID = FormDAOPostgres.getNewID();;

	private int empID;

	private String date;

	private String time;

	private String location;

	private String description;

	private String costs;

	private String gradingFormat;
	
	private String type;
	
	private String justification;
	
	private int urgency;

	
	public Form(int empID, String date, String time, String location, String description, String costs,
			String gradingFormat, String type, String justification, int urgency) {
		super();
		this.empID = empID;
		this.date = date;
		this.time = time;
		this.location = location;
		this.description = description;
		this.costs = costs;
		this.gradingFormat = gradingFormat;
		this.type = type;
		this.justification = justification;
		this.urgency = urgency;
	}
	
	public Form() {
	}

	/**
	 * @return the fORM_ID
	 */
	public int getFORM_ID() {
		return FORM_ID;
	}
	
	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCosts() {
		return costs;
	}

	public void setCosts(String costs) {
		this.costs = costs;
	}

	public String getGradingFormat() {
		return gradingFormat;
	}

	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}

	/**
	 * @return the formID
	 */
	public int getFormID() {
		return FORM_ID;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the justification
	 */
	public String getJustification() {
		return justification;
	}

	/**
	 * @param justification the justification to set
	 */
	public void setJustification(String justification) {
		this.justification = justification;
	}

	/**
	 * @return the urgency
	 */
	public int getUrgency() {
		return urgency;
	}

	/**
	 * @param urgency the urgency to set
	 */
	public void setUrgency(int urgent) {
		this.urgency = urgent;
	}

	/**
	 * @return the empID
	 */
	public int getEmpID() {
		return empID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((costs == null) ? 0 : costs.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + empID;
		result = prime * result + FORM_ID;
		result = prime * result + ((gradingFormat == null) ? 0 : gradingFormat.hashCode());
		result = prime * result + ((justification == null) ? 0 : justification.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + urgency;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Form other = (Form) obj;
		if (costs == null) {
			if (other.costs != null)
				return false;
		} else if (!costs.equals(other.costs))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (empID != other.empID)
			return false;
		if (FORM_ID != other.FORM_ID)
			return false;
		if (gradingFormat == null) {
			if (other.gradingFormat != null)
				return false;
		} else if (!gradingFormat.equals(other.gradingFormat))
			return false;
		if (justification == null) {
			if (other.justification != null)
				return false;
		} else if (!justification.equals(other.justification))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (urgency != other.urgency)
			return false;
		return true;
	}


}
