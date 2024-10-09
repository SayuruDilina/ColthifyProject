package edu.icet.bo.custom.Impl;

import edu.icet.bo.custom.GentsProductsBo;
import edu.icet.dao.DaoFactory;
import edu.icet.dao.custom.GentsProductsDao;
import edu.icet.dto.GentsProducts;
import edu.icet.entity.GentsProductsEntity;
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
}
