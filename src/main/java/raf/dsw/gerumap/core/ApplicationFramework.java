package raf.dsw.gerumap.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ApplicationFramework {

    public static ApplicationFramework instance = null;
    private Gui gui;
    private MapRepository mapRepository;
    private MessageGenerator messageGenerator;
    private ErrorLogger errorLogger;

    private ApplicationFramework(){


    }

    public void init(Gui gui, MapRepository mapRepository, MessageGenerator messageGenerator, ErrorLogger errorLogger){

        this.gui = gui;
        this.mapRepository = mapRepository;
        this.messageGenerator = messageGenerator;
        this.errorLogger = errorLogger;

    }

    public static ApplicationFramework getInstance(){

        if(instance == null){
            instance = new ApplicationFramework();
        }
        return instance;
    }

    public void runGui(){

        this.gui.start();
    }


}
