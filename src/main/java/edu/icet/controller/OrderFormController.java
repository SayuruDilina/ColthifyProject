package edu.icet.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.icet.bo.BoFactory;
import edu.icet.bo.custom.GentsProductsBo;
import edu.icet.bo.custom.KidsProductsBo;
import edu.icet.bo.custom.LadiesProductsBo;
import edu.icet.entity.GentsProductsEntity;
import edu.icet.entity.KidsProductsEntity;
import edu.icet.entity.LadiesProductsEntity;
import edu.icet.util.BoType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class OrderFormController implements Initializable {

    @FXML
    private Label lblItemName;

    @FXML
    private Spinner<?> spinQty;

    @FXML
    private JFXComboBox<String> cmbCategory;

    @FXML
    private TableColumn<?, ?> colColor;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colItemName;

    @FXML
    private TableColumn<?, ?> colItemNameCart;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colQtyCart;

    @FXML
    private TableColumn<?, ?> colSize;

    @FXML
    private TableColumn<?, ?> colTotalCart;

    @FXML
    private Label lblBalance;

    @FXML
    private Label lblnetTot;

    @FXML
    private TableView<?> tblCartView;

    @FXML
    private TableView tblView;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtPaid;

    @FXML
    void btnAddCartOnAction(ActionEvent event) {
            colItemNameCart.setCellValueFactory(new PropertyValueFactory<>(lblItemName.getText()));

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> category= FXCollections.observableArrayList();
        category.add("Gents");
        category.add("Ladies");
        category.add("Kids");
        cmbCategory.setItems(category);

        cmbCategory.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->{
            //System.out.println(newValue);
            if (newValue!=null){
                loadTable(newValue);

            }
        } );

        tblView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->{
            if(newValue!=null){
                addToCard(newValue);
            }
        } );
    }

    private void addToCard(Object newValue) {
        if (newValue instanceof GentsProductsEntity){
            lblItemName.setText(((GentsProductsEntity) newValue).getItemName());
               System.out.println(newValue);
        } else if (newValue instanceof LadiesProductsEntity) {
            lblItemName.setText(((LadiesProductsEntity) newValue).getItemName());

        } else if (newValue instanceof KidsProductsEntity) {
            lblItemName.setText(((KidsProductsEntity) newValue).getItemName());
        }


    }

    private void loadTable(String newValue) {
        if(newValue=="Gents"){
            colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
            colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
            colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            colColor.setCellValueFactory(new PropertyValueFactory<>("color"));

            GentsProductsBo gentsProductsBo= BoFactory.getInstance().getBoType(BoType.GENTSPRODUCTS);
            tblView.setItems(gentsProductsBo.getAll());
        } else if (newValue=="Ladies") {
            colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
            colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
            colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
            LadiesProductsBo ladiesProductsBo=BoFactory.getInstance().getBoType(BoType.LADIESPRODUCTS);
            tblView.setItems(ladiesProductsBo.getAll());
        } else if (newValue=="Kids") {
            colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
            colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
            colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            colColor.setCellValueFactory(new PropertyValueFactory<>("color"));

            KidsProductsBo kidsProductsBo=BoFactory.getInstance().getBoType(BoType.KIDSPRODUCTS);
            tblView.setItems(kidsProductsBo.getAll());
        }
    }
}
