package com.sk11.Admin.repository;

import com.sk11.Admin.model.WasherModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WasherRepository extends MongoRepository<WasherModel,String> {

}
