package com.metacoding.upload;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "upload_tb")
@Entity
public class Upload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String profileUrl;

    @Builder
    public Upload(Integer id, String username, String profileUrl) {
        this.id = id;
        this.username = username;
        this.profileUrl = profileUrl;
    }
}
