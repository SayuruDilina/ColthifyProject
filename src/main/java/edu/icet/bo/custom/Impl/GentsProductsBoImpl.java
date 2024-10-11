package edu.icet.bo.custom.Impl;

import edu.icet.bo.custom.GentsProductsBo;
import edu.icet.dao.DaoFactory;
import edu.icet.dao.custom.GentsProductsDao;
import edu.icet.dao.custom.KidsProductsDao;
import edu.icet.dto.GentsProducts;
import edu.icet.dto.KidsProducts;
import edu.icet.entity.GentsProductsEntity;
import edu.icet.entity.KidsProductsEntity;
import edu.icet.util.DaoType;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;

public class GentsProductsBoImpl implements GentsProductsBo {
    @Override
    public boolean addGentsProducts(GentsProducts gentsProducts) {

        GentsProductsEntity entity=new ModelMapper().map(gentsProducts, GentsProductsEntity.class);

        GentsProductsDao gentsProductsDao=DaoFactory.getInstance().getDaoType(DaoType.GENTSPRODUCTS);
        gentsProductsDao.save(entity);

        return false;
    }

    @Override
    public ObservableList<GentsProductsEntity> getAll() {
        GentsProductsDao gentsProductsDao= DaoFactory.getInstance().getDaoType(DaoType.GENTSPRODUCTS);
        ObservableList<GentsProductsEntity> all=gentsProductsDao.getAll();

        return all;
    }

    @Override
    public boolean updateGentsProducts(GentsProducts gentsProducts) {
        GentsProductsEntity gentsProductsEntity=new ModelMapper().map(gentsProducts, GentsProductsEntity.class);
        GentsProductsDao gentsProductsDao=DaoFactory.getInstance().getDaoType(DaoType.GENTSPRODUCTS);
        gentsProductsDao.update(gentsProductsEntity);

        return false;
    }

    @Override
    public boolean deleteGentsProducts(GentsProducts gentsProducts) {
        GentsProductsEntity gentsProductsEntity=new  ModelMapper().map(gentsProducts, GentsProductsEntity.class);
        GentsProductsDao gentsProductsDao=DaoFactory.getInstance().getDaoType(DaoType.GENTSPRODUCTS);
        gentsProductsDao.delete(gentsProductsEntity);
        return false;
    }
}
