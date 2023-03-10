package hibernate;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PaymentDAO {

	public void insert(Payment payment) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.save(payment);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Payment payment) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(payment);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Payment payment) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(payment);
		session.getTransaction().commit();
		session.close();
	}

	public Payment findById(Integer id) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Payment p where p.id = :idParam";
		TypedQuery<Payment> query = session.createQuery(hql, Payment.class);
		query.setParameter("idParam", id);
		Payment result = query.getSingleResult();

		session.close();

		return result;
	}

	public void deleteById(Integer id) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "delete FROM Payment p where p.id = :idParam";
		Query query = session.createQuery(hql, Payment.class);
		query.setParameter("idParam", id);
		query.executeUpdate();
		session.getTransaction().begin();
		query.executeUpdate();
		session.getTransaction().commit();

		session.close();

	}
}
