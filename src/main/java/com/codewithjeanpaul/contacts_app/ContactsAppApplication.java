package com.codewithjeanpaul.contacts_app;

import com.codewithjeanpaul.contacts_app.models.Contact;
import com.codewithjeanpaul.contacts_app.repositories.ContactRepository;
import com.codewithjeanpaul.contacts_app.services.ContactService;
import com.codewithjeanpaul.contacts_app.services.seeders.ContactTableSeeder;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContactsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactsAppApplication.class, args);
    }

    @Bean
    public ContactTableSeeder seedContacts(ContactService contactService) {
        return new ContactTableSeeder(contactService);
    }

}
