package personal.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personal.entity.TMenu;
import personal.service.MenuService;

import java.util.Map;

@RestController
@RequestMapping("/menu")
@Api(value = "menu", description = "菜单权限")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取")
    public TMenu get(@PathVariable Long id) {
        return menuService.getInId(id);
    }

    @RequestMapping(value = "/{pageNo}/{pageSize}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "分页查询")
    public PageInfo<TMenu> list(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        return menuService.list(pageNo, pageSize);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增")
    public Map<String, Object> create(TMenu menu) {
        return menuService.insert(menu);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除")
    public Map<String, Object> delete(Long id) {
        return menuService.deleteInId(id);
    }

    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "批量删除")
    public Map<String, Object> deleteBatch(String ids) {
        return menuService.deleteBatchInId(ids);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新")
    public Map<String, Object> update(TMenu menu) {
        return menuService.update(menu);
    }
}
