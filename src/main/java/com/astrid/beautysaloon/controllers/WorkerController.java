package com.astrid.beautysaloon.controllers;

import com.astrid.beautysaloon.entities.WorkerEntity;
import com.astrid.beautysaloon.entities.WorkerEntity.JobType;
import com.astrid.beautysaloon.services.WorkerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("workers")
public class WorkerController {

  private final WorkerService workerService;

  @GetMapping
  public List<WorkerEntity> getAll() {
    return workerService.getAll();
  }

  @PostMapping("/add")
  public void add(@RequestBody WorkerEntity entity) {
    workerService.add(entity);
  }

  @PostMapping("/{id}/addJob/{type}")
  public void addJobType(@PathVariable Integer id, @PathVariable JobType type) {
    workerService.addJobType(id, type);
  }

  @RequestMapping(method = RequestMethod.DELETE, path = "/remove/{id}")
  public void removeById(@PathVariable Integer id) {
    workerService.removeById(id);
  }

}
