package com.astrid.beautysaloon.services;

import com.astrid.beautysaloon.entities.RecordEntity;
import com.astrid.beautysaloon.entities.WorkerEntity;
import com.astrid.beautysaloon.repositories.RecordRepository;
import com.astrid.beautysaloon.repositories.WorkerRepository;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RecordService {

  private final WorkerRepository workerRepository;
  private final RecordRepository recordRepository;

  public List<RecordEntity> getAll() {
    return Lists.newArrayList(recordRepository.findAll());
  }

  @Transactional
  public void add(RecordEntity record, Integer workerId) {
    Optional<WorkerEntity> workerById = workerRepository.findById(workerId);
    if (!workerById.isPresent()){
      return;
    }
    WorkerEntity worker = workerById.get();
    if (worker.getSchedule().stream().noneMatch(rec -> rec.getRecordTime().equals(record.getRecordTime())))
    {
      if (worker.getAvailableJobTypes().contains(record.getJobType()))
      record.setWorker(worker);
      worker.getSchedule().add(record);
      workerRepository.save(worker);
    }
  }

  @Transactional
  public void removeById(Integer id) {
    recordRepository.deleteById(id);
  }

}
