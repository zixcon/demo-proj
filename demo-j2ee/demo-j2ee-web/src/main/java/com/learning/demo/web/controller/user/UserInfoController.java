package com.learning.demo.web.controller.user;

import com.learning.demo.biz.service.user.UserInfoService;
import com.learning.demo.dal.model.UserInfo;
import com.learning.demo.web.global.entity.BaseResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by topaz on 2017/6/26.
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

//    @ApiOperation(value = "根据Id查询用户", notes = "第一个测试API")
//    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Integer")
    @RequestMapping("/getUserInfoById")
    public BaseResult<UserInfo> getUserInfoById(Integer id) {
        BaseResult<UserInfo> result = new BaseResult<>();
        UserInfo userInfo = userInfoService.getUserInfoById(id);
        result.setData(userInfo);
        return result;
    }

    @RequestMapping("/getUserInfoList")
    public BaseResult<List<UserInfo>> getUserInfoList(String name) {
        BaseResult<List<UserInfo>> result = new BaseResult<>();
        List<UserInfo> userInfoList = userInfoService.getUserInfoList(name);
        result.setData(userInfoList);
        return result;
    }

    @RequestMapping("/saveUserInfo")
    public BaseResult<Object> saveUserInfo(@RequestBody UserInfo userInfo) {
        BaseResult<Object> result = new BaseResult<>();
        userInfoService.saveUserInfo(userInfo);
        return result;
    }
}
