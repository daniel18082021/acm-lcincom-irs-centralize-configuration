package com.example.acmlcincomirscentralizeconfiguration.api;

import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthComponent;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.cloud.bus.endpoint.RefreshBusEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ManagementController {

    private final HealthEndpoint healthEndpoint;
    private final InfoEndpoint infoEndpoint;
    private final RefreshBusEndpoint refreshBusEndpoint;

    @GetMapping("health")
    public HealthComponent getHealth() {
        return healthEndpoint.health();
    }

    @GetMapping("info")
    public Map<String, Object> getInfo() {
        return infoEndpoint.info();
    }

    @GetMapping("bus-refresh")
    public String refreshConfig() {
        refreshBusEndpoint.busRefresh();
        return "refresh config";
    }

    @GetMapping("bus-refresh/{destination}")
    public String refreshConfig(@PathVariable String[] destination) {
        refreshBusEndpoint.busRefreshWithDestination(destination);
        return "refresh with destination " + destination;
    }
}
