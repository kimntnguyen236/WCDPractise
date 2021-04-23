/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.loginDB.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author BuuBuu
 */
public class AccountDAO {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("prac01PU");
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

    public List<Account> findAll() {
        List<Account> list = new ArrayList<>();
        String query = "SELECT c FROM Account c";
        Query q = em.createQuery(query);
        list = q.getResultList();
        return list; // trả về nhiều một tập tất cả collection
        // trả về một đối tượng : getSingleResult
        // mọi phương thức đều phải return trừ void
        // return em.createQuery("SELECT c FROM Course c").getResultList();
    }

    public Account findOne(String cid) {
         return em.find(Account.class, cid);
//        Course course = null;
//        try {
//            em.getTransaction();
//            course = em.find(Course.class, cid);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//        } finally {
//            em.close();
//        }
//        return course;
    }

  
    public void addAccount(Account account) {
//         try {
//            em.getTransaction();
//            em.persist(course);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//        } finally{
//            em.close();
//        }
        Persit(account);
    }

 
    public void deleteAccount(String cid) {
        try {
            em.getTransaction().begin();
            Account account = em.find(Account.class, cid);
            if (account != null) {
                em.remove(account);
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

   
    public Account updateAccount(Account c) {
        //        Query q = em.createQuery("UPDATE Course SET course_name = :name, duration = :duration, fee = :fee WHERE course_id = :id").setParameter("name", c.getCourseName())
//                .setParameter("duration", c.getDuration()).setParameter("fee", c.getFee()).setParameter("id", c.getCourseId());
        try {
                em.getTransaction().begin();
//                Query q = em.createQuery("UPDATE Course SET course_name = :name, duration = :duration, fee = :fee WHERE course_id = :id").setParameter("name", c.getCourseName())
//                .setParameter("duration", c.getDuration()).setParameter("fee", c.getFee()).setParameter("id", c.getCourseId());
                em.merge(c);
                em.getTransaction().commit();
        }catch (Exception e) {
                em.getTransaction().rollback();
        }finally{
                em.close();
        }
        return c;
    }
    
    public Account Login(String uid, String upass) {
        String query = "SELECT a FROM Account a WHERE a.id = :id AND a.password = :password";
        try {
            List<Account> list = em.createQuery(query)
                    .setParameter("id", uid)
                    .setParameter("password", upass)
                    .getResultList();
            if (list.size() == 1) {
                return list.get(0);
            } else {
                return null;
            }
        } finally {
            em.close();
        }
    }
    
    
    
}
