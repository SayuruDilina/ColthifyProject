package edu.icet.dao.custom.Impl;

import edu.icet.dao.custom.LadiesProductsDao;
import edu.icet.entity.GentsProductsEntity;
import edu.icet.entity.LadiesProductsEntity;
import edu.icet.util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import java.util.List;

public class LadiesProductsDaoImpl implements LadiesProductsDao {
    @Override
    public boolean save(LadiesProductsEntity ladiesProductsEntity) {

        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(ladiesProductsEntity);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public ObservableList<LadiesProductsEntity> getAll() {
        ObservableList<LadiesProductsEntity> ladiesProductsEntityObservableList= FXCollections.observableArrayList();
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
        List<LadiesProductsEntity> ladiesProductsEntities=session.createQuery("from LadiesProductsEntity", LadiesProductsEntity.class).list();
        ladiesProductsEntityObservableList.addAll(ladiesProductsEntities);
        session.getTransaction().commit();
        session.close();
        return ladiesProductsEntityObservableList;

    }
}
