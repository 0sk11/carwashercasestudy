package com.sk11.Admin.repository;

import com.sk11.Admin.model.CarDetailsModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarDetailsReposistory extends MongoRepository<CarDetailsModel,String> {
}
