package com.lujieni.tkmapper.controller;

import com.lujieni.tkmapper.domain.po.PersonPO;
import com.lujieni.tkmapper.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @Autowired
    private IPersonService iPersonService;

    @GetMapping("/query-person-by-name")
    public List<PersonPO> queryPersonByName(String name){
        return iPersonService.queryPersonByName(name);
    }

    @GetMapping("/query-person")
    public List<PersonPO> queryPerson(){
        return iPersonService.queryPerson();
    }
}