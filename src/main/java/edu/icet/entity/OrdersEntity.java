package edu.icet.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
public class OrdersEntity {
    @Id
    private  Integer orderId;
    private List<Cart> orderItems;
    private String customerName;
    private  String email;
    private  Double netTotal;
}
