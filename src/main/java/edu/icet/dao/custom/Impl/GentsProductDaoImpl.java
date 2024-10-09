package edu.icet.dao.custom.Impl;

import edu.icet.dao.custom.GentsProductsDao;
import edu.icet.entity.GentsProductsEntity;
import edu.icet.util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import java.util.List;

public class GentsProductDaoImpl implements GentsProductsDao {

    @Override
    public boolean save(GentsProductsEntity gentsProductsEntity) {
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(gentsProductsEntity);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public ObservableList<GentsProductsEntity> getAll() {
        ObservableList<GentsProductsEntity> gentsProductsEntityObservableList= FXCollections.observableArrayList();
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
        List<GentsProductsEntity> gentsProductsEntities=session.createQuery("from GentsProductsEntity", GentsProductsEntity.class).list();
        gentsProductsEntityObservableList.addAll(gentsProductsEntities);
         session.getTransaction().commit();
         session.close();
       return gentsProductsEntityObservableList;
    }
}
