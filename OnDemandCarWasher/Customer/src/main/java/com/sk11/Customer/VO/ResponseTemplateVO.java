package com.sk11.Customer.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private AddOnsModel addOns;
    private CarDetailsModel CarDetails;
    private PromoModel promo;
}
