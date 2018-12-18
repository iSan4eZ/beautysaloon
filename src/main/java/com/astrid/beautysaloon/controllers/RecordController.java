package com.astrid.beautysaloon.controllers;

import com.astrid.beautysaloon.entities.RecordEntity;
import com.astrid.beautysaloon.services.RecordService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("records")
public class RecordController {

  private final RecordService recordService;

  @GetMapping
  public List<RecordEntity> getAll() {
    return recordService.getAll();
  }

  @RequestMapping(method = RequestMethod.POST, path = "/add/{workerId}")
  public void add(@RequestBody RecordEntity entity, @PathVariable Integer workerId) {
    recordService.add(entity, workerId);
  }

  @RequestMapping(method = RequestMethod.DELETE, path = "/remove/{id}")
  public void removeById(@PathVariable Integer id) {
    recordService.removeById(id);
  }

}
