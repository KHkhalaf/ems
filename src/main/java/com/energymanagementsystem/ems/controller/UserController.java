package com.energymanagementsystem.ems.controller;

import com.energymanagementsystem.ems.exceptions.ResourceNotFoundException;
import com.energymanagementsystem.ems.helper.UserService;
import com.energymanagementsystem.ems.repository.StatisticsRepository;
import com.energymanagementsystem.ems.model.User;
import com.energymanagementsystem.ems.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private StatisticsRepository statisticsRepository;

    @RequestMapping("/dashboard")
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView("UserViews/dashboard");
        //modelAndView.addObject();
        return modelAndView;
    }

    @RequestMapping("/details/{id}")
    public ModelAndView profileUser(@PathVariable(name = "id") int id) throws ResourceNotFoundException {
        ModelAndView modelAndView = new ModelAndView("UserViews/profile");
        modelAndView.addObject(userService.get(id));
        return modelAndView;
    }

    @RequestMapping("/list")
    public String showListOfUsers(Model model) {
        List<User> users = userService.listAll();
        model.addAttribute("users", users);

        return "UserViews/List";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditUserPage(@PathVariable(name = "id") int id) throws ResourceNotFoundException {
        ModelAndView mav = new ModelAndView("UserViews/edit");
        User user = userService.get(id);
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) throws ResourceNotFoundException {
        User _user = userService.get(user.getId());
        _user.setUsername(_user.getUsername());

        userService.save(_user);

        return "redirect:/user/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") int id) {
        userService.delete(id);
        return "redirect:/user/list";
    }
    @RequestMapping(value = "/loginPage")
    public ModelAndView showLoginPage(LoginRequest loginRequest) {
        ModelAndView mav = new ModelAndView("UserViews/login");
        mav.addObject("loginRequest",loginRequest);
        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() {
        return "redirect:/shared/login";
    }


}
