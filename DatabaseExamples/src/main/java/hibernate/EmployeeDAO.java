package hibernate;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {

	public void insert(Employee employee) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Employee employee) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(employee);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Employee employee) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(employee);
		session.getTransaction().commit();
		session.close();
	}

	public Employee findById(Integer id) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Employee e where e.id = :idParam";
		TypedQuery<Employee> query = session.createQuery(hql, Employee.class);
		query.setParameter("idParam", id);
		Employee result = query.getSingleResult();

		session.close();

		return result;
	}

	public void deleteById(Integer id) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "delete FROM Employee e where e.id = :idParam";
		Query query = session.createQuery(hql, Employee.class);
		query.setParameter("idParam", id);
		query.executeUpdate();
		session.getTransaction().begin();
		query.executeUpdate();
		session.getTransaction().commit();

		session.close();

	}
}
