package raf.dsw.gerumap.mapRepository.commands;

import raf.dsw.gerumap.core.ApplicationFramework;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private List<AbstractCommands> commands = new ArrayList<>();
    private int currentCommand = 0;

    public void addCommand(AbstractCommands command){
        while(currentCommand < commands.size())
            commands.remove(currentCommand);
        commands.add(command);
        doCommand();
    }

    public void doCommand(){
        if(currentCommand < commands.size()){
            commands.get(currentCommand++).doCommand();
            ApplicationFramework.getInstance().getGui().enableUndoAction();
        }
        if(currentCommand==commands.size()){
            ApplicationFramework.getInstance().getGui().disableRedoAction();
        }
    }

    public void undoCommand(){
        if(currentCommand > 0){
            ApplicationFramework.getInstance().getGui().enableRedoAction();
            commands.get(--currentCommand).undoCommand();
        }
        if(currentCommand==0){
            ApplicationFramework.getInstance().getGui().disableUndoAction();
        }
    }
}
