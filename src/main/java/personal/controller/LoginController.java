package personal.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import personal.service.UserService;

import java.util.Map;

@RestController
@RequestMapping("/login")
@Api(value = "登陆接口", description = "手机登录,菜单登陆")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/tel", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("手机登录")
    public Map<String, Object> loginByTel(String tel, String password) {
        return userService.loginByTel(tel, password);
    }

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("邮箱登录")
    public Map<String, Object> loginByEmail(String email, String password) {
        return userService.loginByEmail(email, password);
    }
}
