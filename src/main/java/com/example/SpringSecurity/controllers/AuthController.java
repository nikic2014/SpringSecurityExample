package com.example.SpringSecurity.controllers;

import com.example.SpringSecurity.models.Person;
import com.example.SpringSecurity.services.RegisterService;
import com.example.SpringSecurity.validators.PersonValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auth")
public class AuthController {

    private final PersonValidator personValidator;
    private final RegisterService registerService;

    @Autowired
    public AuthController(PersonValidator personValidator, RegisterService registerService) {
        this.personValidator = personValidator;
        this.registerService = registerService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }

    @GetMapping("/register")
    public String registerPage(@ModelAttribute("person") Person person){
        return "auth/register";
    }

    @PostMapping("/register")
    public String doRegister(@ModelAttribute("person") @Valid Person person,
                             BindingResult bindingResult){
        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors())
            return "/auth/register";

        registerService.register(person);
        return "redirect:/auth/login";
    }
}
