package Reto2_Web.service;

//@author Nigth Crawler

import Reto2_Web.model.Accessory;
import Reto2_Web.repository.AccessoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessoryService {
    @Autowired
    private AccessoryRepository clotheRepository;

    public List<Accessory> getAll() {
        return clotheRepository.getAll();
    }

   public Optional<Accessory> getAccessory(String reference) {
        return clotheRepository.getAccessory(reference);
    }

    public Accessory create(Accessory accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return clotheRepository.create(accesory);
        }
    }

    public Accessory update(Accessory accesory) {

        if (accesory.getReference() != null) {
            Optional<Accessory> accesoryDb = clotheRepository.getAccessory(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                clotheRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getAccessory(reference).map(accesory -> {
            clotheRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
