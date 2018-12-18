package com.astrid.beautysaloon.services;

import com.astrid.beautysaloon.entities.WorkerEntity;
import com.astrid.beautysaloon.entities.WorkerEntity.JobType;
import com.astrid.beautysaloon.repositories.WorkerRepository;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WorkerService {

  private final WorkerRepository workerRepository;

  public List<WorkerEntity> getAll() {
    return Lists.newArrayList(workerRepository.findAll());
  }

  public void add(WorkerEntity entity) {
    workerRepository.save(entity);
  }

  @Transactional
  public void removeById(Integer id) {
    workerRepository.deleteById(id);
  }

  public void addJobType(Integer id, JobType type) {
    Optional<WorkerEntity> workerById = workerRepository.findById(id);
    if (!workerById.isPresent()){
      return;
    }
    WorkerEntity worker = workerById.get();
    if (worker.getAvailableJobTypes().contains(type)){
      return;
    }
    worker.getAvailableJobTypes().add(type);
    workerRepository.save(worker);
  }
}
