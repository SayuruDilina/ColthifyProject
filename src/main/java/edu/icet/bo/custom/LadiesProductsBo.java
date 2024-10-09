package edu.icet.bo.custom;

import edu.icet.bo.SuperBo;
import edu.icet.dto.LadiesProducts;
import edu.icet.entity.LadiesProductsEntity;
import javafx.collections.ObservableList;

public interface LadiesProductsBo extends SuperBo {

    boolean addLadiesProducts(LadiesProducts ladiesProduct);
    ObservableList<LadiesProductsEntity> getAll();
}
