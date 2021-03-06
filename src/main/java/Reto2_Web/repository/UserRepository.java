package Reto2_Web.repository;

//@author Nigth Crawler

import Reto2_Web.interfaces.InterfaceUser;
import Reto2_Web.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository {

    @Autowired
    private InterfaceUser crudInterface;

    public List<User> listAll() {
        return crudInterface.findAll();
    }

    public Optional<User> getUser(int id) {
        return crudInterface.findById(id);
    }

    public User create(User user) {
        return crudInterface.save(user);
    }

    public void update(User user) {
        crudInterface.save(user);
    }
    
    public void delete(User user) {
        crudInterface.delete(user);
    }

    public boolean emailExist(String email) {
        Optional<User> usuario = crudInterface.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<User> autenticateUser(String email, String password) {
        return crudInterface.findByEmailAndPassword(email, password);
    }
    
     public Optional<User> lastUserId(){
        return crudInterface.findTopByOrderByIdDesc();
    }
    public List<User> listBirthtDayMonth(String month){
        return crudInterface.findByMonthBirthtDay(month);
    }
}
