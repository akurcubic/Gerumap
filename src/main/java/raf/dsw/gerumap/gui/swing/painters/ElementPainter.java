package raf.dsw.gerumap.gui.swing.painters;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.implementation.element.Element;

import java.awt.*;
import java.util.Objects;

@Getter
@Setter

public abstract class ElementPainter{

    protected Element element;
    protected Shape s;

    public ElementPainter(Element element) {
        this.element = element;
    }

    public abstract void draw(Graphics g);
    public boolean elementAt(int x,int y){

        return s.contains(x,y);

    }

    @Override
    public String toString() {
        return element.getName();
    }


}
