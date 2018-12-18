package com.astrid.beautysaloon.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BeautyRepository<ENTITY, ID> extends CrudRepository<ENTITY, ID> {

}
