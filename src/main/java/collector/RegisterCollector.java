package main.java.collector;

import main.java.domain.Account;
import main.java.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * 用户注册控制器
 * Created by Tomecs on 2017/10/10.
 */
@Controller
@RequestMapping(value = "/register.do")
public class RegisterCollector {

    @Autowired
    private AccountService accountService;

    /**
     * @InitBinder用于表单自定义属性绑定。这里我们要求输入一个日期格式的生日。
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,"birthday",new CustomDateEditor(format, true));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(ModelMap modelMap) {
        Account account = new Account();
        modelMap.addAttribute("account", account);
        return "account/register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(@ModelAttribute("account") Account account) {
        int id = accountService.register(account).getId();
        return "redirect:profile.do?id=" + id;
    }
}
