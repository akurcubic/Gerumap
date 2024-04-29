package raf.dsw.gerumap.mapRepository.commands.concrete;

import raf.dsw.gerumap.mapRepository.commands.AbstractCommands;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.element.Element;
import raf.dsw.gerumap.mapRepository.implementation.element.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;

public class MoveCommand extends AbstractCommands {

    private MapNode mapNode;
    int x;
    int y;
    int xPocetak;
    int yPocetak;
    int xKraj;
    int yKraj;
    int stariX;
    int stariY;

    public MoveCommand(MapNode mapNode, int x, int y, int xPocetak, int yPocetak, int xKraj, int yKraj, int stariX, int stariY) {
        this.mapNode = mapNode;
        this.x = x;
        this.y = y;
        this.xPocetak = xPocetak;
        this.yPocetak = yPocetak;
        this.xKraj = xKraj;
        this.yKraj = yKraj;
        this.stariX = stariX;
        this.stariY = stariY;

    }

    @Override
    public void doCommand() {

        if(mapNode instanceof Pojam){
            Pojam pojam = (Pojam) mapNode;
            pojam.noveKoordinate(pojam, x, y);
        }
    }

    @Override
    public void undoCommand() {
        if(mapNode instanceof Pojam){
            Pojam pojam = (Pojam) mapNode;
            pojam.noveKoordinate(pojam, stariX, stariY);
        }
    }
}
