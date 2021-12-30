package com.sk11.CarWasher.Controller;

import com.sk11.CarWasher.VO.Customer;
import com.sk11.CarWasher.VO.Order;
import com.sk11.CarWasher.VO.ResponseTemplateVO;
import com.sk11.CarWasher.model.WasherModel;
import com.sk11.CarWasher.services.CarWasherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/carwasher")
public class CarWasherController {
    @Autowired
    private CarWasherService carWasherService;
    @GetMapping("/")
    public String home(){
        return "hello";
    }
    @GetMapping("/view_orders")
    public List<Order> vieworders(){
        return List.of(carWasherService.vieworders());
    }
    @PostMapping("/order/{id}")
    public ResponseEntity<?> AcceptOrRejectOrder(@PathVariable("id" )Long id){
        return  null;
    }
    @PostMapping("/new_washer")
    public ResponseEntity<?> newWasher(@RequestBody WasherModel washerModel){
        try{
            carWasherService.save(washerModel);
            return new ResponseEntity<>("Added", HttpStatus.OK);
        }catch (Exception e){
            //add Logger method
            return  new ResponseEntity<>("Washer could not be Added : ",HttpStatus.BAD_REQUEST);
        }
    }
    
}
