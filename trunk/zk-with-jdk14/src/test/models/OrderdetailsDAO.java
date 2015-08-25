package test.models;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Orderdetails entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see test.models.Orderdetails
 * @author MyEclipse Persistence Tools
 */

public class OrderdetailsDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(OrderdetailsDAO.class);
	// property constants
	public static final String QUANTITY_ORDERED = "quantityOrdered";
	public static final String PRICE_EACH = "priceEach";
	public static final String ORDER_LINE_NUMBER = "orderLineNumber";

	protected void initDao() {
		// do nothing
	}

	public void save(Orderdetails transientInstance) {
		log.debug("saving Orderdetails instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Orderdetails persistentInstance) {
		log.debug("deleting Orderdetails instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Orderdetails findById(test.models.OrderdetailsId id) {
		log.debug("getting Orderdetails instance with id: " + id);
		try {
			Orderdetails instance = (Orderdetails) getHibernateTemplate().get(
					"test.models.Orderdetails", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Orderdetails instance) {
		log.debug("finding Orderdetails instance by example");
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
		log.debug("finding Orderdetails instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Orderdetails as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByQuantityOrdered(Object quantityOrdered) {
		return findByProperty(QUANTITY_ORDERED, quantityOrdered);
	}

	public List findByPriceEach(Object priceEach) {
		return findByProperty(PRICE_EACH, priceEach);
	}

	public List findByOrderLineNumber(Object orderLineNumber) {
		return findByProperty(ORDER_LINE_NUMBER, orderLineNumber);
	}

	public List findAll() {
		log.debug("finding all Orderdetails instances");
		try {
			String queryString = "from Orderdetails";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Orderdetails merge(Orderdetails detachedInstance) {
		log.debug("merging Orderdetails instance");
		try {
			Orderdetails result = (Orderdetails) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Orderdetails instance) {
		log.debug("attaching dirty Orderdetails instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Orderdetails instance) {
		log.debug("attaching clean Orderdetails instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OrderdetailsDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (OrderdetailsDAO) ctx.getBean("OrderdetailsDAO");
	}
}