package com.medium.pubsub.ship.component;

import com.medium.pubsub.ship.model.Parameters;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ParameterFactory {
    public static Parameters getParameter() {
        Random random = new Random();
        Parameters p = new Parameters(
                random.nextFloat(),
                random.nextFloat(),
                random.nextFloat(),
                random.nextFloat()
        );
        return p;
    }

}
