package com.astrid.beautysaloon.services.impl;

import com.astrid.beautysaloon.repositories.BeautyRepository;
import com.astrid.beautysaloon.repositories.impl.WorkerRepository;
import com.astrid.beautysaloon.services.AbstractEntityService;
import org.springframework.stereotype.Service;

@Service
public class WorkerService extends AbstractEntityService<WorkerService, Integer> {

  public WorkerService(WorkerRepository workerRepository) {
    super((BeautyRepository) workerRepository);
  }

}
