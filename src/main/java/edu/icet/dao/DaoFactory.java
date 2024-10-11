package edu.icet.dao;

import edu.icet.dao.custom.Impl.GentsProductDaoImpl;
import edu.icet.dao.custom.Impl.KidsProductsDaoImpl;
import edu.icet.dao.custom.Impl.LadiesProductsDaoImpl;
import edu.icet.util.DaoType;

public class DaoFactory {
    private static  DaoFactory instance;

    private DaoFactory(){}

    public static DaoFactory getInstance() {
        return null==instance?instance= new DaoFactory():instance;
    }
    public <T extends SuperDao>T getDaoType(DaoType type){
        switch (type){
            case GENTSPRODUCTS : return (T) new GentsProductDaoImpl();
            case LADIESPRODUCTS:return (T) new LadiesProductsDaoImpl();
            case KIDSPRODUCTS: return (T) new KidsProductsDaoImpl();
        }
        return null;

    }
}
