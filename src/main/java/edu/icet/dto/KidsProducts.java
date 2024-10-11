package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KidsProducts {

    private Integer itemCode;
    private String itemName;
    private Integer qty;
    private String size;
    private String color;

}
