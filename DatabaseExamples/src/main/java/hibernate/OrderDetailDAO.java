package hibernate;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDetailDAO {

	public void insert(OrderDetail orderdetail) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.save(orderdetail);
		session.getTransaction().commit();
		session.close();
	}

	public void update(OrderDetail orderdetail) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(orderdetail);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(OrderDetail orderdetail) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(orderdetail);
		session.getTransaction().commit();
		session.close();
	}

	public OrderDetail findById(Integer id) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM OrderDetail od where od.id = :idParam";
		TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
		query.setParameter("idParam", id);
		OrderDetail result = query.getSingleResult();

		session.close();

		return result;
	}

	public void deleteById(Integer id) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "delete FROM OrderDetail od where od.id = :idParam";
		Query query = session.createQuery(hql, OrderDetail.class);
		query.setParameter("idParam", id);
		query.executeUpdate();
		session.getTransaction().begin();
		query.executeUpdate();
		session.getTransaction().commit();

		session.close();

	}
}
