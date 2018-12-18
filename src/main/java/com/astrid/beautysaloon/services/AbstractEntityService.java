package com.astrid.beautysaloon.services;

import com.astrid.beautysaloon.repositories.BeautyRepository;
import com.google.common.collect.Lists;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public abstract class AbstractEntityService<ENTITY, ID> {

  private final BeautyRepository<ENTITY, ID> beautyRepository;

  public List<ENTITY> getAll() {
    return Lists.newArrayList(beautyRepository.findAll());
  }

  public void add(ENTITY entity) {
    beautyRepository.save(entity);
  }

  @Transactional
  public void removeById(ID id) {
    beautyRepository.deleteById(id);
  }
}
