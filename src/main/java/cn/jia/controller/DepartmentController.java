package cn.jia.controller;

import cn.jia.dto.DepartmentDTO;
import cn.jia.mapper.DepartmentMapper;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jia on 2017/12/30.
 * 管理员控制器
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentMapper departmentMapper;

    //展现简历
    @RequiresRoles("admin")
    @PostMapping("/add")
    public String add(DepartmentDTO dto){
        departmentMapper.insertSelective(dto);
        return "ok";
    }
    //展现题库
    @RequiresRoles("admin")
    @GetMapping("/delete")
    public String delete(String key){
        departmentMapper.deleteByPrimaryKey(key);
        return "ok";
    }
    @RequiresRoles("admin")
    @PostMapping("/position")
    public String update(DepartmentDTO dto){
        departmentMapper.updateByPrimaryKeySelective(dto);
        return "ok";
    }
}
