package personal.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personal.entity.TUserGroup;
import personal.service.UserGroupService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userGroup")
@Api(value = "user_group", description = "用户——群组关联")
public class UserGroupController {

    @Autowired
    private UserGroupService userGroupService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("新增关联")
    public Map<String, Object> insert(TUserGroup userGroup) {
        return userGroupService.insert(userGroup);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("获取对应用户id角色")
    public List<Map<String, Object>> getRoleByUser(@PathVariable String userId) {
        return userGroupService.getGroupByUser(userId);
    }

    @RequestMapping(value = "/deleteInUser", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("删除对应id用户所有角色")
    public Map<String, Object> deleteByUser(String userId) {
        return userGroupService.deleteByUser(userId);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("删除指定用户角色")
    public Map<String, Object> deleteByUserAndRole(TUserGroup userGroup) {
        return userGroupService.deleteByUserAndGroup(userGroup);
    }
}
