package com.sk11.Admin.controller;

import com.sk11.Admin.model.AddOnsModel;
import com.sk11.Admin.model.CarDetailsModel;
import com.sk11.Admin.model.PromoModel;
import com.sk11.Admin.service.*;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="*")
public class AdminController {
    @Autowired
    private AddOnService addOnService;

    @Autowired
    private PromoService promoService;

    @Autowired
    private CarDetailsService carDetailsService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private WasherService washerService;

    @PostMapping("/new_addon")
    public ResponseEntity<?> addAddOnsPost(@RequestBody AddOnsModel addon){
        try{
            addOnService.save(addon);
            return new ResponseEntity<>("Added", HttpStatus.OK);
        }catch (Exception e){
            //add Logger method
            return  new ResponseEntity<>("Order could not be placed : ",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/new_promo")
    public ResponseEntity<?> addAddOnsPost(@RequestBody PromoModel promoModel){
        try{
            promoService.save(promoModel);
            return new ResponseEntity<>("Added", HttpStatus.OK);
        }catch (Exception e){
            //add Logger method
            return  new ResponseEntity<>("Order could not be placed : ",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/new_car")
    public ResponseEntity<?> carDetailsPost(@RequestBody CarDetailsModel carDetailsModel){
        try{
            carDetailsService.save(carDetailsModel);
            return new ResponseEntity<>("Added", HttpStatus.OK);
        }catch (Exception e){
            //add Logger method
            return  new ResponseEntity<>("Order could not be placed : ",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all/car_details")
    public ResponseEntity<?> carDetailsAllGet(){
        return new ResponseEntity<>(carDetailsService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/all/promo")
    public ResponseEntity<?> promoAllGet(){
        return new ResponseEntity<>(promoService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/all/add_ons")
    public ResponseEntity<?> addOnsAllGet(){
        return new ResponseEntity<>(addOnService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/all/customer")
    public ResponseEntity<?> getAllCustomers(){
        return new ResponseEntity<>(customerService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/all/washers")
    public ResponseEntity<?> getWashers(){ return new ResponseEntity<>(washerService.findAll(),HttpStatus.OK);}

    @DeleteMapping("/delete_promo/{id}")
    public ResponseEntity<?> deletePromo(@PathVariable("id") String id){
       return new  ResponseEntity<>(promoService.deleteById(id),HttpStatus.OK);
    }
    @DeleteMapping("/delete_washer/{id}")
    public ResponseEntity<?> deleteCarWasher(@PathVariable("id") String id){
        return new  ResponseEntity<>(washerService.deleteById(id),HttpStatus.OK);
    }
    @DeleteMapping("/delete_addons/{id}")
    public ResponseEntity<?> deleteAddons(@PathVariable("id") String id){
        return new  ResponseEntity<>(addOnService.deleteById(id),HttpStatus.OK);
    }
    @DeleteMapping("/delete_customer/{id}")
    public ResponseEntity<?> deleteCustomers(@PathVariable("id") String id){
        return new  ResponseEntity<>(customerService.deleteById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete_cardetails/{id}")
    public ResponseEntity<?> deleteCarDetails(@PathVariable("id") String id){
        return new  ResponseEntity<>(carDetailsService.deleteById(id),HttpStatus.OK);
    }


}
