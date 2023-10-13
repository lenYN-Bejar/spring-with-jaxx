package com.jaax.restfulapi.controller;

import com.jaax.restfulapi.entity.Local;
import com.jaax.restfulapi.service.ILocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocalController {
    @Autowired
    ILocalService iLocalService;
    @GetMapping("/findAllLocals")
    public List<Local> findAllLocal() {
        return iLocalService.findAllLocals();
    }
    @PostMapping("/saveLocal")
    public Local saveLocal(@RequestBody Local local) {
        return iLocalService.saveLocal(local);
    }

    @PutMapping("/updateLocal/{id}")
    public Local updateLocal(@RequestBody Local local, @PathVariable Long id) {
        return  iLocalService.updateLocal(id, local);
    }
    @DeleteMapping("/deleteLocal/{id}")
    public String deletelocal(@PathVariable Long id) {
        iLocalService.deleteLocal(id);
        return "Succefully deleted";
    }
}
