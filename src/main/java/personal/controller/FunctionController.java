package personal.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personal.entity.TFunction;
import personal.service.FunctionService;

import java.util.Map;

@RestController
@RequestMapping("/function")
@Api(value = "function", description = "功能权限")
public class FunctionController {

    @Autowired
    private FunctionService functionService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取")
    public TFunction get(@PathVariable Long id) {
        return functionService.getInId(id);
    }

    @RequestMapping(value = "/{pageNo}/{pageSize}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "分页查询")
    public PageInfo<TFunction> list(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        return functionService.list(pageNo, pageSize);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增")
    public Map<String, Object> create(TFunction function) {
        return functionService.insert(function);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除")
    public Map<String, Object> delete(Long id) {
        return functionService.deleteInId(id);
    }

    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "批量删除")
    public Map<String, Object> deleteBatch(String ids) {
        return functionService.deleteBatchInId(ids);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新")
    public Map<String, Object> update(TFunction function) {
        return functionService.update(function);
    }
}
