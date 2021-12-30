package com.sk11.Admin.service;

import com.sk11.Admin.model.CarDetailsModel;
import com.sk11.Admin.model.PromoModel;
import com.sk11.Admin.repository.CarDetailsReposistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarDetailsService {
    @Autowired
    private CarDetailsReposistory carDetailsReposistory;
    public void save (CarDetailsModel car){
        carDetailsReposistory.save(car);
    }

    public List<CarDetailsModel> findAll(){
        List<CarDetailsModel> carDetailsList = carDetailsReposistory.findAll();
        if(carDetailsList.size()>0){
            return carDetailsList;
        }
        return null;
    }

    public String deleteById(String id){
        if(carDetailsReposistory.findById(id).isPresent()){
            carDetailsReposistory.deleteById(id);
            return "Successfully Deleted";
        }
        return "Could not any Item";
    }
}
