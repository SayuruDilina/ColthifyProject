package edu.icet.bo.custom.Impl;


import edu.icet.bo.custom.KidsProductsBo;
import edu.icet.dao.DaoFactory;
import edu.icet.dao.custom.KidsProductsDao;
import edu.icet.dto.KidsProducts;
import edu.icet.entity.KidsProductsEntity;
import edu.icet.util.DaoType;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;

public class KidsProductsBoImpl implements KidsProductsBo {

    @Override
    public boolean addKidsProducts(KidsProducts kidsProducts) {
        KidsProductsEntity kidsProductsEntity=new ModelMapper().map(kidsProducts, KidsProductsEntity.class);

        KidsProductsDao kidsProductsDao= DaoFactory.getInstance().getDaoType(DaoType.KIDSPRODUCTS);
        kidsProductsDao.save(kidsProductsEntity);

        return false;
    }

    @Override
    public ObservableList<KidsProductsEntity> getAll() {
        KidsProductsDao kidsProductsDao=DaoFactory.getInstance().getDaoType(DaoType.KIDSPRODUCTS);
        ObservableList<KidsProductsEntity> all = kidsProductsDao.getAll();
        return all;
    }

    @Override
    public boolean updateLKidsProducts(KidsProducts kidsProducts) {
        KidsProductsEntity kidsProductsEntity=new ModelMapper().map(kidsProducts, KidsProductsEntity.class);
        KidsProductsDao kidsProductsDao=DaoFactory.getInstance().getDaoType(DaoType.KIDSPRODUCTS);
        kidsProductsDao.update(kidsProductsEntity);

        return false;
    }

    @Override
    public boolean deleteKidsProducts(KidsProducts kidsProducts) {
        KidsProductsEntity kidsProductsEntity=new ModelMapper().map(kidsProducts, KidsProductsEntity.class);
        KidsProductsDao kidsProductsDao=DaoFactory.getInstance().getDaoType(DaoType.KIDSPRODUCTS);
        kidsProductsDao.delete(kidsProductsEntity);
        return false;
    }
}
