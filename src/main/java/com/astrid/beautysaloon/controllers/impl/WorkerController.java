package com.astrid.beautysaloon.controllers.impl;

import com.astrid.beautysaloon.controllers.AbstractEntityController;
import com.astrid.beautysaloon.entities.WorkerEntity;
import com.astrid.beautysaloon.services.AbstractEntityService;
import com.astrid.beautysaloon.services.impl.WorkerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("workers")
public class WorkerController extends AbstractEntityController<WorkerEntity, Integer> {

  public WorkerController(WorkerService workerService) {
    super((AbstractEntityService) workerService);
  }
}
