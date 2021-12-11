/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto2_Web.interfaces;

import Reto2_Web.model.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Nigth Crawler
 */
public interface InterfaceOrder extends MongoRepository<Order, Integer> {
    
    @Query("{'salesMan.zone': ?0}")            
    List<Order> findByZone(final String zone);
    
    @Query("{status: ?0}")            
    List<Order> findByStatus(final String status);
    
    Optional<Order> findTopByOrderByIdDesc();
}
