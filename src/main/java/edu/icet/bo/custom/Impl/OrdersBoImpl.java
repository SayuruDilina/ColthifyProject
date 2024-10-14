package edu.icet.bo.custom.Impl;

import edu.icet.bo.custom.OrdersBo;
import edu.icet.dao.DaoFactory;
import edu.icet.dao.custom.OrdersDao;
import edu.icet.db.DBConnection;
import edu.icet.dto.Cart;
import edu.icet.dto.Orders;
import edu.icet.dto.OrdersEntity;
import edu.icet.util.DaoType;
import org.modelmapper.ModelMapper;

import java.sql.*;

public class OrdersBoImpl implements OrdersBo {
    @Override
    public boolean addOrders(Orders orders) {

        try {
            String SQL="INSERT INTO orders VALUES(?,?,?,?)";
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1,orders.getOrderId());
            preparedStatement.setObject(2,orders.getCustomerName());
            preparedStatement.setObject(3,orders.getEmail());
            preparedStatement.setObject(4,orders.getNetTotal());
            boolean isAdd=preparedStatement.executeUpdate()>0;
            boolean isOrder=false;
            if(isAdd) {
                isOrder=true;
                ResultSet genrateKeys = preparedStatement.getGeneratedKeys();
                int orderId = -1;
                if (genrateKeys.next()) {
                    orderId = genrateKeys.getInt(1);
                }
                String SQLCart = "INSERT INTO cart(orderId,itemName,quantity,total) VALUES(?,?,?,?)";
                PreparedStatement pstmCart = connection.prepareStatement(SQLCart);
                for (Cart item : orders.getOrderItems()) {
                    pstmCart.setObject(1, orderId);
                    pstmCart.setObject(2, item.getItemName());
                    pstmCart.setObject(3, item.getQty());
                    pstmCart.setObject(4, item.getTotal());
                    pstmCart.executeUpdate();
                }if(isOrder=true){
                    String SQLSelectTable1="SELECT COUNT(*) FROM gentsproductsentity WHERE itemName=?";
                    PreparedStatement psSelect1 = connection.prepareStatement(SQLSelectTable1);
                 for (Cart item :orders.getOrderItems()){
                     boolean itemUpdated=false;
                     psSelect1.setObject(1,item.getItemName());
                     ResultSet rs1=psSelect1.executeQuery();
                     if (rs1.next()&& rs1.getInt(1)>0){
                         String SqlUpdate="UPDATE gentsproductsentity SET qty=qty-? WHERE itemName=? ";
                         PreparedStatement pstmUpdate = connection.prepareStatement(SqlUpdate);
                         pstmUpdate.setObject(1,item.getQty());
                         pstmUpdate.setObject(2,item.getItemName());
                         pstmUpdate.executeUpdate();
                         System.out.println("All Done");
                         System.out.println("1"+item.getItemName());
                         itemUpdated=true;
                     }if(!itemUpdated) {
                         String SQLSelectTable2="SELECT COUNT(*) FROM ladiesproductsentity WHERE itemName=?";
                         PreparedStatement psSelect2 = connection.prepareStatement(SQLSelectTable2);
                         psSelect2.setObject(1,item.getItemName());
                         ResultSet rs2 = psSelect2.executeQuery();
                         if (rs2.next() && rs2.getInt(1)>0){
                             String SqlUpdate="UPDATE ladiesproductsentity SET qty=qty-? WHERE itemName=? ";
                             PreparedStatement pstmUpdate = connection.prepareStatement(SqlUpdate);
                             pstmUpdate.setObject(1,item.getQty());
                             pstmUpdate.setObject(2,item.getItemName());
                             pstmUpdate.executeUpdate();
                             System.out.println("2"+item.getItemName());
                             System.out.println("All Done");
                             itemUpdated=true;

                         }if (!itemUpdated){
                             String SQLSelectTable3="SELECT COUNT(*) FROM kidsproductsentity WHERE itemName=?";
                             PreparedStatement psSelect3 = connection.prepareStatement(SQLSelectTable3);
                             psSelect3.setObject(1,item.getItemName());
                             ResultSet rs3 = psSelect3.executeQuery();
                             if (rs3.next() && rs3.getInt(1)>0){
                                 String SqlUpdate="UPDATE kidsproductsentity SET qty=qty-? WHERE itemName=? ";
                                 PreparedStatement pstmUpdate = connection.prepareStatement(SqlUpdate);
                                 pstmUpdate.setObject(1,item.getQty());
                                 pstmUpdate.setObject(2,item.getItemName());
                                 pstmUpdate.executeUpdate();
                                 System.out.println("All Done");
                             }
                         }

                     }

                 }

                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}