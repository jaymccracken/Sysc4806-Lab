package Labs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher{

    public  void launch(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppContext.class);
        context.refresh();
    }
}
