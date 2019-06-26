package br.ufscar.cloudbroker.mapper;

import br.ufscar.cloudbroker.entity.VirtualMachineEntity;
import br.ufscar.cloudbroker.resource.VirtualMachineResource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VirtualMachineResourceMapper {

    List<VirtualMachineResource> toVirtualMachineResource(List<VirtualMachineEntity> vm);

}