package personal.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personal.entity.TUser;
import personal.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "用户操作", description = "用户操作API")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("获取单个用户")
    public TUser getUser(@PathVariable String id) {
        return userService.getInId(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("获取所有用户")
    public List<TUser> listUser() {
        return userService.list();
    }
}
