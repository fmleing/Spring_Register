package main.java.collector;

import main.java.domain.Account;
import main.java.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 登陆控制器
 *
 * Created by Tomecs on 2017/10/10.
 */
@Controller
@RequestMapping(value = "/login.do")
public class LoginCollector {

    @Autowired
    private AccountService accountService;

    /**
     * 初始化登陆表单
     *
     * @RequestMapping(method = RequestMethod.GET)指定了GET请求方式，这与POST表单提交相对应！
     * model.addAttribute("account", account);绑定账户对象，也就是这个登录表单对象
     * return "account/login";指向登录页面
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String initForm(ModelMap modelMap) {
        Account account = new Account();
        modelMap.addAttribute("account", account);
//        直接跳转到登陆界面
        return "account/login";
    }

    /**
     * 登陆
     * @RequestMapping(method = RequestMethod.POST)绑定POST表单提交请求
     * @ModelAttribute("account") Account account绑定表单对象。
     * @param account
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String login(@ModelAttribute("account") Account account) {
        Account acc = accountService.read(account.getUsername(), account.getPassword());
        if (acc != null) {
            return "redirect:profile.do?id=" + acc.getId();
        } else {
            return "redirect:login.do";
        }
    }
}
