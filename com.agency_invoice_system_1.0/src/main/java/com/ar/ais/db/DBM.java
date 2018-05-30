/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author java
 */
public class DBM {

    private static final String PERSISTENCE_UNIT_NAME = "com.inventrysystem_InventrySystem_jar_1.0PU";
    public static EntityManagerFactory factory;

    public static EntityManagerFactory getFactory() {
        if (factory == null) {
            Map properties = new HashMap();
            properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
            properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3309/ar_ais?zeroDateTimeBehavior=convertToNull");
            properties.put("javax.persistence.jdbc.user", "wiztech");
            properties.put("javax.persistence.jdbc.password", "wiz_admin");
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, properties);
        }
        return factory;
    }

    public static EntityManager getEntityManager() {
        EntityManager em = null;
        try {
            em = getFactory().createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Unable to connect DataSourse Please Reset Configuration");
            return null;
        }
        return em;
    }

    public static <T> ArrayList<T> getAllRecords(Class c) {
        ArrayList<T> li = new ArrayList<>();
        try {
            EntityManager em = getEntityManager();
            if (em != null) {
                Query q = em.createNamedQuery(c.getSimpleName() + ".findAll");
                q.setHint(QueryHints.MAINTAIN_CACHE, HintValues.FALSE);
                li = new ArrayList<>(q.getResultList());
                em.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return li;
    }

    public static <T> ArrayList<T> getRecordsBy(Class c, String findBy, Object parameter) {
        ArrayList<T> li = new ArrayList<>();
        try {
            EntityManager em = getEntityManager();
            if (em != null) {
                Query q = em.createNamedQuery(c.getSimpleName() + ".findBy" + findBy).setParameter(findBy.toLowerCase().charAt(0) + "" + findBy.substring(1), parameter);
                li = new ArrayList<>(q.getResultList());
                em.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return li;
    }

    public static <T> ArrayList<T> getRecordsBy(Class c, String findBy) {
        ArrayList<T> li = new ArrayList<>();
        try {
            EntityManager em = getEntityManager();
            if (em != null) {

                Query q = em.createNamedQuery(c.getSimpleName() + ".findBy" + findBy);
                li = new ArrayList<>(q.getResultList());

                em.close();
            }
        } catch (Exception e) {

        }
        return li;
    }

    public static <T> T getSingleRecordById(Class c, Object id) {
        T t;
        try {
            EntityManager em = getEntityManager();
            if (em != null) {
                Query q = em.createNamedQuery(c.getSimpleName() + ".findById").setParameter("id", id);
                t = (T) q.getSingleResult();
                em.close();
                return t;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static <T> T insertRecords(Class c, Object obj) {
        EntityManager em = getEntityManager();
        if (em != null) {
            em.getTransaction().begin();
            try {
                em.persist(obj);
            } catch (Exception e) {
                return null;
            }
            em.getTransaction().commit();
            em.close();
            return (T) obj;
        }
        return null;
    }

    public static <T> boolean updateRecords(Class c, Object obj) {
        EntityManager em = getEntityManager();
        if (em != null) {
            em.getTransaction().begin();
            try {
                em.merge(obj);
            } catch (Exception e) {
                return false;
            }
            em.getTransaction().commit();
            em.close();
//            return (T) obj;
        }
        return true;

    }

    public static <T> boolean deleteRecords(Class c, long id) {
        EntityManager em = getEntityManager();
        if (em != null) {
            Object obj = em.find(c, id);
            em.getTransaction().begin();
            try {
                em.remove(obj);
            } catch (Exception e) {
                return false;
            }
            em.getTransaction().commit();
            em.close();
        }
        return true;
    }

    public static boolean deleteRecordsBy(Class c, HashMap parameters) {
        HashMap<String, String> hm = parameters;
        try {
            EntityManager em = getEntityManager();
            if (em != null) {
                em.getTransaction().begin();
                String qq = "DELETE FROM " + c.getSimpleName() + " a WHERE";
                boolean b = false;
                for (Map.Entry e : hm.entrySet()) {
                    if (b) {
                        qq += " AND ";
                    }
                    qq += " a." + e.getKey() + "= '" + e.getValue() + "'";
                    b = true;
                }
                int row = em.createQuery(qq).executeUpdate();
                em.getTransaction().commit();
                em.close();
                if (row < 1) {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static <T> ArrayList<T> getRecordsFromQuery(String query) {
        ArrayList<T> li = new ArrayList<>();
        EntityManager em = getEntityManager();
        if (em != null) {
            Query q = em.createQuery(query);
            li = new ArrayList<>(q.getResultList());
            em.close();
        }
        return li;

    }
}
