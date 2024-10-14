package edu.icet.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.icet.bo.BoFactory;
import edu.icet.bo.custom.GentsProductsBo;
import edu.icet.bo.custom.KidsProductsBo;
import edu.icet.bo.custom.LadiesProductsBo;
import edu.icet.bo.custom.OrdersBo;
import edu.icet.dto.Cart;
import edu.icet.dto.Orders;
import edu.icet.entity.GentsProductsEntity;
import edu.icet.entity.KidsProductsEntity;
import edu.icet.entity.LadiesProductsEntity;
import edu.icet.util.BoType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class OrderFormController implements Initializable {


    @FXML
    private AnchorPane placeOrderPage;

    @FXML
    private AnchorPane updateOrderPage;

    @FXML
    private JFXTextField txtSearchEmail;


    @FXML
    private JFXTextField txtEmailSea;

    @FXML
    private JFXTextField txtCustomerNameSea;

    @FXML
    private Label lblItemName;

    @FXML
    private Spinner<Integer> spinQty;

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
    private TableColumn<?, ?> colPrice;


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
    private Label lblTotalCard;

    @FXML
    private TableView<Cart> tblCartView;

    @FXML
    private TableView tblView;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtPaid;
    ObservableList<Cart> cartList=FXCollections.observableArrayList();


    Double netTot=0.0;
    @FXML
    void btnAddCartOnAction(ActionEvent event) {
            //colItemNameCart.setCellValueFactory();
        Cart cart=new Cart(
                lblItemName.getText(),
                spinQty.getValue(),
               Double.parseDouble(lblTotalCard.getText())

                 );
        System.out.println(cart);
        colItemNameCart.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colQtyCart.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colTotalCart.setCellValueFactory(new PropertyValueFactory<>("total"));
        cartList.add(cart);
        tblCartView.setItems(cartList);

         netTot+= cart.getTotal();
        lblnetTot.setText(netTot.toString());
        //System.out.println(netTot);
        System.out.println(cartList);
    }
    @FXML
    void btnPlaceOrderPageInAction(ActionEvent event) {

    }

    @FXML
    void btnSearchUpdatePageOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOrderPageOnAction(ActionEvent event) {

    }
    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) throws MessagingException {
        String  reciptEmail = txtEmail.getText();
       sendEmail(reciptEmail);
        List<Cart> orderDetails=new ArrayList<>();
        cartList.forEach(obj->{
            orderDetails.add(new Cart(obj.getItemName(),obj.getQty(),obj.getTotal()));
        });
        Orders orders=new Orders(0,orderDetails,txtCustomerName.getText(),txtEmail.getText(),Double.parseDouble(lblnetTot.getText()));
        System.out.println(orders);
        OrdersBo ordersBo=BoFactory.getInstance().getBoType(BoType.ORDERS);
        ordersBo.addOrders(orders);




    }

    private void sendEmail(String reciptEmail) throws MessagingException {
        Properties properties=new Properties();

        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        String myEmail="tumiraduli@gmail.com";
        String password="yqrm tjue dogq qsqg";
       javax.mail.Session session = javax.mail.Session.getInstance(properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(myEmail, password);
                    }
                }
        );

        Message message=prepareMessage(session,myEmail,reciptEmail,cartList);
        if(message!=null){
            Alert emailSentSuccessfully = new Alert(Alert.AlertType.INFORMATION, "Email Sent Successfully");
            emailSentSuccessfully.showAndWait();
        }else{
            Alert pleaseTryAgain = new Alert(Alert.AlertType.ERROR, "Please Try Again");
            pleaseTryAgain.showAndWait();
        }
        Transport.send(message);

    }

    private Message prepareMessage(Session session, String myEmail, String reciptEmail, ObservableList<Cart> text) {
  Message message=new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myEmail));
            message.setRecipients(Message.RecipientType.TO,new InternetAddress[]{
                    new InternetAddress(reciptEmail)
            });
            message.setSubject(" Your Bill");
           // message.setText(text);
            String name=txtCustomerName.getText();
            StringBuilder emailBody=new StringBuilder();
            emailBody.append("Dear Cutomer"+name+",\n\n");
            emailBody.append("Thank You For Your Order.here Your Bill Details:\n\n");
            emailBody.append(String.format("%-20s %-10s %-10s\n", "Item Name", "Quantity", "Total"));


            emailBody.append("-------------------------------------------------------------\n");
           for(Cart item:cartList){
               emailBody.append(String.format("%-20s %-10d %-10.2f\n", item.getItemName(), item.getQty(), item.getTotal()));

           }

            emailBody.append("-----------------------------------------------------\n");
            emailBody.append(String.format("Total Amount: %.2f\n",netTot));
            emailBody.append("\nThank you for your business!\n");
            message.setText(emailBody.toString());

            return  message;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> category= FXCollections.observableArrayList();
        category.add("Gents");
        category.add("Ladies");
        category.add("Kids");
        cmbCategory.setItems(category);
        SpinnerValueFactory<Integer> valueFactory=new SpinnerValueFactory.IntegerSpinnerValueFactory(1,50);
        valueFactory.setValue(1);
        spinQty.setValueFactory(valueFactory);

       spinQty.valueProperty().addListener(new ChangeListener<Integer>() {
           @Override
           public void changed(ObservableValue<? extends Integer> observableValue, Integer oldValue, Integer newValue) {
                    updateCardTot();

           }
       });

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

    Double price=0.0;
    private void updateCardTot() {

        Integer qty=spinQty.getValue();
        Double tot=price * qty;

        lblTotalCard.setText(tot.toString());
    }

    private void addToCard(Object newValue) {
        if (newValue instanceof GentsProductsEntity){
            lblItemName.setText(((GentsProductsEntity) newValue).getItemName());
           lblTotalCard.setText(((GentsProductsEntity) newValue).getPrice().toString());
           price=((GentsProductsEntity) newValue).getPrice();
               System.out.println(newValue);
        } else if (newValue instanceof LadiesProductsEntity) {
            lblItemName.setText(((LadiesProductsEntity) newValue).getItemName());
            lblTotalCard.setText(((LadiesProductsEntity) newValue).getPrice().toString());
            price=((LadiesProductsEntity) newValue).getPrice();
        } else if (newValue instanceof KidsProductsEntity) {
            lblItemName.setText(((KidsProductsEntity) newValue).getItemName());
            lblTotalCard.setText(((KidsProductsEntity) newValue).getPrice().toString());
            price=((KidsProductsEntity) newValue).getPrice();
        }


    }

    private void loadTable(String newValue) {
        if(newValue=="Gents"){
            colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
            colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
            colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
            colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

            GentsProductsBo gentsProductsBo= BoFactory.getInstance().getBoType(BoType.GENTSPRODUCTS);
            tblView.setItems(gentsProductsBo.getAll());
        } else if (newValue=="Ladies") {
            colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
            colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
            colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
            colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

            LadiesProductsBo ladiesProductsBo=BoFactory.getInstance().getBoType(BoType.LADIESPRODUCTS);
            tblView.setItems(ladiesProductsBo.getAll());
        } else if (newValue=="Kids") {
            colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
            colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
            colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
            colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

            KidsProductsBo kidsProductsBo=BoFactory.getInstance().getBoType(BoType.KIDSPRODUCTS);
            tblView.setItems(kidsProductsBo.getAll());
        }
    }
}
