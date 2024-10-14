package edu.icet.bo;

import edu.icet.bo.custom.Impl.GentsProductsBoImpl;
import edu.icet.bo.custom.Impl.KidsProductsBoImpl;
import edu.icet.bo.custom.Impl.LadiesProductBoImpl;
import edu.icet.bo.custom.Impl.OrdersBoImpl;
import edu.icet.dao.custom.Impl.LadiesProductsDaoImpl;
import edu.icet.util.BoType;

public class BoFactory {

    private static BoFactory instance;

    private BoFactory(){}

    public static BoFactory getInstance() {
        return null==instance?instance=new BoFactory():instance;
    }

    public <T extends SuperBo>T getBoType(BoType type){
    switch (type){
        case GENTSPRODUCTS:return (T) new GentsProductsBoImpl();
        case LADIESPRODUCTS:return (T) new LadiesProductBoImpl();
        case  KIDSPRODUCTS:return (T) new KidsProductsBoImpl();
        case ORDERS:return (T) new OrdersBoImpl();
    }
    return null;
    }
}
