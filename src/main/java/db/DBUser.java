package db;

import models.Advert;
import models.Comment;
import models.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBUser {

    private static Transaction transaction;
    private static Session session;

    public static List<Advert> findAllAdsForUser(User user){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Advert> adverts = null;
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(Advert.class);
            cr.add(Restrictions.eq("user", user));
            adverts = cr.list();

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return adverts;
    }

//    SELECT * FROM users WHERE users.e-mail = $1
    public static User findByEmail(String email){
        session = HibernateUtil.getSessionFactory().openSession();
        User user = null;
        try {
            Criteria cr = session.createCriteria(User.class);
            cr.add(Restrictions.eq("email", email));
           user = (User)cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    public static List<Comment> findAllCommentsForUser(User user){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Comment> comments = null;
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(Comment.class);
            cr.add(Restrictions.eq("user", user));
            comments = cr.list();

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return comments;
    }
}
