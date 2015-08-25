package test.win;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

 
import test.models.*;
import org.zkoss.lang.Strings;
import org.zkoss.spring.jpa.EntityNotFoundException;

public abstract class OrdersModelBase {
	 
	protected OrdersDAO beanDAO;
	
	protected Orders selected;
	protected String queryString;
	protected String where;
	protected String orderBy;
	protected int offset;
	protected int maxResults;
 

	public OrdersDAO getDAO() {
		return beanDAO;
	}
	
	public void setDAO(OrdersDAO beanDAO) {
		this.beanDAO = beanDAO;
	}
	
	public Orders getSelected() {
		return this.selected;
	}
	
	public void setSelected(Orders bean) {
		this.selected = bean;
	}
	
	public void setWhere(String where) {
		this.where = where;
	}
	
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	public int getOffset() {
		return this.offset;
	}
	
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}
	
	public int getMaxResults() {
		return this.maxResults;
	}
	
	public String getQueryString() {
		if (queryString != null) {
			return this.queryString;
		}
		return generateQueryString(this.where, this.orderBy);
	}
	
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	
 
	
	//-- DB access on the selected bean --//
	public void persist() {
		beanDAO.attachClean(selected);
	}
	
	public void merge() throws EntityNotFoundException {
		beanDAO.merge(selected);
	}
	
	public void delete() throws EntityNotFoundException {
		beanDAO.delete(selected);
	}
	
	public List  getAll() {
		return beanDAO.findAll();
	}
	
	//paging total size
	public int getTotalSize() {
		final String queryString = 
			"SELECT COUNT(*) " 
			+ getQueryString();
		 		return 20;
	}
	
	//-- overridable --//
	/** Generate query string */ 
	protected String generateQueryString(String where, String orderBy) {
		final StringBuffer sb = new StringBuffer(256);
		sb.append("FROM "+Orders.class.getName());
		if (!Strings.isBlank(where)) {
			sb.append(" WHERE "+where);
		}
		if (!Strings.isBlank(orderBy)) {
			sb.append(" ORDER BY "+orderBy);
		}
		return sb.toString();
	}

	/***** one-to-many Field *****/
	


}
