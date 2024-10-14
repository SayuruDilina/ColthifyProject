package edu.icet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class KidsProductsEntity {
    @Id
    private Integer itemCode;
    private String itemName;
    private Integer qty;
    private String size;
    private String color;
    private Double price;
}
