package com.astrid.beautysaloon.controllers;

import com.astrid.beautysaloon.services.AbstractEntityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequiredArgsConstructor
public abstract class AbstractEntityController<ENTITY, ID> {

  private final AbstractEntityService<ENTITY, ID> beautyService;

  @GetMapping
  public List<ENTITY> getAll() {
    return beautyService.getAll();
  }

  @PostMapping("/add")
  public void add(@RequestBody ENTITY entity) {
    beautyService.add(entity);
  }

  @RequestMapping(method = RequestMethod.DELETE, path = "/remove/{id}")
  public void removeById(@PathVariable ID id) {
    beautyService.removeById(id);
  }
}
