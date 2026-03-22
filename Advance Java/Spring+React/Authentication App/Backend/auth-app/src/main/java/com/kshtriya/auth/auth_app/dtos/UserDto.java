package com.kshtriya.auth.auth_app.dtos;

import com.kshtriya.auth.auth_app.entity.Provider;
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
public class UserDto {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private String image;
    @Builder.Default
    private Boolean enable = true;
    @Builder.Default
    private Instant createdAt = Instant.now();
    @Builder.Default
    private Instant updatedAt = Instant.now();
    @Builder.Default
    private Provider provider = Provider.LOCAL;
    
    @Builder.Default
    private Set<RoleDto> roles = new HashSet<>();
}
