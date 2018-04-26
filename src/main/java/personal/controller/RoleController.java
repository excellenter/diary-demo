package personal.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personal.entity.TRole;
import personal.service.RoleService;

import java.util.Map;

@RestController
@RequestMapping("/role")
@Api(value = "role", description = "角色")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取角色")
    public TRole getRole(@PathVariable Long id) {
        return roleService.getInId(id);
    }

    @RequestMapping(value = "/{pageNo}/{pageSize}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "分页查询")
    public PageInfo<TRole> listRole(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        return roleService.list(pageNo, pageSize);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增角色")
    public Map<String, Object> createRole(TRole role) {
        return roleService.insert(role);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除角色")
    public Map<String, Object> deleteRole(Long id) {
        return roleService.deleteInId(id);
    }

    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "批量删除角色")
    public Map<String, Object> deleteUserBatch(String ids) {
        return roleService.deleteBatchInId(ids);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新角色")
    public Map<String, Object> updateUser(TRole role) {
        return roleService.update(role);
    }
}
