package com.codewithjeanpaul.contacts_app.repositories;

import com.codewithjeanpaul.contacts_app.models.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Page<Contact> findAllByNameContainingIgnoreCase(String search,Pageable pageable);


}
