package soccer.net.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import soccer.net.entity.UserRequest;
import soccer.net.entity.UserRequestRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRequestRepository userRequestRepository;


    // Create a new user
    @PostMapping
    public ResponseEntity<UserRequest> createUser(@RequestBody UserRequest userRequest) {
        UserRequest savedUser = userRequestRepository.save(userRequest);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Retrieve all users
    @GetMapping
    public ResponseEntity<List<UserRequest>> getAllUsers() {
        List<UserRequest> users = userRequestRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Retrieve a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserRequest> getUserById(@PathVariable Long id) {
        Optional<UserRequest> user = userRequestRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<UserRequest> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        Optional<UserRequest> existingUser = userRequestRepository.findById(id);
        if (existingUser.isPresent()) {
            UserRequest updatedUser = existingUser.get();
            updatedUser.setNome(userRequest.getNome());
            updatedUser.setEmail(userRequest.getEmail());
            return new ResponseEntity<>(userRequestRepository.save(updatedUser), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userRequestRepository.existsById(id)) {
            userRequestRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}