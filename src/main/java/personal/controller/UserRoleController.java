package personal.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personal.entity.TUserRole;
import personal.service.UserRoleService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userRole")
@Api(value = "user_role", description = "用户——角色关联")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("新增关联")
    public Map<String, Object> insert(TUserRole userRole) {
        return userRoleService.insert(userRole);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("获取对应用户id角色")
    public List<Map<String, Object>> getRoleByUser(@PathVariable String userId) {
        return userRoleService.getRoleByUser(userId);
    }

    @RequestMapping(value = "/deleteInUser", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("删除对应id用户所有角色")
    public Map<String, Object> deleteByUser(String userId) {
        return userRoleService.deleteByUser(userId);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("删除指定用户角色")
    public Map<String, Object> deleteByUserAndRole(TUserRole userRole) {
        return userRoleService.deleteNyUserAndRole(userRole);
    }


}
