package com.medium.pubsub.station.configuration;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class StationConfiguration {

    @Value("${station.name}")
    private String STATION_NAME;
}
