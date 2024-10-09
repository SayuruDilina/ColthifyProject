package edu.icet.controller;

import com.jfoenix.controls.JFXTextField;
import edu.icet.bo.BoFactory;
import edu.icet.bo.custom.GentsProductsBo;
import edu.icet.bo.custom.LadiesProductsBo;
import edu.icet.dto.GentsProducts;
import edu.icet.dto.LadiesProducts;
import edu.icet.entity.GentsProductsEntity;
import edu.icet.entity.LadiesProductsEntity;
import edu.icet.util.BoType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductsFormController  implements  Initializable{



        private AnchorPane page;
    @FXML
    private TableColumn<?, ?> colILadiesItemCode;

    @FXML
    private TableColumn<?, ?> colLadiesColor;

    @FXML
    private TableColumn<?, ?> colLadiesItemName;

    @FXML
    private TableColumn<?, ?> colLadiesQty;

    @FXML
    private TableColumn<?, ?> colLadiesSize;

    @FXML
    private TableView<LadiesProductsEntity> tblViewLadies;

    @FXML
    private JFXTextField txtItemCodeL;

    @FXML
    private JFXTextField txtItemNameL;

    @FXML
    private JFXTextField txtItemQtyL;

    @FXML
    private JFXTextField txtSizeL;

    @FXML
    private JFXTextField txtColorL;

    @FXML
    private AnchorPane LadiesProductPage;

    @FXML
    private AnchorPane gentsProductPage;

    @FXML
    private JFXTextField txtColor;

    @FXML
    private JFXTextField txtItemCode;

    @FXML
    private JFXTextField txtItemName;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXTextField txtSize;

    @FXML
    private TableColumn<?, ?> colColor;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colItemName;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colSize;

    @FXML
    private TableView<GentsProductsEntity> tblView;


    @FXML
    void gentsOnAction(ActionEvent event) {
      page.setVisible(false);
      page=gentsProductPage;
      page.setVisible(true);
            colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
            colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
            colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            colColor.setCellValueFactory(new PropertyValueFactory<>("color"));

        GentsProductsBo gentsProductsBo= BoFactory.getInstance().getBoType(BoType.GENTSPRODUCTS);
        tblView.setItems(gentsProductsBo.getAll());
    }

    @FXML
    void btnLadiesOnAction(ActionEvent event) {
        page.setVisible(false);
        page=LadiesProductPage;
        page.setVisible(true);
        colILadiesItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colLadiesItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colLadiesQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colLadiesSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        colLadiesColor.setCellValueFactory(new PropertyValueFactory<>("color"));

        LadiesProductsBo ladiesProductsBo=BoFactory.getInstance().getBoType(BoType.LADIESPRODUCTS);
        tblViewLadies.setItems(ladiesProductsBo.getAll());


    }

    public void btnAddOnAction(ActionEvent actionEvent) {

            GentsProductsBo gentsProductsBo = BoFactory.getInstance().getBoType(BoType.GENTSPRODUCTS);
            GentsProducts gentsProducts = new GentsProducts(
                    Integer.parseInt(txtItemCode.getText()),
                    txtItemName.getText(),
                    Integer.parseInt(txtQty.getText()),
                    txtSize.getText(),
                    txtColor.getText()
            );
            gentsProductsBo.addGentsProducts(gentsProducts);




    }
    @FXML
    void btnAddOnActionL(ActionEvent event) {
        LadiesProductsBo ladiesProductsBo = BoFactory.getInstance().getBoType(BoType.LADIESPRODUCTS);
        LadiesProducts ladiesProducts = new LadiesProducts(
                Integer.parseInt(txtItemCodeL.getText()),
                txtItemNameL.getText(),
                Integer.parseInt(txtItemQtyL.getText()),
                txtSizeL.getText(),
                txtColorL.getText()
        );
        ladiesProductsBo.addLadiesProducts(ladiesProducts);

    }
    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnActionL(ActionEvent event) {

    }



    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnActionL(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        page=gentsProductPage;
        page.setVisible(true);
    }
}
