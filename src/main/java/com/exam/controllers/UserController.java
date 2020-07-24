package com.exam.controllers;

import com.exam.exceptions.ResourceNotFoundException;
import com.exam.models.Role;
import com.exam.models.User;
import com.exam.repositories.RoleRepository;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/register")
    public String registration(@ModelAttribute("userForm") User user,Model model) {
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("userForm", new User());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registration(@Valid @ModelAttribute("userForm") User user, BindingResult bindingResult) throws ResourceNotFoundException {
        if (bindingResult.hasErrors()) {
            return "auth/register";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("userForm") User user , Model model, HttpServletRequest request) {
        model.addAttribute("user", user);
        Map<String ,String> messages =(Map<String, String>)  request.getSession().getAttribute("users");
        if (messages != null) {
            return "redirect:/home/home";
        }
        return "auth/login";
    }

    @PostMapping("/sendlogin")
    public String sendlogin(@ModelAttribute("userForm") User user, BindingResult result, ModelMap model, HttpServletRequest request) throws ResourceNotFoundException {
        model.addAttribute("user", user);
        System.out.println(user);
        if(result.hasErrors()){
            return "auth/login";
        }
        User u = userService.findByEmailAndPassword(user.getEmail(),user.getPassword());
        Map<String, Role> sessionData = new HashMap<>();
        sessionData.put(u.getEmail(),u.getRole());
        request.getSession().invalidate();
        request.getSession().setAttribute("users", sessionData);
        return "redirect:/Employee";
    }

    @GetMapping({"/index"})
    public String welcome(Model model , HttpSession session) {
        Map<String,Role> messages = (HashMap<String, Role>) session.getAttribute("users");
        if (messages == null) {
            return "redirect:/auth/login";
        }
        Map<String,String> sessionData =  new HashMap<>();
        messages.forEach((key, value) -> sessionData.put(key,((Role)value).getName()));
        model.addAttribute("session" , sessionData);
        return "auth/index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/auth/index";
    }
}
