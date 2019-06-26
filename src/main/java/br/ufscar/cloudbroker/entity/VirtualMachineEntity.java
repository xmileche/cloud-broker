package br.ufscar.cloudbroker.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "virtual_machines")
@Data
@RequiredArgsConstructor
public class VirtualMachineEntity {

    @Id
    private String id;
    private final Integer vcpu;
    private final Integer ram;
    private final Integer disk;
    private final Float price;
    private String provider;
}
