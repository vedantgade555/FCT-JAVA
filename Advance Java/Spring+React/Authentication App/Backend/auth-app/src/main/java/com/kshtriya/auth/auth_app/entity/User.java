package com.kshtriya.auth.auth_app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    @Column(name="user_id")
    private UUID id;
    @Column(name="user_name")
    private String name;
    @Column(name="user_email" ,unique=true,length = 300)
    private String email;
    private String password;
    private String image;
    @Builder.Default
    private Boolean enable = true;
    @Builder.Default
    private Instant createdAt = Instant.now();
    @Builder.Default
    private Instant updatedAt = Instant.now();

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Provider provider = Provider.LOCAL;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @Builder.Default
    private Set<Role> roles = new HashSet<>();

//    @PrePersist this is used bcoz when entity created it will called automatically
    @PrePersist
    protected void onCreate(){
        Instant now = Instant.now();

        if(createdAt == null) createdAt = now;
        updatedAt=now;
    }

    @PreUpdate
    protected void onUpdate(){
        updatedAt=Instant.now();
    }

}
