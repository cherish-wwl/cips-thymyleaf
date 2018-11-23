package cips.controller.MenuController;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class TestController {

//    @RequestMapping("")
//    public Object test (){
//        System.out.println("hhh");
//        return "index";
//    }
//    @RequestMapping("example")
//    public Object example (){
//        System.out.println("hhh");
//        return "ueditor-1.4.3.3/_examples/index";
//    }

    /**
     * 跳转到 首页
     * @param request
     * @param response
     * @param modelMap
     * @return
     */
    @RequestMapping(method = {RequestMethod.OPTIONS, RequestMethod.POST, RequestMethod.GET}, value = "")
    public Object main(HttpServletRequest request, HttpServletResponse response,
                       ModelMap modelMap) {
        modelMap.addAttribute("title", "首页");
        modelMap.addAttribute("data", getRoleJson("home.json"));
        return "index";
    }

    /**
     * 跳转到 学会概况/学会章程 页面
     * @param request
     * @param response
     * @param modelMap
     * @return
     */
    @RequestMapping(method = {RequestMethod.OPTIONS, RequestMethod.POST, RequestMethod.GET}, value = "about")
    public Object about(HttpServletRequest request, HttpServletResponse response,
                       ModelMap modelMap) {
        modelMap.addAttribute("title", "学会章程");
        modelMap.addAttribute("data", getRoleJson("home.json"));
        return "about";
    }


    // 读取json 并返回json对象
    public JSONObject getRoleJson(String fileName) {
        String path = getClass().getClassLoader().getResource(fileName).toString();
        path = path.replace("\\", "/");

        if (path.contains(":")) {
            // path = path.substring(6);// 1
            path = path.replace("file:", "");// 2
        }
        JSONObject jsonObject = null;
        String input;
        try {
            input = FileUtils.readFileToString (new File(path), "UTF-8");
            jsonObject = JSONObject.parseObject(input);
            return jsonObject;
        } catch (IOException e) {
            System.out.println("json解析失败:" + e);
        }
        return jsonObject;

    }
}

