package edu.icet.bo.custom;

import edu.icet.bo.SuperBo;
import edu.icet.dto.GentsProducts;
import edu.icet.entity.GentsProductsEntity;
import javafx.collections.ObservableList;

public interface GentsProductsBo extends SuperBo {

    boolean addGentsProducts(GentsProducts gentsProducts);
    ObservableList<GentsProductsEntity> getAll();
}
