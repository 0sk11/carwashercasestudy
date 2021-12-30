package com.sk11.Admin.repository;

import com.sk11.Admin.model.AddOnsModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddOnsRepository extends MongoRepository<AddOnsModel,String> {
}
