package com.sk11.Customer.service;

import com.sk11.Customer.VO.AddOnsModel;
import com.sk11.Customer.VO.CarDetailsModel;
import com.sk11.Customer.VO.PromoModel;
import com.sk11.Customer.VO.ResponseTemplateVO;
import com.sk11.Customer.model.CustomerModel;
import com.sk11.Customer.model.OrderModel;
import com.sk11.Customer.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    RestTemplate restTemplate;


    public String save(OrderModel order) {
        orderRepository.save(order);
        return "Successfully Added";
    }

    public List<OrderModel> findAll() {
        List<OrderModel> orderList = orderRepository.findAll();
        if(orderList.size()>0){
            return orderList;
        }
        return null;
    }
    public AddOnsModel[] addOns() {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        ResponseEntity<AddOnsModel[]> responseEntity = restTemplate.getForEntity("http://ADMIN-SERVICE/admin/all/add_ons",AddOnsModel
                [].class);
        AddOnsModel[] addOns = responseEntity.getBody();

        return addOns;
    }

    public PromoModel[] promos() {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        ResponseEntity<PromoModel[]> responseEntity = restTemplate.getForEntity("http://ADMIN-SERVICE/admin/all/promo",PromoModel
                [].class);
        PromoModel[] promo = responseEntity.getBody();

        return promo;
    }
    public CarDetailsModel[] carDetails() {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        ResponseEntity<CarDetailsModel[]> responseEntity = restTemplate.getForEntity("http://ADMIN-SERVICE/admin/all/car_details",CarDetailsModel
                [].class);
        CarDetailsModel[] carDetails = responseEntity.getBody();

        return carDetails;
    }
    public String deleteById(String id){
        orderRepository.deleteById(id);
        return "Successfully Deleted";
    }
}
