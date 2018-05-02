package personal.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personal.entity.TGroup;
import personal.service.GroupService;

import java.util.Map;

@RestController
@RequestMapping("/group")
@Api(value = "group", description = "群组")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取群组")
    public TGroup getGroup(@PathVariable Long id) {
        return groupService.getInId(id);
    }

    @RequestMapping(value = "/{pageNo}/{pageSize}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "分页查询")
    public PageInfo<TGroup> listGroup(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        return groupService.list(pageNo, pageSize);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增群组")
    public Map<String, Object> createRole(TGroup group) {
        return groupService.insert(group);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除群组")
    public Map<String, Object> deleteRole(Long id) {
        return groupService.deleteInId(id);
    }

    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "批量删除群组")
    public Map<String, Object> deleteUserBatch(String ids) {
        return groupService.deleteBatchInId(ids);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新群组")
    public Map<String, Object> updateUser(TGroup group) {
        return groupService.update(group);
    }
}
