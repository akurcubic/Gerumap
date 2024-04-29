package raf.dsw.gerumap.mapRepository.commands.concrete;

import raf.dsw.gerumap.mapRepository.commands.AbstractCommands;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;

public class AddCommand extends AbstractCommands {


    private MindMap mindMap;
    private MapNode child;

    public AddCommand(MindMap mindMap, MapNode child) {
        this.mindMap = mindMap;
        this.child = child;
    }

    @Override
    public void doCommand() {

        mindMap.addChild(child);
    }

    @Override
    public void undoCommand() {
        mindMap.deleteChild(child);
    }
}
