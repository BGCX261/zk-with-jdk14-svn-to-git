package test.models;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Payments entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see test.models.Payments
 * @author MyEclipse Persistence Tools
 */

public class PaymentsDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(PaymentsDAO.class);
	// property constants
	public static final String AMOUNT = "amount";

	protected void initDao() {
		// do nothing
	}

	public void save(Payments transientInstance) {
		log.debug("saving Payments instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Payments persistentInstance) {
		log.debug("deleting Payments instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Payments findById(test.models.PaymentsId id) {
		log.debug("getting Payments instance with id: " + id);
		try {
			Payments instance = (Payments) getHibernateTemplate().get(
					"test.models.Payments", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Payments instance) {
		log.debug("finding Payments instance by example");
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
		log.debug("finding Payments instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Payments as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List findAll() {
		log.debug("finding all Payments instances");
		try {
			String queryString = "from Payments";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Payments merge(Payments detachedInstance) {
		log.debug("merging Payments instance");
		try {
			Payments result = (Payments) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Payments instance) {
		log.debug("attaching dirty Payments instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Payments instance) {
		log.debug("attaching clean Payments instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PaymentsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PaymentsDAO) ctx.getBean("PaymentsDAO");
	}
}