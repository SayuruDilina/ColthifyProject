package edu.icet.bo.custom;

import edu.icet.bo.SuperBo;
import edu.icet.dto.LadiesProducts;
import edu.icet.dto.Orders;

public interface OrdersBo extends SuperBo {
    boolean addOrders(Orders orders);
}
