package ru.example.mvcdocker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import ru.example.mvcdocker.entity.UserEntity;
import ru.example.mvcdocker.repos.UserEnityRepo;

import java.util.List;
import java.util.Optional;

/**
 * Created by Dev team
 */

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserEnityRepo userEnityRepo;

    public UserController(UserEnityRepo userEnityRepo) {
        this.userEnityRepo = userEnityRepo;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> allUsers(){
        List<UserEntity> all = userEnityRepo.findAll();
        return new ResponseEntity<>(all, HttpStatus.FOUND);
    }

    @GetMapping
    public String users(Model model){
        RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
//        String stringData = template.getForObject("https://jsonplaceholder.org/users", String.class);
        ResponseEntity<UserEntity[]> responseEntity = template.getForEntity("https://jsonplaceholder.org/users", UserEntity[].class);
        UserEntity[] userArray = responseEntity.getBody();
//        System.out.println(Arrays.toString(userArray));
//        System.out.println(userData);
        for (UserEntity user :
                Optional.ofNullable(userArray).orElse(new UserEntity[]{}) ) {
            System.out.println(user);
//            userEnityRepo.save(user);

        }
        model.addAttribute("users", userArray);
        return "users";
    }
}
