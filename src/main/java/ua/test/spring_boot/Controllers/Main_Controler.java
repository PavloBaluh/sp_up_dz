package ua.test.spring_boot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.test.spring_boot.Dao.UserDao;

import ua.test.spring_boot.Models.Email;
import ua.test.spring_boot.Models.User;

import java.util.ArrayList;

@Controller
public class Main_Controler {

    @Autowired
private UserDao userDao;
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("users",userDao.findAll());
        return "index";
    }


    @PostMapping("/save")
    public String save (
            @RequestParam() String data,@RequestParam() String email, Model model
    ){
        User user = new User();
        user.setName(data);


        ArrayList<Email> emails = new ArrayList<>();
        Email email1 = new Email();
        email1.setEmail(email);
        email1.setUser(user);
        emails.add(email1);

        user.setEmails(emails);
        userDao.save(user);
        model.addAttribute("allusers",userDao.findAll());
        return "result";
    }

    @GetMapping("/user-{varid}")
    public String sola(@PathVariable("varid") int id, Model model){
        model.addAttribute("xxx",userDao.findById(id).get());
        return "single_user";
    }
}
