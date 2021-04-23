/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.student1218312.jpa;

import java.util.*;
import javax.persistence.*;

/**
 *
 * @author ThienKim
 */
public class BookDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Exam");
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

    public List<Book> findAll() {
        return em.createQuery("SELECT b FROM Book b").getResultList();
    }
    public void addBook(Book book) {
        Persit(book);
    }
    public Book findOne(String cid) {
        return em.find(Book.class, cid);
    }
}
