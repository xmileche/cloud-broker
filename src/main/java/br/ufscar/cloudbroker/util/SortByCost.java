package br.ufscar.cloudbroker.util;

import br.ufscar.cloudbroker.entity.VirtualMachineEntity;

import java.util.Comparator;

public class SortByCost implements Comparator<VirtualMachineEntity> {

    public int compare(VirtualMachineEntity a, VirtualMachineEntity b) {
        if ( a.getPrice() < b.getPrice() ) return -1;
        else if ( a.getPrice() == b.getPrice() ) return 0;
        else return 1;
    }
}