package cn.jia.controller;

import java.util.Date;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jia.common.BusiRespCode;
import cn.jia.dto.JobDTO;
import cn.jia.mapper.JobMapper;

/**
 * Created by jia on 2017/12/30.
 * 管理员控制器
 */
@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobMapper jobMapper;

 // 展现简历
 	@RequiresRoles("admin")
 	@PostMapping("/add")
 	public String add(JobDTO dto) {
 		try {
 			dto.setCreateTime(new Date());
 			jobMapper.insertSelective(dto);
 		} catch (Exception e) {
 			return BusiRespCode.Job.ADD_FAIL.getMsg();
 		}

 		return BusiRespCode.Job.ADD_SUCCESS.getMsg();
 	}

 	// 展现题库
 	@RequiresRoles("admin")
 	@GetMapping("/delete")
 	public String delete(String key) {
 		try {
 			jobMapper.deleteByPrimaryKey(key);
 		} catch (Exception e) {
 			return BusiRespCode.Job.DELETE_FAIL.getMsg();
 		}

 		return BusiRespCode.Job.DELETE_SUCCESS.getMsg();
 	}

 	@RequiresRoles("admin")
 	@PostMapping("/position")
 	public String update(JobDTO dto) {
 		try {
 			jobMapper.updateByPrimaryKeySelective(dto);
 		} catch (Exception e) {
 			return BusiRespCode.Job.UPDATE_FAIL.getMsg();
 		}
 		return BusiRespCode.Job.UPDATE_SUCCESS.getMsg();
 	}
}
