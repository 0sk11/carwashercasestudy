package com.sk11.Admin.repository;

import com.sk11.Admin.model.PromoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface PromoRepository extends MongoRepository<PromoModel,String> {
    PromoModel findByCode(String code);

}
