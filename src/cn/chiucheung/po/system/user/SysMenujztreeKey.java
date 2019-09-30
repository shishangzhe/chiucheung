package cn.chiucheung.po.system.user;

import java.io.Serializable;

public class SysMenujztreeKey implements Serializable{
    private String mid;

    private String pid;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }
}