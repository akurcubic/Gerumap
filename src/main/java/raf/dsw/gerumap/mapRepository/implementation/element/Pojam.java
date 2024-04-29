package raf.dsw.gerumap.mapRepository.implementation.element;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.painters.VezaPainter;
import raf.dsw.gerumap.mapRepository.composite.MapNode;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class Pojam extends Element{

    private int x;
    private int y;
    private int w;
    private int h;
    private List<VezaPainter> vezaPainters = new ArrayList<>();


    public Pojam(MapNode parent, String name) {
        super(parent, name);
    }

    public Pojam(MapNode parent, String name, int x, int y, int w, int h) {
        super(parent, name);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        return super.getName();
    }
}
