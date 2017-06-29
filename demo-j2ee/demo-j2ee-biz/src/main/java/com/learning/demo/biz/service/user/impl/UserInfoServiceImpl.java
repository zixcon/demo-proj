package com.learning.demo.biz.service.user.impl;

import com.google.common.base.Strings;
import com.learning.demo.biz.service.user.UserInfoService;
import com.learning.demo.dal.dao.UserInfoMapper;
import com.learning.demo.dal.model.UserInfo;
import com.learning.demo.dal.model.UserInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by topaz on 2017/6/25.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> getUserInfoList(String name) {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        if (!Strings.isNullOrEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        return userInfoMapper.selectByExample(example);
    }

    @Override
    public UserInfo getUserInfoById(Integer id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKey(userInfo);
    }

}
