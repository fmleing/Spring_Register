package main.java.collector;

import main.java.domain.Account;
import main.java.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 账户信息控制器
 *
 * @RequestMapping(value = "/profile.do")为该控制器绑定url（/profile.do）
 * @RequestMapping(method = RequestMethod.GET)指定为GET请求
 * model.addAttribute("account", account);绑定账户
 * return "account/profile";跳转到“/WEB-INF/page/account/porfile.jsp”页面
 *
 * 注解的确减少了代码的开发量，当然，这对于我们理解程序是一种挑战！
 *
 * Created by Tomecs on 2017/10/10.
 */
@Controller
@RequestMapping(value = "/profile.do")
public class ProfileCollector {
    @Autowired
    private AccountService accountService;

    /**
     * 账户信息展示
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String profile(@RequestParam("id") int id, ModelMap modelMap) {
        Account account = accountService.read(id);
        modelMap.put("account", account);
        //跳转到用户信息页面
        return "account/profile";
    }
}
