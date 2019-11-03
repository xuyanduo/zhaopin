package cn.jia.controller;

import cn.jia.common.ServerResponse;
import cn.jia.domain.User;
import cn.jia.service.CollectionService;
import cn.jia.service.PositionService;
import cn.jia.service.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/apply")
public class ApplyController {

    @Autowired
    private PositionService positionService;
    @Autowired
    private UserService userService;

    @GetMapping
    public String collect(@RequestParam(value = "pageIndex",defaultValue = "1",required = false)int pageIndex,
                          @RequestParam(value = "pageNum",defaultValue = "5",required = false)int pageNum,
                          HttpSession session, Model model){
        String username = (String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return "login";
        }
        User user = userService.findByUsername(username);
        ServerResponse serverResponse = positionService.findAllApply(pageIndex,pageNum,user.getId());
        PageInfo pageInfo = (PageInfo)serverResponse.getData();
        model.addAttribute("apply",pageInfo);
        return "www/apply";
    }
}
