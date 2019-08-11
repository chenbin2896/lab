package com.ty.lab.pojo;

public class TbLabstate {
    private Long id;

    private Integer lid;

    private String timestate;

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
        TbLabstate other = (TbLabstate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getLid() == null ? other.getLid() == null : this.getLid().equals(other.getLid()))
                && (this.getTimestate() == null ? other.getTimestate() == null : this.getTimestate().equals(other.getTimestate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLid() == null) ? 0 : getLid().hashCode());
        result = prime * result + ((getTimestate() == null) ? 0 : getTimestate().hashCode());
        return result;
    }
}