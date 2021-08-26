package com.example.springproject1.web.controller;

import com.example.springproject1.core.entity.User;
import com.example.springproject1.core.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@Log4j2
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String inicio(Model model){
        log.info("Ejecutando");
        List<User> users = StreamSupport.stream(userService.findAll().spliterator(),false).collect(Collectors.toList());
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/add")
    public String add(User user){
        return "modify";
    }
    //Spring va a buscar automaticamente un objeto de tipo User en la fabrica de Spring
    //Si no lo encuentra, va a crear un nuevo objeto y lo va a inyectar de manera automactica en este metodo

    @PostMapping("/save")
    public String save(@Valid User user, Errors errors){
        if(errors.hasErrors()){
            return "modify";
        }
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "modify";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        userService.deleteById(id);
        return "redirect:/";
    }

}
