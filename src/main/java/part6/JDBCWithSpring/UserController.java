package part6.JDBCWithSpring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserDAOJDBCImpl userJDBC;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        List<User> users = userJDBC.listUsers();
        model.addAttribute("users", users);
        return "list-user";
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "user-form";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        String name = user.getName();
        String email = user.getEmail();
        userJDBC.create(name, email);

        return "redirect:/list";
    }

    @RequestMapping(value = "/findUser", method = RequestMethod.GET)
    public String findUser(Model model){
        model.addAttribute("id", new Object());
        return "find-form";
    }

    @RequestMapping(value = "/viewUser", method = RequestMethod.GET)
    public String viewUser(@ModelAttribute("id")@RequestParam("id") int id, Model model){
        User user = userJDBC.getUser(id);
        model.addAttribute("users", user);
        return "list-user";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(@RequestParam ("id") int id, Model model){

        userJDBC.delete(id);

        return "redirct:/list";
    }




}
