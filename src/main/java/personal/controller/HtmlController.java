package personal.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personal.entity.THtml;
import personal.service.HtmlService;

import java.util.Map;

@RestController
@RequestMapping("/html")
@Api(value = "html", description = "网页元素权限")
public class HtmlController {

    @Autowired
    private HtmlService htmlService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取")
    public THtml get(@PathVariable Long id) {
        return htmlService.getInId(id);
    }

    @RequestMapping(value = "/{pageNo}/{pageSize}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "分页查询")
    public PageInfo<THtml> list(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        return htmlService.list(pageNo, pageSize);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增")
    public Map<String, Object> create(THtml html) {
        return htmlService.insert(html);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除")
    public Map<String, Object> delete(Long id) {
        return htmlService.deleteInId(id);
    }

    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "批量删除")
    public Map<String, Object> deleteBatch(String ids) {
        return htmlService.deleteBatchInId(ids);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新")
    public Map<String, Object> update(THtml html) {
        return htmlService.update(html);
    }
}
