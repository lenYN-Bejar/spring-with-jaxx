package com.jaax.restfulapi.service;

import com.jaax.restfulapi.entity.Local;

import java.util.List;

public interface ILocalService {
    List<Local> findAllLocals();
    Local saveLocal(Local local);
    Local updateLocal(Long id, Local local);
    void deleteLocal(Long id);
}
