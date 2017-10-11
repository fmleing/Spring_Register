package main.json.collector;

import main.json.dao.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Tomecs on 2017/10/11.
 */
@Controller
@RequestMapping(value = "json")
public class PersonCollector {

    /**
     * 查询个人信息
     *@RequestMapping(value = "/person/profile/{id}/{name}/{status}", method = RequestMethod.GET)中
     * 的{id}/{name}/{status}
     * 与@PathVariable int id, @PathVariable String name,@PathVariable boolean status一一对应，按名匹配
     * GET模式下，这里使用了@PathVariable绑定输入参数，非常适合Restful风格。
     * 因为隐藏了参数与路径的关系，可以提升网站的安全性，静态化页面，降低恶意攻击风险。
     * @param id
     * @param name
     * @param status
     * @return
     */
    @RequestMapping(value = "/person/profile/{id}/{name}/{status}",method = RequestMethod.GET)
    @ResponseBody
    public Person profile(@PathVariable int id, @PathVariable String name, @PathVariable boolean status) {
        return new Person(id,name,status);
    }

    /**
     * 登陆
     * POST模式下，使用@RequestBody绑定请求对象，
     * Spring会帮你进行协议转换，
     * 将Json、Xml协议转换成你需要的对象。
     * @ResponseBody 可以标注任何对象，由Srping完成对象——协议的转换。
     * @param person
     * @return
     */
    @RequestMapping(value = "/person/login",method = RequestMethod.POST)
    @ResponseBody
    public Person login(@RequestBody Person person) {
        return person;
    }
}
