/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.models;

import javax.persistence.*;
import java.util.*;

/**
 *
 * @author sinhtm
 */
public class ContactDAO {

    public ContactDAO() {
    }
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab10PU");
    EntityManager em;

    public List<Contact> findAll() {
        String query = "SELECT c FROM Contact c";
        em = emf.createEntityManager();
        return em.createQuery(query).getResultList();
    }

    public void addContact(Contact contact) {
        em=emf.createEntityManager();
       try {
            em.getTransaction().begin();
            em.persist(contact);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
