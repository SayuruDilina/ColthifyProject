package edu.icet.dao.custom.Impl;

import edu.icet.dao.custom.OrdersDao;
import edu.icet.dto.OrdersEntity;
import edu.icet.util.HibernateUtil;
import javafx.collections.ObservableList;
import org.hibernate.Session;

public class OrdersDaoImpl implements OrdersDao {
    @Override
    public boolean save(OrdersEntity ordersEntity) {
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(ordersEntity);
        session.getTransaction().commit();
        session.close();
        return false;

    }

    @Override
    public ObservableList<OrdersEntity> getAll() {
        return null;
    }

    @Override
    public boolean update(OrdersEntity ordersEntity) {
        return false;
    }

    @Override
    public boolean delete(OrdersEntity ordersEntity) {
        return false;
    }
}
