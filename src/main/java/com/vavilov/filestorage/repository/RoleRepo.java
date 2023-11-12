package com.vavilov.filestorage.repository;

import com.vavilov.filestorage.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, Long> {
}
