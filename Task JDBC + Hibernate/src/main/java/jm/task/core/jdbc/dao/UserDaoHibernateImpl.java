package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Transaction transaction1 = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction1 = session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS USER " +
                    "(id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(45) NOT NULL ," +
                    "lastName VARCHAR(45) NOT NULL ,age INT NOT NULL )")
                    .executeUpdate();
            transaction1.commit();
        } catch (Exception e) {
            if (transaction1 != null) {
                transaction1.rollback();
            }
            e.printStackTrace();
            System.out.println("Ошибка в createUsersTable");
        }
    }

    @Override
    public void dropUsersTable() {
        Transaction transaction2 = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction2 = session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS USER")
                    .executeUpdate();
        } catch (Exception e) {
            if (transaction2 != null) {
                transaction2.rollback();
            }
            e.printStackTrace();
            System.out.println("Ошибка в dropUsersTable");
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction3 = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction3 = session.beginTransaction();
            session.save(new User(name, lastName, age));
            transaction3.commit();
        } catch (Exception e) {
            if (transaction3 != null) {
                transaction3.rollback();
            }
            e.printStackTrace();
            System.out.println("Ошибка в saveUser");
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction4 = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction4 = session.beginTransaction();
            session.delete(session.get(User.class, id));
            transaction4.commit();
        } catch (Exception e) {
            if (transaction4 != null) {
                transaction4.rollback();
            }
            e.printStackTrace();
            System.out.println("Ошибка в removeUserById");
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Transaction transaction5 = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction5 = session.beginTransaction();
            users = session.createQuery("FROM User").list();
            transaction5.commit();
        } catch (Exception e) {
            if (transaction5 != null) {
                transaction5.rollback();
            }
            e.printStackTrace();
            System.out.println("Ошибка в getAllUsers");
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction6 = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction6 = session.beginTransaction();
            session.createSQLQuery("DELETE FROM user")
                    .executeUpdate();
            transaction6.commit();
        } catch (Exception e) {
            if (transaction6 != null) {
                transaction6.rollback();
            }
            e.printStackTrace();
            System.out.println("Ошибка в cleanUsersTable");
        }
    }
}
