package hibernate;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MovieRentalDAO {
	
	public void insert(MovieRental movierental) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.save(movierental);
		session.getTransaction().commit();
		session.close();
	}

	public void update(MovieRental movierental) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(movierental);
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(MovieRental movierental) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(movierental);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<MovieRental> selectAllRentals() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM MovieRental";
		TypedQuery<MovieRental> query = session.createQuery(hql,MovieRental.class);
		
		List<MovieRental> results = query.getResultList();

		session.close();
		
		return results;
	}
	
	public MovieRental findById(Integer id) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM MovieRental mr where mr.id = :idParam";
		TypedQuery<MovieRental> query = session.createQuery(hql,MovieRental.class);
		query.setParameter("idParam", id);
		MovieRental result = query.getSingleResult();

		session.close();
		
		return result;
	}
	
	public MovieRental findByMovieUser(Integer movieId, Integer userId) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM MovieRental mr where mr.movieId = :idParam1 AND mr.userId = :idParam2";
		TypedQuery<MovieRental> query = session.createQuery(hql,MovieRental.class);
		query.setParameter("idParam1", movieId);
		query.setParameter("idParam2", userId);
		MovieRental result = query.getSingleResult();

		session.close();
		
		return result;
	}
	
	public void deleteById(Integer id) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "delete FROM MovieRental mr where mr.id = :idParam";
		Query query = session.createQuery(hql,MovieRental.class);
		query.setParameter("idParam", id);
		query.executeUpdate();
		session.getTransaction().begin();
		query.executeUpdate();
		session.getTransaction().commit();

		session.close();
		
	}
	
}
