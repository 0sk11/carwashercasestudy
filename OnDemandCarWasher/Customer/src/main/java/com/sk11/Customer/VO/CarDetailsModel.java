package com.sk11.Customer.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDetailsModel {
    @Id
    private String id;
    private String type;
    private Double price;
    private boolean active;

}
