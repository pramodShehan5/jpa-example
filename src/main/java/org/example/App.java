package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.model.Fruit;
import org.example.model.Vegetable;

public class App
{
    public static void main( String[] args ) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("default");
            em = emf.createEntityManager();
            Fruit fruit = new Fruit("Orange");
            Vegetable vegetable = new Vegetable("Carrot", 23.2);
            Vegetable vegetable1 = new Vegetable("Beet Root", 23.2);

            //Insert
            em.getTransaction().begin();
            em.persist(fruit);
            em.persist(vegetable);
            em.persist(vegetable1);
            em.getTransaction().commit();

            //Delete
            em.getTransaction().begin();
            em.remove(em.find(Vegetable.class, 100));
            em.getTransaction().commit();

            //Update
            em.getTransaction().begin();
            Vegetable selectedVeg = em.find(Vegetable.class, 101);
            selectedVeg.setName("Potatoes");
            em.persist(selectedVeg);
            em.getTransaction().commit();

            //Find
            Fruit selectedFruit = em.find(Fruit.class, 1);
            System.out.println(selectedFruit);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (emf != null) {
                emf.close();
            }
            if (em != null) {
                em.close();
            }
        }
    }
}