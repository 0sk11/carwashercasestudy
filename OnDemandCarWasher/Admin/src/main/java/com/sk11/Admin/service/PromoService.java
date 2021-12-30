package com.sk11.Admin.service;

import com.sk11.Admin.model.AddOnsModel;
import com.sk11.Admin.model.PromoModel;
import com.sk11.Admin.repository.PromoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromoService {
    @Autowired
    private PromoRepository promoRepository;

    public void save (PromoModel promo){
        promoRepository.save(promo);
    }

    public List<PromoModel> findAll(){
        List<PromoModel> promoList = promoRepository.findAll();
        if(promoList.size()>0){
            return promoList;
        }
        return null;
    }


    public String deleteById(String id){
        if(promoRepository.findById(id).isPresent()){
            promoRepository.deleteById(id);
            return "Successfully Deleted";
        }
        return "Could not any Item";
    }
}
