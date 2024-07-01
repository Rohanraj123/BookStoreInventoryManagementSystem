package com.inventory.bookstoremanager.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class RegisterDTO {
    private String username;
    private String password;
}
