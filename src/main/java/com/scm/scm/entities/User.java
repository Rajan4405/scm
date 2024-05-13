package com.scm.scm.entities;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
  @Id
  private String userId;
  @Column(name = "user_name", nullable = false)
  private String name;
  @Column(unique = true, nullable = false)
  private String email;
  private String password;
  @Column(length = 1000)
  private String about;
  @Column(length = 1000)
  private String profile;
  private String phoneNumber;

  // information
  private boolean enabled = false;
  private boolean emailVerified = false;
  private boolean phoneVerified = false;

  // SELF, GOOGLE, FACEBOOK, TWITTER, GITHUB, LINKEDIN
  private Providers provider = Providers.SELF;
  private String providerUserId;

  // add more fields as and when needed
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  private List<Contact> contacts = new ArrayList<>();

}
