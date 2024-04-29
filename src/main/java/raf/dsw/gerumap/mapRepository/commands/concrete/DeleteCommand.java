package raf.dsw.gerumap.mapRepository.commands.concrete;

import raf.dsw.gerumap.gui.swing.painters.ElementPainter;
import raf.dsw.gerumap.gui.swing.painters.VezaPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.mapRepository.commands.AbstractCommands;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;

import java.util.ArrayList;
import java.util.List;

public class DeleteCommand extends AbstractCommands {

    private MindMap mindMap;
    private MapNode mapNode;
    private List<VezaPainter> veze;
    private List<ElementPainter> elementPainters;

    public DeleteCommand(MindMap mindMap, MapNode mapNode, List<VezaPainter> veze, List<ElementPainter> elementPainters) {
        this.mindMap = mindMap;
        this.mapNode = mapNode;
        this.veze = veze;
        this.elementPainters = elementPainters;
    }

    @Override
    public void doCommand() {

        if(!veze.isEmpty()){
            for(VezaPainter vezaPainter : veze){
                elementPainters.remove(vezaPainter);
                mindMap.deleteChild(vezaPainter.getElement());
            }
        }
        mindMap.deleteChild(mapNode);
    }

    @Override
    public void undoCommand() {

        if(!veze.isEmpty()){
            for(VezaPainter vezaPainter : veze){
                elementPainters.add(vezaPainter);
                mindMap.addChild(vezaPainter.getElement());
            }
        }
        mindMap.addChild(mapNode);
    }
}
