package com.energymanagementsystem.ems.controller;

import com.energymanagementsystem.ems.repository.CompanyRepository;
import com.energymanagementsystem.ems.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @RequestMapping("/home")
    public String index() {
        return "CompanyViews/home";
    }

    @RequestMapping("/list")
    public String showListOfCompanies(Model model) {
        List<Company> companies = new ArrayList<>();
        companyRepository.findAll().forEach(companies::add);
        model.addAttribute("companies", companies);

        return "templates/CompanyViews/List";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCompanyPage(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("edit");
        Optional<Company> company = companyRepository.findById((id));
        mav.addObject("company", company.get());
        return mav;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCompany(@ModelAttribute("company") Company company){
        Optional<Company> _company = companyRepository.findById(company.getId());
        _company.get().setName(company.getName());
        _company.get().setLocation(company.getLocation());
        _company.get().setType(company.getType());

        companyRepository.save(_company.get());

        return "redirect:/company/List";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCompany(@PathVariable(name = "id") int id) {
        Optional<Company> company = companyRepository.findById(id);
        companyRepository.delete(company.get());
        return "redirect:/company/List";
    }

}
