package icu.cellcode.whitejotter.service;

import icu.cellcode.whitejotter.dao.UserDAO;
import icu.cellcode.whitejotter.entity.ResultSet;
import icu.cellcode.whitejotter.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginService {
    @Autowired
    private UserDAO userDAO;

    public ResultSet login(User user) {
        ResultSet rs = new ResultSet();

        if (user.getUsername() == null
                || user.getPassword() == null
                || user.getUsername().length() == 0
                || user.getPassword().length() == 0) {
            rs.setCode(400);
            rs.setMessage("用户名或密码不能为空。");
            return rs;
        }

        if (userDAO.findByUsername(user.getUsername()).getPassword().equals(user.getPassword())) {
            rs.setCode(200);
        } else {
            rs.setCode(400);
            rs.setMessage("用户名或密码错误。");
        }
        return rs;
    }

}
