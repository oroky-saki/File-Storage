package com.vavilov.filestorage.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "files")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private DocumentType file_type;
    private Long fie_size;
    private LocalDateTime upload;
    private LocalDateTime edited;
    private String path;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
