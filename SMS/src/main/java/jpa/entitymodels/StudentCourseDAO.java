package jpa.entitymodels;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentCourseDAO {
	
	public List<StudentCourse> getStudentCourses(int studentId) {
		//need to have this display course information for each course as
		// #       Course Name        Instructor Name
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "c.id, c.courseName, c.instructor FROM Course c, StudentCourse sc where sc.studentId = :idParam";
		TypedQuery<StudentCourse> query = session.createQuery(hql,StudentCourse.class);
		query.setParameter("idParam", studentId);
		List<StudentCourse> results = query.getResultList();

		session.close();
		
		return results;
	}
	
	public void registerStudentToCourse(Student student, Course course) {
		//need to check course_id of course being passed in and compare to studentcourse
		//to make sure student is not already registered to this course
		//if student it already registered to that course then display
		//"You are already registered in that course!" and if not then add course
		//to studentcourse
		StudentCourse sc = new StudentCourse();
		StudentDAO studentDao = new StudentDAO();
		CourseDAO courseDao = new CourseDAO();
		
		sc.setStudent(student);
		sc.setCourse(course);
		
		insert(sc);
		
		student.getStudentCourses().add(sc);
		course.getStudentCourses().add(sc);
		
		studentDao.update(student);
		courseDao.update(course);
	}

	public void insert(StudentCourse studentCourse) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.save(studentCourse);
		session.getTransaction().commit();
		session.close();
	}

	public void update(StudentCourse studentCourse) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(studentCourse);
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(StudentCourse studentCourse) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(studentCourse);
		session.getTransaction().commit();
		session.close();
	}
	
	public StudentCourse findById(Integer id) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM StudentCourse sc where sc.id = :idParam";
		TypedQuery<StudentCourse> query = session.createQuery(hql,StudentCourse.class);
		query.setParameter("idParam", id);
		StudentCourse result = query.getSingleResult();

		session.close();
		
		return result;
	}
	
	public void deleteById(Integer id) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "delete FROM StudentCourse sc where sc.id = :idParam";
		Query query = session.createQuery(hql,StudentCourse.class);
		query.setParameter("idParam", id);
		query.executeUpdate();
		session.getTransaction().begin();
		query.executeUpdate();
		session.getTransaction().commit();

		session.close();
		
	}
}
