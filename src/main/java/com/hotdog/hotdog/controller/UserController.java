package com.hotdog.hotdog.controller;


import com.hotdog.akka.Entrance;
import com.hotdog.hotdog.swaggerConfig.SwaggerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/user")
@Api("userController相关api")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    Entrance entrance;

    @ApiOperation("获取用户信息")
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUser(/*@RequestHeader("username") String username, @RequestParam("password") String password*/) {
        logger.info("测试swagger");
        return "测试";
    }


    @RequestMapping(value = "/testAkka", method = RequestMethod.GET)
    public String testAkka( @RequestParam("number") int password /*@RequestHeader("username") String username, @RequestParam("password") String password*/) {
        logger.info("测试swagger");

        entrance.main(1);
        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < password; i++) {

            int da = i;
            new Thread("" + da) {
                public void run() {
                    System.out.println("Thread: " + getName() + " running  " + entrance.main(da));
                }

            }.start();
        }
        return "测试";
    }

}

