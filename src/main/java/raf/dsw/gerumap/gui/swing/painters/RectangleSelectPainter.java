package raf.dsw.gerumap.gui.swing.painters;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.implementation.element.Element;

import java.awt.*;
import java.awt.geom.Rectangle2D;

@Getter
@Setter

public class RectangleSelectPainter extends ElementPainter{

    private int pocetakX = 1;
    private int pocetakY = 2;
    private int krajX=1;
    private int krajY=2;
    private Shape s = new Rectangle2D.Double();



    public RectangleSelectPainter(Element element) {
        super(element);
    }

    @Override
    public void draw(Graphics g) {

        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.setStroke(new BasicStroke(2.0f,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_MITER,10.0f,new float[]{16.0f,20.0f},0.2f));
        g.setColor(Color.BLACK);
        s=new Rectangle2D.Double(Math.min(pocetakX,krajX),Math.min(pocetakY,krajY),Math.abs(krajX-pocetakX),Math.abs(krajY-pocetakY));
        graphics2D.draw(s);
    }

    @Override
    public boolean elementAt(int x, int y) {
        return true;
    }

    public void setPocetakX(int pocetakX) {
        this.pocetakX = pocetakX;
    }

    public void setPocetakY(int pocetakY) {
        this.pocetakY = pocetakY;
    }

    public void setKrajX(int krajX) {
        this.krajX = krajX;
    }

    public void setKrajY(int krajY) {
        this.krajY = krajY;
    }
}
