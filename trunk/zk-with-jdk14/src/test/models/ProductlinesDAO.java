package test.models;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Productlines entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see test.models.Productlines
 * @author MyEclipse Persistence Tools
 */

public class ProductlinesDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(ProductlinesDAO.class);
	// property constants
	public static final String TEXT_DESCRIPTION = "textDescription";
	public static final String HTML_DESCRIPTION = "htmlDescription";
	public static final String IMAGE = "image";

	protected void initDao() {
		// do nothing
	}

	public void save(Productlines transientInstance) {
		log.debug("saving Productlines instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Productlines persistentInstance) {
		log.debug("deleting Productlines instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Productlines findById(java.lang.String id) {
		log.debug("getting Productlines instance with id: " + id);
		try {
			Productlines instance = (Productlines) getHibernateTemplate().get(
					"test.models.Productlines", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Productlines instance) {
		log.debug("finding Productlines instance by example");
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
		log.debug("finding Productlines instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Productlines as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTextDescription(Object textDescription) {
		return findByProperty(TEXT_DESCRIPTION, textDescription);
	}

	public List findByHtmlDescription(Object htmlDescription) {
		return findByProperty(HTML_DESCRIPTION, htmlDescription);
	}

	public List findByImage(Object image) {
		return findByProperty(IMAGE, image);
	}

	public List findAll() {
		log.debug("finding all Productlines instances");
		try {
			String queryString = "from Productlines";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Productlines merge(Productlines detachedInstance) {
		log.debug("merging Productlines instance");
		try {
			Productlines result = (Productlines) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Productlines instance) {
		log.debug("attaching dirty Productlines instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Productlines instance) {
		log.debug("attaching clean Productlines instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ProductlinesDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ProductlinesDAO) ctx.getBean("ProductlinesDAO");
	}
}