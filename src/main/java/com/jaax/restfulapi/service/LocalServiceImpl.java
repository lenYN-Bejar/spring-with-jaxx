package com.jaax.restfulapi.service;


import com.jaax.restfulapi.entity.Local;
import com.jaax.restfulapi.repository.ILocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LocalServiceImpl implements ILocalService {

    @Autowired
    ILocalRepository iLocalRepository;
    @Override
    public List<Local> findAllLocals() {
        return iLocalRepository.findAll();
    }

    @Override
    public Local saveLocal(Local local) {
        return iLocalRepository.save(local);
    }

    @Override
    public Local updateLocal(Long id, Local local) {
        Local localDb = iLocalRepository.findById(id).get();
        if(Objects.nonNull(local.getCode()) && !"".equalsIgnoreCase(local.getCode())) {
            localDb.setCode(local.getCode());
        }
        if(Objects.nonNull(local.getFloor()) && !"".equalsIgnoreCase(local.getFloor())) {
            localDb.setFloor(local.getFloor());
        }
        if(Objects.nonNull(local.getName()) && !"".equalsIgnoreCase(local.getName())) {
            localDb.setName(local.getName());
        }
        return iLocalRepository.save(localDb);
    }

    @Override
    public void deleteLocal(Long id) {
        iLocalRepository.deleteById(id);
    }
}
