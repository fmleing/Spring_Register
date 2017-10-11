package main.java.collector;

import main.java.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Tomecs on 2017/10/10.
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping("/account.do")
@SessionAttributes("msg")
public class AccountCollector {

    /**
     * @Resource的作用相当于@Autowired，只不过@Autowired按byType自动注入，
     * 而@Resource默认按 byName自动注入罢了。@Resource有两个属性是比较重要的，
     * 分别是name和type，Spring将@Resource注解的name属性解析为bean的名字，
     * 而type属性则解析为bean的类型。所以如果使用name属性，则使用byName的自动注入策略，
     * 而使用type属性时则使用byType自动注入策略。
     * 如果既不指定name也不指定type属性，这时将通过反射机制使用byName自动注入策略。
     */
    @Autowired
    private AccountService accountService;

    /**
     * 如果没有用这个注解标识方法，Spring容器将不知道那个方法可以用于处理get请求.
     * ServletRequestUtils类的工作已经由Spring底层实现了，
     * 我们只需要把参数名定义一致即可，其内部取参无需关心!
     * @param username
     * @param password
     * @return modelMap
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET)
//    public void hello(HttpServletRequest request, HttpServletResponse response)
    public Map hello(String username, String password, ModelMap modelMap){
//            throws Exception {

//        String username = ServletRequestUtils.getRequiredStringParameter(
//                request, "username");
//        String password = ServletRequestUtils.getRequiredStringParameter(
//                request, "password");
//        System.out.println(accountService.verify(username, password));
        modelMap.put("msg", username);
        return modelMap;
    }

    /**
     * 使用注解@RequestParam进行强制绑定
     * @param u
     * @param p
     */
    @RequestMapping("/hello.do")
    public void world(@RequestParam("username") String u,@RequestParam("password") String p) {
        System.out.println(u+":"+p);
    }

}
