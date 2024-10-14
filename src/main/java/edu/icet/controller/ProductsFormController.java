package edu.icet.controller;

import com.jfoenix.controls.JFXTextField;
import edu.icet.bo.BoFactory;
import edu.icet.bo.custom.GentsProductsBo;
import edu.icet.bo.custom.KidsProductsBo;
import edu.icet.bo.custom.LadiesProductsBo;
import edu.icet.dto.GentsProducts;
import edu.icet.dto.KidsProducts;
import edu.icet.dto.LadiesProducts;
import edu.icet.entity.GentsProductsEntity;
import edu.icet.entity.KidsProductsEntity;
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
    private TableColumn<?, ?> colPriceK;

    @FXML
    private TableColumn<?, ?> colLadiesPrice;

    @FXML
    private JFXTextField txtPricerK;

    @FXML
    private JFXTextField txtPriceL;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private AnchorPane KidsProductPage;

    @FXML
    private TableColumn<?, ?> colILadiesItemCode;

    @FXML
    private TableColumn<?, ?> colItemCodeK;

    @FXML
    private TableColumn<?, ?> colLadiesColor;

    @FXML
    private TableColumn<?, ?> colColorK;

    @FXML
    private TableColumn<?, ?> colLadiesItemName;

    @FXML
    private TableColumn<?, ?> colItemNameK;

    @FXML
    private TableColumn<?, ?> colLadiesQty;

    @FXML
    private TableColumn<?, ?> colQtyK;

    @FXML
    private TableColumn<?, ?> colLadiesSize;

    @FXML
    private TableView<LadiesProductsEntity> tblViewLadies;

    @FXML
    private JFXTextField txtItemCodeL;

    @FXML
    private JFXTextField txtItemCodeK;

    @FXML
    private JFXTextField txtItemNameL;

    @FXML
    private JFXTextField txtItemNameK;


    @FXML
    private JFXTextField txtItemQtyL;

    @FXML
    private JFXTextField txtQtyK;

    @FXML
    private JFXTextField txtSizeL;

    @FXML
    private JFXTextField txtSizeK;

    @FXML
    private TableColumn<?, ?> colSizeK;


    @FXML
    private JFXTextField txtColorL;

    @FXML
    private JFXTextField txtColorK;

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
    private TableView<KidsProductsEntity> tblViewK;


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
            colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

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
        colLadiesPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        LadiesProductsBo ladiesProductsBo=BoFactory.getInstance().getBoType(BoType.LADIESPRODUCTS);
        tblViewLadies.setItems(ladiesProductsBo.getAll());


    }
    @FXML
    void btnKidsOnAction(ActionEvent event) {
        page.setVisible(false);
        page=KidsProductPage;
        page.setVisible(true);

        colItemCodeK.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colItemNameK.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colQtyK.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colSizeK.setCellValueFactory(new PropertyValueFactory<>("size"));
        colColorK.setCellValueFactory(new PropertyValueFactory<>("color"));
        colPriceK.setCellValueFactory(new PropertyValueFactory<>("price"));


        KidsProductsBo kidsProductsBo=BoFactory.getInstance().getBoType(BoType.KIDSPRODUCTS);
        tblViewK.setItems(kidsProductsBo.getAll());

    }

    public void btnAddOnAction(ActionEvent actionEvent) {

            GentsProductsBo gentsProductsBo = BoFactory.getInstance().getBoType(BoType.GENTSPRODUCTS);
            GentsProducts gentsProducts = new GentsProducts(
                    Integer.parseInt(txtItemCode.getText()),
                    txtItemName.getText(),
                    Integer.parseInt(txtQty.getText()),
                    txtSize.getText(),
                    txtColor.getText(),
                    Double.parseDouble(txtPrice.getText())
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
                txtColorL.getText(),
                Double.parseDouble(txtPriceL.getText())
        );
        ladiesProductsBo.addLadiesProducts(ladiesProducts);

    }

    @FXML
    void btnAddOnActionK(ActionEvent event) {
        KidsProductsBo kidsProductsBo=BoFactory.getInstance().getBoType(BoType.KIDSPRODUCTS);
        KidsProducts kidsProducts=new KidsProducts(
                Integer.parseInt(txtItemCodeK.getText()),
                txtItemNameK.getText(),
                Integer.parseInt(txtQtyK.getText()),
                txtSizeK.getText(),
                txtColorK.getText(),
                Double.parseDouble(txtPricerK.getText())
        );

        kidsProductsBo.addKidsProducts(kidsProducts);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        GentsProductsBo gentsProductsBo = BoFactory.getInstance().getBoType(BoType.GENTSPRODUCTS);
        GentsProducts gentsProducts = new GentsProducts(
                Integer.parseInt(txtItemCode.getText()),
                txtItemName.getText(),
                Integer.parseInt(txtQty.getText()),
                txtSize.getText(),
                txtColor.getText(),
                Double.parseDouble(txtPrice.getText())
        );
        gentsProductsBo.deleteGentsProducts(gentsProducts);

    }

    @FXML
    void btnDeleteOnActionL(ActionEvent event) {
        LadiesProductsBo ladiesProductsBo = BoFactory.getInstance().getBoType(BoType.LADIESPRODUCTS);
        LadiesProducts ladiesProducts = new LadiesProducts(
                Integer.parseInt(txtItemCodeL.getText()),
                txtItemNameL.getText(),
                Integer.parseInt(txtItemQtyL.getText()),
                txtSizeL.getText(),
                txtColorL.getText(),
                Double.parseDouble(txtPriceL.getText())
        );
        ladiesProductsBo.deleteLadiesProducts(ladiesProducts);
    }

    @FXML
    void btnDeleteOnActionK(ActionEvent event) {
        KidsProductsBo kidsProductsBo=BoFactory.getInstance().getBoType(BoType.KIDSPRODUCTS);
        KidsProducts kidsProducts=new KidsProducts(
                Integer.parseInt(txtItemCodeK.getText()),
                txtItemNameK.getText(),
                Integer.parseInt(txtQtyK.getText()),
                txtSizeK.getText(),
                txtColorK.getText(),
                Double.parseDouble(txtPricerK.getText())
        );

        kidsProductsBo.deleteKidsProducts(kidsProducts);
    }



    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        GentsProductsBo gentsProductsBo = BoFactory.getInstance().getBoType(BoType.GENTSPRODUCTS);
        GentsProducts gentsProducts = new GentsProducts(
                Integer.parseInt(txtItemCode.getText()),
                txtItemName.getText(),
                Integer.parseInt(txtQty.getText()),
                txtSize.getText(),
                txtColor.getText(),
                Double.parseDouble(txtPrice.getText())
        );
        gentsProductsBo.updateGentsProducts(gentsProducts);

    }

    @FXML
    void btnUpdateOnActionL(ActionEvent event) {
        LadiesProductsBo ladiesProductsBo = BoFactory.getInstance().getBoType(BoType.LADIESPRODUCTS);
        LadiesProducts ladiesProducts = new LadiesProducts(
                Integer.parseInt(txtItemCodeL.getText()),
                txtItemNameL.getText(),
                Integer.parseInt(txtItemQtyL.getText()),
                txtSizeL.getText(),
                txtColorL.getText(),
                Double.parseDouble(txtPriceL.getText())
        );
        ladiesProductsBo.updateLadiesProducts(ladiesProducts);

    }

    @FXML
    void btnUpdateOnActionK(ActionEvent event) {
        KidsProductsBo kidsProductsBo=BoFactory.getInstance().getBoType(BoType.KIDSPRODUCTS);
        KidsProducts kidsProducts=new KidsProducts(
                Integer.parseInt(txtItemCodeK.getText()),
                txtItemNameK.getText(),
                Integer.parseInt(txtQtyK.getText()),
                txtSizeK.getText(),
                txtColorK.getText(),
                Double.parseDouble(txtPricerK.getText())
        );

        kidsProductsBo.updateLKidsProducts(kidsProducts);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        page=gentsProductPage;
        page.setVisible(true);


        tblView.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) ->{
            if(newValue!=null){
                setTextToValuesG(newValue);
            }
        } ));
        tblViewLadies.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) ->{
            if(newValue!=null){
                setTextToValuesL(newValue);
            }
        } ));
        tblViewK.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) ->{
            if(newValue!=null){
                setTextToValuesK(newValue);
            }
        } ));
    }

    private void setTextToValuesK(KidsProductsEntity newValue) {
        txtItemCodeK.setText(newValue.getItemCode().toString());
        txtItemNameK.setText(newValue.getItemName());
        txtQtyK.setText(newValue.getQty().toString());
        txtSizeK.setText(newValue.getSize());
        txtColorK.setText(newValue.getColor());
        txtPricerK.setText(newValue.getPrice().toString());
    }

    private void setTextToValuesL(LadiesProductsEntity newValue) {
        txtItemCodeL.setText(newValue.getItemCode().toString());
        txtItemNameL.setText(newValue.getItemName());
        txtItemQtyL.setText(newValue.getQty().toString());
        txtSizeL.setText(newValue.getSize());
        txtColorL.setText(newValue.getColor());
        txtPriceL.setText(newValue.getPrice().toString());
    }

    private void setTextToValuesG(GentsProductsEntity newValue) {
        txtItemCode.setText(newValue.getItemCode().toString());
        txtItemName.setText(newValue.getItemName());
        txtQty.setText(newValue.getQty().toString());
        txtSize.setText(newValue.getSize());
        txtColor.setText(newValue.getColor());
        txtPrice.setText(newValue.getPrice().toString());
    }
}
