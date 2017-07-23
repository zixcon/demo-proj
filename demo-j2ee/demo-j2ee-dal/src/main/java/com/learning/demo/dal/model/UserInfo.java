package com.learning.demo.dal.model;

import java.io.Serializable;
import java.util.Date;

/**
 * user_info
 * 
 * 创建于：2017-07-23 09:52:03
*/
public class UserInfo implements Serializable {
    /**
     * 最大长度：10
     * 字段说明：
     * 默认值 ：null
     * 允许null：false
     */
    private Long id;

    /**
     * 最大长度：45
     * 字段说明：å§“å��
     * 默认值 ：null
     * 允许null：false
     */
    private String name;

    /**
     * 最大长度：10
     * 字段说明：å¹´é¾„
     * 默认值 ：null
     * 允许null：true
     */
    private Integer age;

    /**
     * 最大长度：10
     * 字段说明：å‡ºç”Ÿæ—¥æœŸ
     * 默认值 ：null
     * 允许null：false
     */
    private Date birthdate;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append(", birthdate=").append(birthdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}