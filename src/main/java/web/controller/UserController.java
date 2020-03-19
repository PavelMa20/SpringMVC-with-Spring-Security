package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/admin/list")
    public ModelAndView home() {
        List<User> listUser = userService.listUsers();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listUser", listUser);
        return mav;
    }

    @RequestMapping("/admin/new")
    public String newUserForm(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "new_user";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        user.setRoles(Collections.singleton(new Role("USER")));
        userService.addUser(user);
        return "redirect:/admin/list";
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/admin/list";
    }

    @RequestMapping("/admin/edit")
    public ModelAndView editUserForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_user");
        User user = userService.getUserById(id);
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping("/admin/delete")
    public String deleteUserForm(@RequestParam long id) {
        userService.removeUser(id);
        return "redirect:/admin/list";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView helloUser(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("hello");
        User user = userService.getUserById(id);
        mav.addObject("user", user);
        return mav;
    }


      @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

}
