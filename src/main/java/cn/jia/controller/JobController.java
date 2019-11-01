package cn.jia.controller;

import cn.jia.dto.JobDTO;
import cn.jia.mapper.JobMapper;
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
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobMapper jobMapper;

    //展现简历
    @RequiresRoles("admin")
    @PostMapping("/add")
    public String add(JobDTO dto){
        jobMapper.insertSelective(dto);
        return "ok";
    }
    //展现题库
    @RequiresRoles("admin")
    @GetMapping("/delete")
    public String delete(String key){
        jobMapper.deleteByPrimaryKey(key);
        return "ok";
    }
    @RequiresRoles("admin")
    @PostMapping("/position")
    public String update(JobDTO dto){
        jobMapper.updateByPrimaryKeySelective(dto);
        return "ok";
    }
}
