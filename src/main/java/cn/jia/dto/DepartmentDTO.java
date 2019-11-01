package cn.jia.dto;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name="department")
public class DepartmentDTO {

	@Id
    private String name;

    private Date createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    private Date updateTime;


}
