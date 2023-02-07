package com.codewithjeanpaul.contacts_app.services;

import com.codewithjeanpaul.contacts_app.models.Contact;
import com.codewithjeanpaul.contacts_app.repositories.ContactRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact saveContact(Contact contact) {
        // save contact
        return contactRepository.save(contact);
    }

    public Contact getContact(Long id) {
        // get contact
        return contactRepository.findById(id).orElse(null);
    }

    public Contact updateContact(Contact contact) {
        // update contact
        return contactRepository.save(contact);
    }

    public void deleteContact(Long id) {
        // delete contact
        contactRepository.deleteById(id);
    }

    public Page<Contact> getAllContacts(String search,Pageable pageable) {
        // get all contacts
        return contactRepository.findAllByNameContainingIgnoreCase(search,pageable);
    }

    public boolean isEmpty() {
        return contactRepository.count() == 0;
    }

}
