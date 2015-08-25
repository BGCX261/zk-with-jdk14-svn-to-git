package test.models;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Products entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see test.models.Products
 * @author MyEclipse Persistence Tools
 */

public class ProductsDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(ProductsDAO.class);
	// property constants
	public static final String PRODUCT_NAME = "productName";
	public static final String PRODUCT_LINE = "productLine";
	public static final String PRODUCT_SCALE = "productScale";
	public static final String PRODUCT_VENDOR = "productVendor";
	public static final String PRODUCT_DESCRIPTION = "productDescription";
	public static final String QUANTITY_IN_STOCK = "quantityInStock";
	public static final String BUY_PRICE = "buyPrice";
	public static final String MSRP = "msrp";

	protected void initDao() {
		// do nothing
	}

	public void save(Products transientInstance) {
		log.debug("saving Products instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Products persistentInstance) {
		log.debug("deleting Products instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Products findById(java.lang.String id) {
		log.debug("getting Products instance with id: " + id);
		try {
			Products instance = (Products) getHibernateTemplate().get(
					"test.models.Products", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Products instance) {
		log.debug("finding Products instance by example");
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
		log.debug("finding Products instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Products as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProductName(Object productName) {
		return findByProperty(PRODUCT_NAME, productName);
	}

	public List findByProductLine(Object productLine) {
		return findByProperty(PRODUCT_LINE, productLine);
	}

	public List findByProductScale(Object productScale) {
		return findByProperty(PRODUCT_SCALE, productScale);
	}

	public List findByProductVendor(Object productVendor) {
		return findByProperty(PRODUCT_VENDOR, productVendor);
	}

	public List findByProductDescription(Object productDescription) {
		return findByProperty(PRODUCT_DESCRIPTION, productDescription);
	}

	public List findByQuantityInStock(Object quantityInStock) {
		return findByProperty(QUANTITY_IN_STOCK, quantityInStock);
	}

	public List findByBuyPrice(Object buyPrice) {
		return findByProperty(BUY_PRICE, buyPrice);
	}

	public List findByMsrp(Object msrp) {
		return findByProperty(MSRP, msrp);
	}

	public List findAll() {
		log.debug("finding all Products instances");
		try {
			String queryString = "from Products";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Products merge(Products detachedInstance) {
		log.debug("merging Products instance");
		try {
			Products result = (Products) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Products instance) {
		log.debug("attaching dirty Products instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Products instance) {
		log.debug("attaching clean Products instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ProductsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ProductsDAO) ctx.getBean("ProductsDAO");
	}
}