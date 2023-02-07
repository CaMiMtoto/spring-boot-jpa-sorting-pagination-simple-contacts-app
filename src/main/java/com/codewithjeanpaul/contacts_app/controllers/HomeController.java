package com.codewithjeanpaul.contacts_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("")
    public String index(RedirectAttributes redirectAttributes) {
        // redirect to /contacts
        redirectAttributes.addAttribute("message", "Welcome to the Contacts App!");
        return "redirect:/contacts";
    }


}
