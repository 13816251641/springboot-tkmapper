package com.lujieni.tkmapper.controller;

import com.lujieni.tkmapper.common.RequestDTO;
import com.lujieni.tkmapper.domain.po.PersonPO;
import com.lujieni.tkmapper.service.IPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @Package: com.lujieni.tkmapper.controller
 * @ClassName: PersonController
 * @Author: lujieni
 * @Description: Person控制器
 * @Date: 2020-12-17 17:31
 * @Version: 1.0
 */
@RestController
public class PersonController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IPersonService iPersonService;


    @PostMapping("/query-person-by-name")
    public List<PersonPO> queryPersonByName(@Valid @RequestBody RequestDTO<String> requestDTO, HttpServletRequest request){
        String apiKey = request.getHeader("ApiKey");
        String authorization = request.getHeader("Authorization");
        logger.info("apiKey:{},authorization:{}",apiKey,authorization);
        return iPersonService.queryPersonByName(requestDTO.getData());
    }

    @GetMapping("/query-person")
    public List<PersonPO> queryPerson(){
        return iPersonService.queryPerson();
    }
}