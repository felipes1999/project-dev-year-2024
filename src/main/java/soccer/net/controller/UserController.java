package soccer.net.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import soccer.net.entity.UserRequest;
import soccer.net.entity.UserRequestRepository;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRequestRepository userRequestRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserRequest create(@RequestBody UserRequest user) {
        return userRequestRepository.save(user);
    }
}