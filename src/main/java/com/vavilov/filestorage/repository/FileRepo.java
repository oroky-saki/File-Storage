package com.vavilov.filestorage.repository;

import com.vavilov.filestorage.model.FileEntity;
import org.springframework.data.repository.CrudRepository;

public interface FileRepo extends CrudRepository<FileEntity, Long> {
}
