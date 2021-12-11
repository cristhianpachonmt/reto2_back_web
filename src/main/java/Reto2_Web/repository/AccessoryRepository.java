package Reto2_Web.repository;

//@author Nigth Crawler

import Reto2_Web.interfaces.InterfaceAccessory;
import Reto2_Web.model.Accessory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccessoryRepository {

    @Autowired
    private InterfaceAccessory crudInterface;

    public List<Accessory> listAll() {
        return crudInterface.findAll();
    }

    public Optional<Accessory> getAccesory(String reference) {
        return crudInterface.findById(reference);
    }

    public Accessory create(Accessory accesory) {
        return crudInterface.save(accesory);
    }

    public void update(Accessory accesory) {
        crudInterface.save(accesory);
    }

    public void delete(Accessory accesory) {
        crudInterface.delete(accesory);
    }
}
