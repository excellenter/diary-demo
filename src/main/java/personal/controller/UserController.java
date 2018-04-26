package personal.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personal.entity.TUser;
import personal.service.UserService;

import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(value = "用户操作", description = "用户操作API")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("获取单个用户")
    public TUser getUser(@PathVariable String id) {
        return userService.getInId(id);
    }

    @RequestMapping(value = "/{pageNo}/{pageSize}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("分页查询")
    public PageInfo<TUser> listUser(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        return userService.list(pageNo, pageSize);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("新增用户")
    public Map<String, Object> createUser(TUser user) {
        return userService.insert(user);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("删除用户")
    public Map<String, Object> deleteUser(String id) {
        return userService.deleteInId(id);
    }

    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("批量删除用户")
    public Map<String, Object> deleteUserBatch(String ids) {
        return userService.deleteBatchInId(ids);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("更新用户")
    public Map<String, Object> updateUser(TUser user) {
        return userService.update(user);
    }
}
