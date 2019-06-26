package br.ufscar.cloudbroker.repository;

import br.ufscar.cloudbroker.entity.VirtualMachineEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VirtualMachineRepository extends MongoRepository<VirtualMachineEntity, Integer> {
}
