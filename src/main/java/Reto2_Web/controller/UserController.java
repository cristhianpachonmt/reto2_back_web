package Reto2_Web.controller;

//@author Nigth Crawler

import Reto2_Web.model.User;
import Reto2_Web.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService servicio;

    @GetMapping("/all")
    public List<User> listAll() {
        return servicio.listAll();
    }
    
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int id){
        return servicio.getUser(id);
    }  
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return servicio.create(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return servicio.update(user);
    }

    @GetMapping("/emailexist/{email}")
    public boolean emailExist(@PathVariable("email") String email) {
        return servicio.emailExist(email);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return servicio.delete(id);
    }
       
    @GetMapping("/{email}/{password}")
    public User autenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return servicio.autenticateUser(email, password);
    }
    @GetMapping("/birthday/{month}")
    public List<User> listBirthtDayMonth(@PathVariable("month") String month){
        return servicio.listBirthtDayMonth(month);
    }
}
