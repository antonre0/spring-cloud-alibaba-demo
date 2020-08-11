package com.ncars.nacos.controller;

import com.alibaba.nacos.api.exception.NacosException;
import com.ncars.nacos.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public String get(@RequestParam String serviceName) throws NacosException {
        Map<String, Object> paramMap = new HashMap<>(16);
        paramMap.put("serviceName", "service1");
        URI uri = loadBalancerClient.choose("nacos-demo-provider").getUri();

//        String forObject = restTemplate.getForObject("http://nacos-demo-provider/discovery/get", String.class);
        String forObject = restTemplate.getForObject(uri+"/discovery/get?serviceName="+serviceName, String.class);
        return forObject;
    }

    @org.apache.dubbo.config.annotation.Reference
    private UserService userService;

    @GetMapping("/dd")
    @ResponseBody
    public String findName(){
        String name = userService.findName();
        return name;
    }


    @Value("${rm.name}")
    private String rmName;

    //注入配置文件上下文
    @Autowired
    private ConfigurableApplicationContext config;

    @GetMapping("/config")
    @ResponseBody
    public String config(){
        String property = config.getEnvironment().getProperty("rm.name");
        return property;
    }
}
