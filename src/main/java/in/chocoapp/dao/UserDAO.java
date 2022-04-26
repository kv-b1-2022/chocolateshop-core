package in.chocoapp.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.chocoapp.model.User;
import in.chocoapp.util.HibernateUtil;

public class UserDAO implements IUserDAO {

	private static Logger log = LogManager.getLogger(UserDAO.class);

	@Override
	public void addUser(User user) throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		try {
			session.persist(user);
			tx.commit();
		} catch (Exception e) {
			//log.error(e.getMessage());
			//System.out.println(e.getMessage());
			tx.rollback();
			e.printStackTrace();
		} finally {

			session.close();
		}

	}

	@Override
	public User userDetails(String mail) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int signUpMailValidation(String mail) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int signUpNumberValidation(String mobile) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String loginMailValidation(String mail, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String loginNumberValidation(String mobile, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
