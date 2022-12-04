package com.wetrol.testdemo.controller;

import com.wetrol.testdemo.domain.Person;
import com.wetrol.testdemo.domain.Pet;
import com.wetrol.testdemo.domain.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/api")
public class SpringBoot2ApiTest {

    /**
     * 开启内容协商
     * 可以根据客户端接受格式的不同返回不同数据类型
      */
    @GetMapping("/consult")
    public User test1(User user){
        Map<String,Object> map = new HashMap<>();
        user.setAge(15);
        user.setGender("男");
        user.setLikes(new String[]{"足球", "篮球"});
        user.setUsername("张居正");
        map.put("用户map",user);
        return user;
    }




    /**
     * 自定义传出对象形式
     * 默认可以级联 myCar.price
     */
    @PostMapping("/save")
    public String definitionObj(Pet Pet){
        return Pet.toString();
    }

    /**
     * 下面是测试 矩阵变量
     * 场景：如果浏览器禁用cookie ，用下面的@GetMapping("/user/{id}/name/{age}")这种就与正常业务不容易区分
     * 所以一般通过矩阵变量进行携带jSessionId
     */
    @GetMapping("/matrix/{bossId}/{empId}/{map}")
    public Map testmatrixVariable(@PathVariable(value = "bossId") String pathVarBoss,
                                  @PathVariable(value = "empId") String pathVarEmp,
                                  @MatrixVariable(value = "age", pathVar = "bossId") Integer boosAge,
                                  @MatrixVariable(value = "name", pathVar = "bossId",required = false) String bossName,
                                  @MatrixVariable(value = "age", pathVar = "empId") Integer empAge,
                                  @MatrixVariable(value = "like",pathVar = "empId") List<String> likes,
                                  @MatrixVariable(value = "work",pathVar = "map") Map<String,String> m) {
        Map<String, Object> map = new HashMap<>();
        map.put("pathVarBoss", pathVarBoss);
        map.put("pathVarEmp", pathVarEmp);
        map.put("boosAge", boosAge);
        map.put("bossName", bossName);
        map.put("empAge", empAge);
        map.put("empLikes",likes);
        map.put("map",m);

        return map;
    }


    /**
     * 如果用Map封装的话可以默认把对应的信息都放进去
     *
     * @param id
     * @param age
     * @param userAgent
     * @return
     */
    @ResponseBody
    @GetMapping("/user/{id}/name/{age}")
    public Map<String, Object> pathVariable(HttpServletResponse response,
                                            @PathVariable(name = "id") Long id,
                                            @PathVariable(name = "age", required = false) Integer age,
                                            @PathVariable(required = false) Map<String, String> pathMap,
                                            @RequestHeader(required = false) Map<String, String> userAgent,
                                            @RequestParam(value = "inters", required = false) List<String> inters,
                                            @RequestParam(required = false) Map<String, String> params,
                                            @CookieValue(value = "wetrol", required = false) Cookie cook1,
                                            @CookieValue(value = "wetrol", required = false) String wetrol
    ) {
//        String s = UUID.randomUUID().toString();
//        Cookie cookie = new Cookie("wetrol",s);
//
//        response.addCookie(cookie);

        Map<String, Object> map = new HashMap<>();
        map.put("用户id：", id);
        map.put("用户age：", age);
        map.put("pathMap", pathMap);
        map.put("userAgentMap ", userAgent);
        map.put("intersList", inters);
        map.put("paramsMap", params);
        map.put("cook1", cook1);
        map.put("wetrol", wetrol);
        return map;
    }

    //获取信息
    @GetMapping("/user")
    public Map testGetRequest() {
        Map<String, String> map = new HashMap<>();
        map.put("testGetRequest", "请求成功GetMapping~");
        return map;
    }

    //表单的提交
    @PostMapping("/user")
    public Map testPostRequest() {
        Map<String, String> map = new HashMap<>();
        map.put("testPostRequest", "请求成功PostMapping~");
        return map;
    }


    //PUT 请求为Rest中的修改
    @PutMapping("/user")
    public Map testPutRequest() {
        Map<String, String> map = new HashMap<>();
        map.put("testPutRequest", "请求成功PutMapping~");
        return map;
    }

    //Rest 中的DELETE
    @DeleteMapping("/user")
    public Map testDeleteRequest() {
        Map<String, String> map = new HashMap<>();
        map.put("testDeleteRequest", "请求成功DeleteMapping~");
        return map;
    }
}
