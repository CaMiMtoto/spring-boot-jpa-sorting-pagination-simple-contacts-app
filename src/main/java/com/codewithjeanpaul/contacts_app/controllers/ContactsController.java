package com.codewithjeanpaul.contacts_app.controllers;

import com.codewithjeanpaul.contacts_app.forms.ContactForm;
import com.codewithjeanpaul.contacts_app.models.Contact;
import com.codewithjeanpaul.contacts_app.services.ContactService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/contacts")
public class ContactsController {
    private final ContactService contactService;

    public ContactsController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("")
    public String getContacts(@RequestParam(required = false) Integer page,
                              @RequestParam(required = false) Integer size,
                              @RequestParam(required = false) String sort,
                              @RequestParam(required = false) String dir,
                              @RequestParam(required = false, defaultValue = "") String search,
                              ModelMap modelMap) {

        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = 10;
        }
        if (sort == null) {
            sort = "id";
        }
        Sort sortBy = Sort.by(Objects.equals(dir, "desc") ? Sort.Direction.DESC : Sort.Direction.ASC, sort);

        Pageable pageable = PageRequest.of(page, size, sortBy);
        Page<Contact> contacts = contactService.getAllContacts(search, pageable);
        modelMap.addAttribute("contacts", contacts);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("currentSize", size);
        modelMap.addAttribute("currentSort", sort);
        modelMap.addAttribute("currentDir", dir);
        return "contacts";
    }

    @GetMapping("/create")
    public String createContact(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Valid ContactForm contactForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Contact contact = new Contact();
        contact.setName(contactForm.getName());
        contact.setPhoneNumber(contactForm.getPhone());
        contact.setEmail(contactForm.getEmail());
        contact.setAddress(contactForm.getAddress());
        contactService.saveContact(contact);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editContact(@PathVariable Long id, Model model) {
        Contact contact = contactService.getContact(id);
        ContactForm contactForm = new ContactForm();
        contactForm.setName(contact.getName());
        contactForm.setPhone(contact.getPhoneNumber());
        contactForm.setEmail(contact.getEmail());
        contactForm.setAddress(contact.getAddress());
        model.addAttribute("contactForm", contactForm);
        model.addAttribute("id", id);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@Valid ContactForm contactForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        Contact contact = new Contact();
        contact.setName(contactForm.getName());
        contact.setPhoneNumber(contactForm.getPhone());
        contact.setEmail(contactForm.getEmail());
        contact.setAddress(contactForm.getAddress());
        contactService.updateContact(contact);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return "redirect:/";
    }

}
