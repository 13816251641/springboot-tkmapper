package com.lujieni.tkmapper.service;

import com.lujieni.tkmapper.domain.po.PersonPO;

import java.util.List;

public interface IPersonService {

    List<PersonPO> queryPersonByName(String name);

    List<PersonPO> queryPerson();
}
