package com.etu.labs.util;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GenericDB<T> {

    private final Class<T> type;

    public GenericDB(Class<T> type) {
        this.type = type;
    }

    public List<T> readAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM " + type.getSimpleName();
            Query<T> query = session.createQuery(hql, type);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<T> readByField(String fieldName, Object value) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM " + type.getSimpleName() + " WHERE " + fieldName + " = :value";
            Query<T> query = session.createQuery(hql, type);
            query.setParameter("value", value);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void create(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public T read(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(type, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(int id, T newEntity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            T entity = session.get(type, id);
            if (entity != null) {
                transaction = session.beginTransaction();
                session.update(newEntity);
                transaction.commit();
            } else {
                System.out.println("Entity not found!");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            T entity = session.get(type, id);
            if (entity != null) {
                transaction = session.beginTransaction();
                session.delete(entity);
                transaction.commit();
            } else {
                System.out.println("Entity not found!");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}