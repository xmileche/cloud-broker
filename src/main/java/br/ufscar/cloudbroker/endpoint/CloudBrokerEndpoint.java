package br.ufscar.cloudbroker.endpoint;

import br.ufscar.cloudbroker.entity.VirtualMachineEntity;
import br.ufscar.cloudbroker.mapper.VirtualMachineResourceMapper;
import br.ufscar.cloudbroker.resource.VirtualMachineResource;
import br.ufscar.cloudbroker.service.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        value = "/api"
)
@AllArgsConstructor
public class CloudBrokerEndpoint {

    private SearchService searchService;
    private VirtualMachineResourceMapper vmMapper;

    @GetMapping(value = "/search")
    public ResponseEntity<List<VirtualMachineResource>> searchResources(
            @RequestParam(value="nMachines") Integer nMachines,
            @RequestParam(value="vcpu") List<Integer> vcpus,
            @RequestParam(value="ram") List<Integer> rams,
            @RequestParam(value="disk") List<Integer> disks,
            @RequestParam(value="price") List<Float> prices
    ) throws Exception {
        List<VirtualMachineEntity> vms = searchService.getResources(nMachines, vcpus, rams, disks, prices);
        List<VirtualMachineResource> vmResource = vmMapper.toVirtualMachineResource(vms);

        return new ResponseEntity<>(vmResource, HttpStatus.OK);
    }
}
