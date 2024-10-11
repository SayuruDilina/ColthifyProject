package edu.icet.bo.custom;


import edu.icet.bo.SuperBo;
import edu.icet.dto.KidsProducts;

import edu.icet.dto.LadiesProducts;
import edu.icet.entity.KidsProductsEntity;
import javafx.collections.ObservableList;

public interface KidsProductsBo extends SuperBo {

    boolean addKidsProducts(KidsProducts kidsProducts);
    ObservableList<KidsProductsEntity> getAll();
    boolean updateLKidsProducts(KidsProducts kidsProducts);
    boolean deleteKidsProducts(KidsProducts kidsProducts);
}
