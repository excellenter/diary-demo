package personal.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personal.entity.TResource;
import personal.service.ResourceService;

import java.util.Map;

@RestController
@RequestMapping("/resource")
@Api(value = "resource", description = "资源文件权限")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取")
    public TResource get(@PathVariable Long id) {
        return resourceService.getInId(id);
    }

    @RequestMapping(value = "/{pageNo}/{pageSize}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "分页查询")
    public PageInfo<TResource> list(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        return resourceService.list(pageNo, pageSize);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增")
    public Map<String, Object> create(TResource resource) {
        return resourceService.insert(resource);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除")
    public Map<String, Object> delete(Long id) {
        return resourceService.deleteInId(id);
    }

    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "批量删除")
    public Map<String, Object> deleteBatch(String ids) {
        return resourceService.deleteBatchInId(ids);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新")
    public Map<String, Object> update(TResource resource) {
        return resourceService.update(resource);
    }
}
