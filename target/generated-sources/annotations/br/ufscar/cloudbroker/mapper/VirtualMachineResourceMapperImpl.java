package br.ufscar.cloudbroker.mapper;

import br.ufscar.cloudbroker.entity.VirtualMachineEntity;
import br.ufscar.cloudbroker.resource.VirtualMachineResource;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-01-16T12:42:15-0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class VirtualMachineResourceMapperImpl implements VirtualMachineResourceMapper {

    @Override
    public List<VirtualMachineResource> toVirtualMachineResource(List<VirtualMachineEntity> vm) {
        if ( vm == null ) {
            return null;
        }

        List<VirtualMachineResource> list = new ArrayList<VirtualMachineResource>( vm.size() );
        for ( VirtualMachineEntity virtualMachineEntity : vm ) {
            list.add( virtualMachineEntityToVirtualMachineResource( virtualMachineEntity ) );
        }

        return list;
    }

    protected VirtualMachineResource virtualMachineEntityToVirtualMachineResource(VirtualMachineEntity virtualMachineEntity) {
        if ( virtualMachineEntity == null ) {
            return null;
        }

        VirtualMachineResource virtualMachineResource = new VirtualMachineResource();

        virtualMachineResource.setVcpu( virtualMachineEntity.getVcpu() );
        virtualMachineResource.setRam( virtualMachineEntity.getRam() );
        virtualMachineResource.setDisk( virtualMachineEntity.getDisk() );
        if ( virtualMachineEntity.getPrice() != null ) {
            virtualMachineResource.setPrice( virtualMachineEntity.getPrice().intValue() );
        }
        virtualMachineResource.setProvider( virtualMachineEntity.getProvider() );

        return virtualMachineResource;
    }
}
