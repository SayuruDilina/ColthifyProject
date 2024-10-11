package edu.icet.dao.custom.Impl;

import edu.icet.dao.custom.KidsProductsDao;
import edu.icet.entity.KidsProductsEntity;
import edu.icet.entity.LadiesProductsEntity;
import edu.icet.util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import java.util.List;

public class KidsProductsDaoImpl implements KidsProductsDao {
    @Override
    public boolean save(KidsProductsEntity kidsProducts) {
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(kidsProducts);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public ObservableList<KidsProductsEntity> getAll() {
        ObservableList<KidsProductsEntity> kidsProductsEntityObservableList= FXCollections.observableArrayList();
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        List<KidsProductsEntity> kidsProductsEntities=session.createQuery("from KidsProductsEntity", KidsProductsEntity.class).list();
        kidsProductsEntityObservableList.addAll(kidsProductsEntities);
        session.getTransaction().commit();
        session.close();;


        return kidsProductsEntityObservableList;
    }

    @Override
    public boolean update(KidsProductsEntity kidsProductsEntity) {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.update(kidsProductsEntity);
        session.getTransaction().commit();
        session.close();

        return false;
    }

    @Override
    public boolean delete(KidsProductsEntity kidsProducts) {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(kidsProducts);
        session.getTransaction().commit();
        session.close();
        return false;
    }
}
