package icu.cellcode.whitejotter.controller;


import icu.cellcode.whitejotter.entity.ResultSet;
import icu.cellcode.whitejotter.entity.User;
import icu.cellcode.whitejotter.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    LoginService loginService;
    @CrossOrigin
    @PostMapping("/login")
    @ResponseBody
    public ResultSet login(@RequestBody User user) {
        return loginService.login(user);
    }
}
