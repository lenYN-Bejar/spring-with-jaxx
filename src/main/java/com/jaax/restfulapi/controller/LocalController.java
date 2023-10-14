package com.jaax.restfulapi.controller;

import com.jaax.restfulapi.entity.Local;
import com.jaax.restfulapi.error.LocalNotFoundException;
import com.jaax.restfulapi.service.ILocalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocalController {
    @Autowired
    ILocalService iLocalService;

    @GetMapping("/findById/{id}")
    Local findById(@PathVariable Long id) throws LocalNotFoundException {
        return iLocalService.findLocalById(id);
    }
    @GetMapping("/findLocalByNameWithJPQL/{name}")
    Optional<Local> findLocalByNameWithJPQL(@PathVariable String name) {
        return iLocalService.findLocalByNameWithJPQL(name);
    }
    @GetMapping("/findByName/{name}")
    Optional<Local> findByName(@PathVariable String name) {
        return iLocalService.findbyName(name);
    }
    @GetMapping("/findByNameIgnoreCase/{name}")
    Optional<Local> findByNameIgnoreCase(@PathVariable String name) {
        return iLocalService.findByNameIgnoreCase(name);
    }
    @GetMapping("/findAllLocals")
    public List<Local> findAllLocal() {
        return iLocalService.findAllLocals();
    }
    @PostMapping("/saveLocal")
    public Local saveLocal(@Valid @RequestBody Local local) {
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
