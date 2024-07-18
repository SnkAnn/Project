package com.example.library_spring.controller;

import com.example.library_spring.model.Author;

import com.example.library_spring.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService userService;

    @GetMapping("/user/{userId}")
    public Author getUser(@PathVariable Long userId){
       return userService.getAuthor(userId);
    }

    @PostMapping("/updateUserDescription/{userId}/{newDescription}")
    public void updateUserDescription(@PathVariable Long userId, @PathVariable String newDescription){
        userService.updateAuthorDescription(userId,newDescription);
    }


}
