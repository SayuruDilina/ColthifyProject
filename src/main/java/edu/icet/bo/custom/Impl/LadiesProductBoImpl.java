package edu.icet.bo.custom.Impl;

import edu.icet.bo.custom.LadiesProductsBo;
import edu.icet.dao.DaoFactory;
import edu.icet.dao.custom.GentsProductsDao;
import edu.icet.dao.custom.LadiesProductsDao;
import edu.icet.dto.LadiesProducts;
import edu.icet.entity.GentsProductsEntity;
import edu.icet.entity.LadiesProductsEntity;
import edu.icet.util.DaoType;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;

public class LadiesProductBoImpl implements LadiesProductsBo {
    @Override
    public boolean addLadiesProducts(LadiesProducts ladiesProduct) {
        LadiesProductsEntity entity=new ModelMapper().map(ladiesProduct, LadiesProductsEntity.class);

        LadiesProductsDao ladiesProductsDao=DaoFactory.getInstance().getDaoType(DaoType.LADIESPRODUCTS);
        ladiesProductsDao.save(entity);
        return false;
    }

    @Override
    public ObservableList<LadiesProductsEntity> getAll() {
        LadiesProductsDao ladiesProductsDao= DaoFactory.getInstance().getDaoType(DaoType.LADIESPRODUCTS);
        ObservableList<LadiesProductsEntity> all=ladiesProductsDao.getAll();
        return all;
    }

    @Override
    public boolean updateLadiesProducts(LadiesProducts ladiesProducts) {
        LadiesProductsEntity ladiesProductsEntity=new ModelMapper().map(ladiesProducts, LadiesProductsEntity.class);
        LadiesProductsDao ladiesProductsDao=DaoFactory.getInstance().getDaoType(DaoType.LADIESPRODUCTS);
        ladiesProductsDao.update(ladiesProductsEntity);
        return false;
    }

    @Override
    public boolean deleteLadiesProducts(LadiesProducts ladiesProducts) {
        LadiesProductsEntity ladiesProductsEntity=new  ModelMapper().map(ladiesProducts, LadiesProductsEntity.class);
        LadiesProductsDao ladiesProductsDao=DaoFactory.getInstance().getDaoType(DaoType.LADIESPRODUCTS);
        ladiesProductsDao.delete(ladiesProductsEntity);
        return false;
    }
}
