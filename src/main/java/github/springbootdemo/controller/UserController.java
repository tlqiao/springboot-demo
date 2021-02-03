package github.springbootdemo.controller;

import github.springbootdemo.entity.User;
import github.springbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addUser(@RequestParam  String name, @RequestParam  String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
    }
    @RequestMapping(value="/findAll",method =RequestMethod.GET)
    public Iterable<User> getUserByName(){
       return  userRepository.findAll();
    }
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public Optional<User> getUserById(@PathVariable Integer id){
        return userRepository.findById(id);
    }

    @RequestMapping(value="/findByName/{userName}",method=RequestMethod.GET)
    public List<User> getUserByName(@PathVariable String userName){return userRepository.findUserByName(userName);}
}
