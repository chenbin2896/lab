package com.ty.lab.pojo;

import java.util.Date;

public class TbLabrecord {
    private Long id;

    private Integer lid;

    private String timestate;

    private Integer accountid;

    private Date date;

    private Integer state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getTimestate() {
        return timestate;
    }

    public void setTimestate(String timestate) {
        this.timestate = timestate == null ? null : timestate.trim();
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbLabrecord other = (TbLabrecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getLid() == null ? other.getLid() == null : this.getLid().equals(other.getLid()))
                && (this.getTimestate() == null ? other.getTimestate() == null : this.getTimestate().equals(other.getTimestate()))
                && (this.getAccountid() == null ? other.getAccountid() == null : this.getAccountid().equals(other.getAccountid()))
                && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
                && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLid() == null) ? 0 : getLid().hashCode());
        result = prime * result + ((getTimestate() == null) ? 0 : getTimestate().hashCode());
        result = prime * result + ((getAccountid() == null) ? 0 : getAccountid().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }
}