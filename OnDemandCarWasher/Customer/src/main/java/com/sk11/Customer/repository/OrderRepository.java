package com.sk11.Customer.repository;

import com.sk11.Customer.model.OrderModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderModel,String> {

}
