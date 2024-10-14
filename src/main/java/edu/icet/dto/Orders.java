package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Orders {

    private  Integer orderId;
    private List<Cart> orderItems;
    private  String customerName;
    private  String email;
    private  Double netTotal;
}
