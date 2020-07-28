package org.exmple.repository;

import org.exmple.entity.Role;
import org.exmple.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,String> {
}
