package com.learning.demo.biz.service.user.impl;

import com.google.common.base.Strings;
import com.learning.demo.biz.service.user.UserInfoService;
import com.learning.demo.dal.mapper.UserInfoMapper;
import com.learning.demo.dal.model.UserInfo;
import com.learning.demo.dal.model.UserInfoExample;
import org.apache.commons.lang3.tuple.Pair;
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

    public Pair<Long,List<UserInfo>> getPageList(String name,Integer pageNo,Integer pageSize ) {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        if (!Strings.isNullOrEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        long count = userInfoMapper.countByExample(example);
        example.setLimitStart(pageNo);
        example.setLimitEnd(pageSize);
        example.setOrderByClause(" id desc ");
        List<UserInfo> list = userInfoMapper.selectByExample(example);
        return Pair.of(count,list);
    }

    @Override
    public UserInfo getUserInfoById(Long id) {
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
