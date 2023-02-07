package com.codewithjeanpaul.contacts_app.services.seeders;

import com.codewithjeanpaul.contacts_app.models.Contact;
import com.codewithjeanpaul.contacts_app.services.ContactService;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class ContactTableSeeder {
    private final ContactService contactService;


    public ContactTableSeeder(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostConstruct
    public void seedContacts() {
        if (!contactService.isEmpty()) {
            return;
        }

        for (int i = 0; i < 25; i++) {
            Faker faker = new Faker();
            Contact contact = new Contact();
            contact.setName(faker.name().fullName());
            contact.setPhoneNumber(faker.phoneNumber().cellPhone());
            contact.setEmail(faker.internet().emailAddress());
            contact.setAddress(faker.address().fullAddress());
            contact.setImageUrl(faker.internet().image());
            contact.setFavorite(faker.bool().bool());
            contactService.saveContact(contact);

        }
    }


}
