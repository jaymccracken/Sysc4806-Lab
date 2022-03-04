package Labs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;

@Configuration
public class AppContext{

    @Bean
    public GUI view(){
        GUI view = new GUI();
        view.setTitle("Address Book");
        view.setSize(new Dimension(500, 500));
        return view;
    }

}
