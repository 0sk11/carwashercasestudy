package com.sk11.Customer.controller;

import com.sk11.Customer.VO.AddOnsModel;
import com.sk11.Customer.VO.CarDetailsModel;
import com.sk11.Customer.VO.PromoModel;
import com.sk11.Customer.model.CustomerModel;
import com.sk11.Customer.model.OrderModel;
import com.sk11.Customer.repository.OrderRepository;
import com.sk11.Customer.service.CustomerService;
import com.sk11.Customer.service.OrderService;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/user")
@CrossOrigin(origins="*")
public class CustomerController {
        @Autowired
        private  CustomerService customerService;

        @Autowired
        private OrderService orderService;

        @GetMapping("/")
        public ResponseEntity<?>home(){
            return new ResponseEntity<>("Hello",HttpStatus.OK);
        }

        @PostMapping("/new_customer")
        public ResponseEntity<?> addCustomer(@RequestBody CustomerModel customer){
            try{
                customerService.save(customer);
                return new ResponseEntity<>("Added", HttpStatus.OK);
            }catch (Exception e){
                //add Logger method
                 return  new ResponseEntity<>("Order could not be placed : ",HttpStatus.BAD_REQUEST);
            }
        }
    @PostMapping("/new_order")
    public ResponseEntity<?> addNewOrder(@RequestBody OrderModel customer){
        try{
            orderService.save(customer);
            return new ResponseEntity<>("Added", HttpStatus.OK);
        }catch (Exception e){
            //add Logger method
            return  new ResponseEntity<>("Order could not be placed : ",HttpStatus.BAD_REQUEST);
        }
    }
        @GetMapping("/view_orders")
        public ResponseEntity<?> viewAllOrders(){
            List<OrderModel> listOfOrders = orderService.findAll();
            if(listOfOrders!=null){
                return new ResponseEntity<>(listOfOrders,HttpStatus.OK);
            }
            return new ResponseEntity<>("No Orders Found",HttpStatus.NOT_FOUND);
        }

        @GetMapping("/view_addons")
        public List<AddOnsModel> viewAddons(){
            return List.of(orderService.addOns());
        }

        @GetMapping("/view_promos")
        public List<PromoModel> viewPromos(){
            return List.of(orderService.promos());
        }

        @GetMapping("/view_cardetails")
        public List<CarDetailsModel> carDetails(){
            return List.of(orderService.carDetails());
        }

        @DeleteMapping("/delete_order/{id}")
        public ResponseEntity<?> deletePromo(@PathVariable("id") String id){
            return new  ResponseEntity<>(orderService.deleteById(id),HttpStatus.OK);
        }

}
