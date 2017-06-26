package com.learning.demo.biz.user;

import com.learning.demo.dal.model.UserInfo;

import java.util.List;

/**
 * Created by topaz on 2017/6/25.
 */
public interface UserInfoService {

    /**
     * 获取用户
     * @param name
     * @return
     */
    public List<UserInfo> getUserInfoList(String name);

    /**
     * 获取用户
     * @param id
     * @return
     */
    public UserInfo getUserInfoById(Integer id);

    public void saveUserInfo(UserInfo userInfo);
    public void updateUserInfo(UserInfo userInfo);
}
