package com.sk11.Customer.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOnsModel {
    @Id
    private String id;
    private String addon;
    private double cost;
    private boolean active;
}
