/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto2_Web.interfaces;

import Reto2_Web.model.Accessory;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Nigth Crawler
 */
public interface InterfaceAccessory extends MongoRepository<Accessory, String>{
    
}
