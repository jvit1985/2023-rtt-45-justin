package jpa.entitymodels;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CourseDAO {
	
	public List<Course> getAllCourses() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Course";
		TypedQuery<Course> query = session.createQuery(hql,Course.class);
		
		List<Course> results = query.getResultList();

		session.close();
		
		return results;
	}

	public void update(Course course) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(course);
		session.getTransaction().commit();
		session.close();
	}
	
	public Course findById(Integer id) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Course c where c.id = :idParam";
		TypedQuery<Course> query = session.createQuery(hql,Course.class);
		query.setParameter("idParam", id);
		Course result = query.getSingleResult();

		session.close();
		
		return result;
	}
	
}
