package com.jobportal.JobApply;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
@RestController 
@RequestMapping ("/Job/Company")
public class jController {
    public final jService jserv;
  public jController(jService jserv ){
    this.jserv = jserv;
  }

//save
@PostMapping("/post") 
public jEntity save(@RequestBody jEntity j){
    return jserv.jsendar(j);
}

//getAll
@GetMapping("/get")
    public List<jEntity> get(){
        return jserv.get();
    }

// DELETE
@DeleteMapping("/delet/{id}")
public String delet(@PathVariable Long id) {
    jserv.delet(id);

    return "This job is deleted. ID: " + id;
}


// PUT
@PutMapping ("/put/{id}")
public jEntity put(@RequestBody jEntity j, @PathVariable Long id) {
    return jserv.put(j, id);
}

//singalCompany
@GetMapping("/singal/{companyId}")
public List<jEntity> getByCompanyId(
        @PathVariable Long companyId) {

    return jserv.getByCompanyId(companyId);
}
}
