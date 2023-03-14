package jpa.entitymodels;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDAO {

	public int validateStudent(String email, String password) {
		
		Student student1 = findByEmail(email);
		if (student1 != null && student1.getSPassword().equals(password)) {
			int id = student1.getSId();
			return id;
			
		} else {
			System.out.println("Wrong credentials");
		}
		return -1;
	}
	
	public List<Student> getAllStudents() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Student";
		TypedQuery<Student> query = session.createQuery(hql,Student.class);
		
		List<Student> results = query.getResultList();

		session.close();
		
		return results;
	}
	
	public Student findByEmail(String email) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Student s where s.sEmail = :emailParam";
		TypedQuery<Student> query = session.createQuery(hql,Student.class);
		query.setParameter("emailParam", email);
		Student result = query.getSingleResult();

		session.close();
		
		return result;
	}

	public void insert(Student student) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.save(student);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Student student) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(student);
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(Student student) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(student);
		session.getTransaction().commit();
		session.close();
	}
	
	public Student findById(Integer id) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Student s where s.sId = :idParam";
		TypedQuery<Student> query = session.createQuery(hql,Student.class);
		query.setParameter("idParam", id);
		Student result = query.getSingleResult();

		session.close();
		
		return result;
	}
	
	public void deleteById(Integer id) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "delete FROM Student s where s.sId = :idParam";
		Query query = session.createQuery(hql,Student.class);
		query.setParameter("idParam", id);
		query.executeUpdate();
		session.getTransaction().begin();
		query.executeUpdate();
		session.getTransaction().commit();

		session.close();
		
	}
}
