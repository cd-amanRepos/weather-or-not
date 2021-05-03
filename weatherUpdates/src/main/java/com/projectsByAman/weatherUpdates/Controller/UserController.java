package com.projectsByAman.weatherUpdates.Controller;

import com.projectsByAman.weatherUpdates.Entity.TaskBucket;
import com.projectsByAman.weatherUpdates.Entity.User;
import com.projectsByAman.weatherUpdates.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user, Model model, BindingResult errors) {
        User userCreated = userService.addUser(user);
        model.addAttribute("username", userCreated.getUsername());
        model.addAttribute("name", userCreated.getName());
        return "redirect:/dashboard/" + user.getBucket().getBucketId();
    }



    @RequestMapping(value = "/signup", method =RequestMethod.GET)
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @RequestMapping("/user/{username}")
    public String getUser(@PathVariable("username") String username, Model model) {
        User user = userService.getUser(username);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("Name", user.getName());
        return "user";
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("username") String username, Model model) {
        userService.deleteUser(username);
        model.addAttribute("deleteMessage", "User deleted Successfully");
        return "index";
    }


}
