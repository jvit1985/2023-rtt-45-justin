package jpa.entitymodels;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDAO {

	public Student validateStudent() {
		Scanner scan = new Scanner(System.in);
		StudentCourseDAO scDao = new StudentCourseDAO();
		System.out.println("Enter your email address:");
		String email = scan.next();
		System.out.println("Enter your password:");
		String password = scan.next();
		
		Student student1 = findByEmail(email);
		if (student1 != null && student1.getPassword().equals(password)) {
			int id = student1.getId();
			List <StudentCourse> courses = scDao.getStudentCourses(id);
			System.out.println("My Classes:");
			for (StudentCourse course : courses) {
				System.out.println(course);
			}
			return student1;
		} else {
			System.out.println("Wrong credentials");
		}
		return null;
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
		
		String hql = "FROM Student s where s.email = :emailParam";
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
		
		String hql = "FROM Student s where s.id = :idParam";
		TypedQuery<Student> query = session.createQuery(hql,Student.class);
		query.setParameter("idParam", id);
		Student result = query.getSingleResult();

		session.close();
		
		return result;
	}
	
	public void deleteById(Integer id) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "delete FROM Student s where s.id = :idParam";
		Query query = session.createQuery(hql,Student.class);
		query.setParameter("idParam", id);
		query.executeUpdate();
		session.getTransaction().begin();
		query.executeUpdate();
		session.getTransaction().commit();

		session.close();
		
	}
}
