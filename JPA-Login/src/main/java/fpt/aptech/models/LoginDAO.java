package fpt.aptech.models;

import java.util.*;
import javax.persistence.*;

/**
 *
 * @author ThienKim
 */
public class LoginDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ThienKim");
    EntityManager em = emf.createEntityManager();

    public void Persit(Object object) {
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    // hien thi tat ca
    public List<Login> findAll() {
        return em.createQuery("SELECT l FROM Login l").getResultList();
    }

    // search
    public List<Login> findByName(String uname) {
        String query = "SELECT l FROM Login l WHERE l.name = :name"; // tim tuyet doi thi =
        try {
            return em.createQuery(query)
                    // .setParameter("fullname", uname)
                    .setParameter("fullname", "%" + uname + "%") // dùng cho LIKE còn nếu = thì dùng hàm trên
                    .getResultList();
        } finally {
            em.close();
        }
    }

    // hien thi mot record
    public Login findOne(String lid) {
        return em.find(Login.class, lid);
//        Login login = null;
//        try {
//            em.getTransaction();
//            login = em.find(Login.class, cid);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//        } finally {
//            em.close();
//        }
//        return login;
    }

    // tao moi 1 record
    public void addLogin(Login login) {
//         try {
//            em.getTransaction();
//            em.persist(login);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//        } finally{
//            em.close();
//        } 
        Persit(login);
    }

    // xoa 1 record
    public void deleteLogin(String lid) {
        try {
            em.getTransaction().begin();
            Login login = em.find(Login.class, lid);
            if (login != null) {
                em.remove(login);
                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    // chinh sua 1 record
    public Login updateLogin(Login login) {
        try {
            em.getTransaction().begin();
            em.merge(login);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return login;
    }
}
