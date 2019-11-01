package cn.jia.controller;

import cn.jia.common.BusiRespCode;
import cn.jia.dto.DepartmentDTO;
import cn.jia.mapper.DepartmentMapper;

import java.util.Date;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jia on 2017/12/30. 管理员控制器
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentMapper departmentMapper;

	// 展现简历
	@RequiresRoles("admin")
	@PostMapping("/add")
	public String add(DepartmentDTO dto) {
		try {
			dto.setCreateTime(new Date());
			departmentMapper.insertSelective(dto);
		} catch (Exception e) {
			return BusiRespCode.Department.ADD_FAIL.getMsg();
		}

		return BusiRespCode.Department.ADD_SUCCESS.getMsg();
	}

	// 展现题库
	@RequiresRoles("admin")
	@GetMapping("/delete")
	public String delete(String key) {
		try {
			departmentMapper.deleteByPrimaryKey(key);
		} catch (Exception e) {
			return BusiRespCode.Department.DELETE_FAIL.getMsg();
		}

		return BusiRespCode.Department.DELETE_SUCCESS.getMsg();
	}

	@RequiresRoles("admin")
	@PostMapping("/position")
	public String update(DepartmentDTO dto) {
		try {
			departmentMapper.updateByPrimaryKeySelective(dto);
		} catch (Exception e) {
			return BusiRespCode.Department.UPDATE_FAIL.getMsg();
		}
		return BusiRespCode.Department.UPDATE_SUCCESS.getMsg();
	}
}
