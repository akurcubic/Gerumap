package raf.dsw.gerumap.main;
import raf.dsw.gerumap.core.*;
import raf.dsw.gerumap.errorrLogger.ConsoleLogger;
import raf.dsw.gerumap.errorrLogger.FileLogger;
import raf.dsw.gerumap.gui.swing.SwingGui;
import raf.dsw.gerumap.mapRepository.MapRepositoryImplementation;
import raf.dsw.gerumap.messageGenerator.MessageGeneratorImpl;

public class Main {

    public static Gui gui;
    public static ErrorLogger errorLogger;

    public static void main(String[] args) {

        gui = new SwingGui();
        MapRepository mapRepository = new MapRepositoryImplementation();
        errorLogger = new FileLogger();
        MessageGenerator messageGenerator = new MessageGeneratorImpl();
        ApplicationFramework applicationFramework = ApplicationFramework.getInstance();
        applicationFramework.init(gui,mapRepository,messageGenerator,errorLogger);


        applicationFramework.runGui();
    }
}
