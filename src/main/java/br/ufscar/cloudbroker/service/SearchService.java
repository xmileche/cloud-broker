package br.ufscar.cloudbroker.service;

import br.ufscar.cloudbroker.entity.VirtualMachineEntity;
import br.ufscar.cloudbroker.repository.VirtualMachineRepository;
import br.ufscar.cloudbroker.util.SortByCost;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class SearchService {
    private VirtualMachineRepository vmRepo;

    public List<VirtualMachineEntity> getResources(
            Integer nMachines,
            List<Integer> vcpus,
            List<Integer> rams,
            List<Integer> disks,
            List<Float> prices) throws Exception {

        if(nMachines != vcpus.size() && nMachines != rams.size() && nMachines != disks.size() && nMachines != prices.size()){
            throw new Exception("parameter error");
        }
        List<VirtualMachineEntity> vms = vmRepo.findAll();

        return match(vms, nMachines, vcpus, rams, disks, prices);
    }

    private List<VirtualMachineEntity> match(
            List<VirtualMachineEntity> vms,
            Integer nMachines,
            List<Integer> vcpus,
            List<Integer> rams,
            List<Integer> disks,
            List<Float> prices) {

        List<VirtualMachineEntity> vmMatch = new ArrayList<>();

        IntStream.rangeClosed(0, nMachines - 1).forEach((e) -> {
            VirtualMachineEntity vm = new VirtualMachineEntity(
                    vcpus.get(e),
                    rams.get(e),
                    disks.get(e),
                    prices.get(e)
            );
            vmMatch.add(vm);
        });

        vms.sort(new SortByCost());
        List<VirtualMachineEntity> matched = new ArrayList<>();
        boolean match = false;

        for(VirtualMachineEntity res : vmMatch){
            for(VirtualMachineEntity vm : vms) {
                if(vm.getPrice() <= res.getPrice()){
                    if(vm.getVcpu() >= res.getVcpu() && vm.getRam() >= res.getRam() && vm.getDisk() >= res.getDisk()){
                        matched.add(vm);
                        match = true;
                        break;
                    }
                }
            }
            if (match) {
                vms.remove(matched.get(matched.size() - 1));
            }
            match = false;
        }
        
        return matched;
    }
}
