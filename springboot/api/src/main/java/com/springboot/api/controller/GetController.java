package com.springboot.api.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

import com.springboot.api.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    //    http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        LOGGER.info("gethello 호출");
        return "Hello world";
    }

    @GetMapping(value = "/name")
    public String getName() {
        LOGGER.info("getname 호출");
        return "Flature";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String kim) {
        return kim;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

@ApiOperation(value = "Get 메서드 예제", notes = "@RequestParam을 활용한 GET Method")
    @GetMapping(value = "/request1")
    public String getReauestParam1(
            @ApiParam(value = "이름", required = true) @RequestParam String name,
            @ApiParam(value = "이메일", required = true) @RequestParam String email,
            @ApiParam(value = "회사", required = true) @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    @GetMapping(value = "/request2")
    public String getRequestParam2(
            @RequestParam Map<String, String> param) {
            StringBuilder sb = new StringBuilder();
            param.entrySet().forEach(map ->{
                sb.append(map.getKey() + " : " + map.getValue() + "\n");
                System.out.println(sb);
            });
            return sb.toString();
    }

    @GetMapping(value = "/request3")
    public  String getRequestParam3(MemberDTO memberDto){
        memberDto.getOrganization();
        return memberDto.toString();
    }



}
