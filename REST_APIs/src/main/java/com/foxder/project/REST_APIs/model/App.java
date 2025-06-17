package com.foxder.project.REST_APIs.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public final class App {
    @Value("${app-information-name}")
    private String name;

    @Value("${app-information-address}")
    private String address;

    @Value("${app-information-version}")
    private String version;
}
