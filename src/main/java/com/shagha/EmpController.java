package com.shagha;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmpController {
    @Autowired
    EmpDao dao;
    @RequestMapping("addemp")
    public ModelAndView showEmpform(){
        return new ModelAndView("addemp","command",new Emp());
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    //note that we wanna  to bind data from the request and add it to the model implicitly emp will use in viewEmployees.jsp
    public ModelAndView addemployee(@ModelAttribute("emp") Emp em){
        dao.save(em);
        return new ModelAndView("redirect:/viewEmployees");
    }
    @RequestMapping("viewEmployees")
    public ModelAndView showAll(){
        List<Emp> empList = dao.showAllEmployeeswithRowMapper();
        return new ModelAndView("viewEmployees", "list", empList);
    }
    @RequestMapping(value ="editemp/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int id){
        Emp mybean = dao.getEmpById(id);
        return new ModelAndView("editemp", "command", mybean);

    }
    @RequestMapping("deleteemp/{id}")
    public ModelAndView delete(@PathVariable int id){
        dao.delete(id);
        return new ModelAndView("redirect:/viewEmployees");

    }
    @RequestMapping(value = "editsave", method = RequestMethod.POST)
    //note that we wanna  to bind data from the request and add it to the model implicitly emp will use in viewEmployees.jsp
    public ModelAndView saveEditemp(@ModelAttribute("emp") Emp em){
        dao.update(em);
        return new ModelAndView("redirect:/viewEmployees");
    }

}
