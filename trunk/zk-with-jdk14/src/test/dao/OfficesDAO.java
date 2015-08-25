package test.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import test.models.Offices;

/**
 * A data access object (DAO) providing persistence and search support for
 * Offices entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see test.models.Offices
 * @author MyEclipse Persistence Tools
 */

public class OfficesDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(OfficesDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Offices transientInstance) {
		log.debug("saving Offices instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Offices persistentInstance) {
		log.debug("deleting Offices instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Offices findById(java.lang.String id) {
		log.debug("getting Offices instance with id: " + id);
		try {
			Offices instance = (Offices) getHibernateTemplate().get(
					"test.dao.Offices", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Offices instance) {
		log.debug("finding Offices instance by example");
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
		log.debug("finding Offices instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Offices as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Offices instances");
		try {
			String queryString = "from Offices";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Offices merge(Offices detachedInstance) {
		log.debug("merging Offices instance");
		try {
			Offices result = (Offices) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Offices instance) {
		log.debug("attaching dirty Offices instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Offices instance) {
		log.debug("attaching clean Offices instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OfficesDAO getFromApplicationContext(ApplicationContext ctx) {
		return (OfficesDAO) ctx.getBean("OfficesDAO");
	}
}