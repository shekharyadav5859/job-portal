package com.jobportal.JobApply;

import java.util.List;

import org.springframework.stereotype.Service;



@Service 
public class jService {
    public final jRepo jrepo;
    public jService(jRepo jrepo){
     this.jrepo = jrepo;
    }

    //save
    public jEntity jsendar(jEntity j){
        return jrepo.save(j);
    }
    

    //get
    public List<jEntity> get(){
        return jrepo.findAll();
    }
   //delete
   public void delet(Long id) {
    jrepo.deleteById(id);
}
   //put 
   public jEntity put(jEntity j ,Long id){
    jEntity check = jrepo.findById(id)
                    .orElseThrow(()-> new RuntimeException("This User Not vilid"));

    check.setTitle(j.getTitle());
    check.setDescription(j.getDescription());
    check.setCompanyName(j.getCompanyName());
    check.setLocation(j.getLocation());
    check.setJobType(j.getJobType());
    check.setSalaryMin(j.getSalaryMin());
    check.setSalaryMax(j.getSalaryMax());
    check.setSkillsRequired(j.getSkillsRequired());  
    
    
    return jrepo.save(check);
   }

   //singalCompany
   public List<jEntity> getByCompanyId(Long companyId) {
    return jrepo.findByCompanyId(companyId);
}
    
}
