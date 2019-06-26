package br.ufscar.cloudbroker.resource;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonPropertyOrder({
        "vcpu",
        "ram",
        "disk",
        "price",
        "provider"
})
public class VirtualMachineResource {
    private Integer vcpu;
    private Integer ram;
    private Integer disk;
    private Integer price;
    private String provider;
}
