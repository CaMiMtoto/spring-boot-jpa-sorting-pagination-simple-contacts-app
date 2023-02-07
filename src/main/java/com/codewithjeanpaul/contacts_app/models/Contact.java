package com.codewithjeanpaul.contacts_app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;


    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "image_url")
    private String imageUrl;


    @Column(name = "is_favorite", nullable = false, columnDefinition = "boolean default false")
    private boolean isFavorite;


}
