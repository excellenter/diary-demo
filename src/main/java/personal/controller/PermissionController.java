package personal.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personal.entity.TPermission;
import personal.service.PermissionService;

import java.util.Map;

@RestController
@RequestMapping("/permission")
@Api(value = "permission", description = "权限操作")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取")
    public TPermission get(@PathVariable Long id) {
        return permissionService.getInId(id);
    }

    @RequestMapping(value = "/{pageNo}/{pageSize}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "分页查询")
    public PageInfo<TPermission> list(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        return permissionService.list(pageNo, pageSize);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增")
    public Map<String, Object> create(TPermission permission) {
        return permissionService.insert(permission);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除")
    public Map<String, Object> delete(Long id) {
        return permissionService.deleteInId(id);
    }

    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "批量删除")
    public Map<String, Object> deleteBatch(String ids) {
        return permissionService.deleteBatchInId(ids);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新")
    public Map<String, Object> update(TPermission permission) {
        return permissionService.update(permission);
    }
}
