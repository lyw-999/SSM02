package com.xiexin.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AdminInfo {
    private String adminName;
    //因为前端传过来的是 字符串  所以这里要 做一个类型转换
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date adminTime;
    private String adminPwd;
    private List<Lover> loverlist;
    private Integer[] hobby;  // 1.写代码 2.看书 3.读报纸

    @Override
    public String toString() {
        return "AdminInfo{" +
                "adminName='" + adminName + '\'' +
                ", adminTime=" + adminTime +
                ", adminPwd='" + adminPwd + '\'' +
                ", loverlist=" + loverlist +
                ", hobby=" + Arrays.toString(hobby) +
                '}';
    }

    public Integer[] getHobby() {
        return hobby;
    }

    public void setHobby(Integer[] hobby) {
        this.hobby = hobby;
    }

    public List<Lover> getLoverlist() {
        return loverlist;
    }

    public void setLoverlist(List<Lover> loverlist) {
        this.loverlist = loverlist;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Date getAdminTime() {
        return adminTime;
    }

    public void setAdminTime(Date adminTime) {
        this.adminTime = adminTime;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }
}
