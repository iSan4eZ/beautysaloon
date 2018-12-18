package com.astrid.beautysaloon.repositories;

import com.astrid.beautysaloon.entities.RecordEntity;
import com.astrid.beautysaloon.entities.WorkerEntity;
import org.springframework.data.repository.CrudRepository;

public interface RecordRepository extends CrudRepository<RecordEntity, Integer> {

}
