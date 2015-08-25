package test.models;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Customers entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see test.models.Customers
 * @author MyEclipse Persistence Tools
 */

public class CustomersDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(CustomersDAO.class);
	// property constants
	public static final String CUSTOMER_NAME = "customerName";
	public static final String CONTACT_LAST_NAME = "contactLastName";
	public static final String CONTACT_FIRST_NAME = "contactFirstName";
	public static final String PHONE = "phone";
	public static final String ADDRESS_LINE1 = "addressLine1";
	public static final String ADDRESS_LINE2 = "addressLine2";
	public static final String CITY = "city";
	public static final String STATE = "state";
	public static final String POSTAL_CODE = "postalCode";
	public static final String COUNTRY = "country";
	public static final String SALES_REP_EMPLOYEE_NUMBER = "salesRepEmployeeNumber";
	public static final String CREDIT_LIMIT = "creditLimit";

	protected void initDao() {
		// do nothing
	}

	public void save(Customers transientInstance) {
		log.debug("saving Customers instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Customers persistentInstance) {
		log.debug("deleting Customers instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Customers findById(java.lang.Integer id) {
		log.debug("getting Customers instance with id: " + id);
		try {
			Customers instance = (Customers) getHibernateTemplate().get(
					"test.models.Customers", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Customers instance) {
		log.debug("finding Customers instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Customers instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Customers as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCustomerName(Object customerName) {
		return findByProperty(CUSTOMER_NAME, customerName);
	}

	public List findByContactLastName(Object contactLastName) {
		return findByProperty(CONTACT_LAST_NAME, contactLastName);
	}

	public List findByContactFirstName(Object contactFirstName) {
		return findByProperty(CONTACT_FIRST_NAME, contactFirstName);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByAddressLine1(Object addressLine1) {
		return findByProperty(ADDRESS_LINE1, addressLine1);
	}

	public List findByAddressLine2(Object addressLine2) {
		return findByProperty(ADDRESS_LINE2, addressLine2);
	}

	public List findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findByPostalCode(Object postalCode) {
		return findByProperty(POSTAL_CODE, postalCode);
	}

	public List findByCountry(Object country) {
		return findByProperty(COUNTRY, country);
	}

	public List findBySalesRepEmployeeNumber(Object salesRepEmployeeNumber) {
		return findByProperty(SALES_REP_EMPLOYEE_NUMBER, salesRepEmployeeNumber);
	}

	public List findByCreditLimit(Object creditLimit) {
		return findByProperty(CREDIT_LIMIT, creditLimit);
	}

	public List findAll() {
		log.debug("finding all Customers instances");
		try {
			String queryString = "from Customers";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Customers merge(Customers detachedInstance) {
		log.debug("merging Customers instance");
		try {
			Customers result = (Customers) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Customers instance) {
		log.debug("attaching dirty Customers instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Customers instance) {
		log.debug("attaching clean Customers instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CustomersDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CustomersDAO) ctx.getBean("CustomersDAO");
	}
}