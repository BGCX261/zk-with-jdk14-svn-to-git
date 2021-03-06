package test.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import test.models.Employees;

/**
 * A data access object (DAO) providing persistence and search support for
 * Employees entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see test.models.Employees
 * @author MyEclipse Persistence Tools
 */

public class EmployeesDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(EmployeesDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Employees transientInstance) {
		log.debug("saving Employees instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Employees persistentInstance) {
		log.debug("deleting Employees instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Employees findById(java.lang.Integer id) {
		log.debug("getting Employees instance with id: " + id);
		try {
			Employees instance = (Employees) getHibernateTemplate().get(
					"test.dao.Employees", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Employees instance) {
		log.debug("finding Employees instance by example");
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
		log.debug("finding Employees instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Employees as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Employees instances");
		try {
			String queryString = "from Employees";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Employees merge(Employees detachedInstance) {
		log.debug("merging Employees instance");
		try {
			Employees result = (Employees) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Employees instance) {
		log.debug("attaching dirty Employees instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Employees instance) {
		log.debug("attaching clean Employees instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EmployeesDAO getFromApplicationContext(ApplicationContext ctx) {
		return (EmployeesDAO) ctx.getBean("EmployeesDAO");
	}
}