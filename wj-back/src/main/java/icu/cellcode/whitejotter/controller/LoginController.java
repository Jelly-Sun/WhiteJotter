package icu.cellcode.whitejotter.controller;


import icu.cellcode.whitejotter.entity.ResultSet;
import icu.cellcode.whitejotter.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public ResultSet login(@RequestBody User user) {
        ResultSet rs = new ResultSet();
        if (user.getUsername() != null
                && user.getUsername().equals("admin")
                && user.getPassword() != null
                && user.getPassword().equals("123456")
        ) {
            rs.setCode(200);
        } else {
            rs.setCode(400);
            rs.setMessage("用户名或密码错误。");
        }
        return rs;
    }
}
