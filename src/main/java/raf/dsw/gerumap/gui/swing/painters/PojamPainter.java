package raf.dsw.gerumap.gui.swing.painters;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.main.Main;
import raf.dsw.gerumap.mapRepository.implementation.element.Element;
import raf.dsw.gerumap.mapRepository.implementation.element.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;

import java.awt.*;
import java.awt.geom.GeneralPath;


public class PojamPainter extends ElementPainter{

    public PojamPainter(Element element) {
        super(element);
    }

    @Override
    public void draw(Graphics g) {


        Pojam rectangle = (Pojam)element;
        s = new GeneralPath();
        ((GeneralPath)s).moveTo(rectangle.getX(),rectangle.getY());

        ((GeneralPath)s).lineTo(rectangle.getX()+rectangle.getW(),rectangle.getY());

        ((GeneralPath)s).lineTo(rectangle.getX()+rectangle.getW(),rectangle.getY()+rectangle.getH());

        ((GeneralPath)s).lineTo(rectangle.getX(),rectangle.getY()+rectangle.getH());

        ((GeneralPath)s).closePath();

        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setStroke(new BasicStroke(element.getDebljina()));
        g.setColor(new Color(element.getColour()));


        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if (selected.getMapNode() instanceof MindMap) {
            MindMap mindMap = (MindMap) selected.getMapNode();
            for (MapView mapView : MainFrame.getInstance().getProjectView().getMaps()) {
                if (mapView.getName().equals(mindMap.getName())){
                    if(mapView.getSelektovaniElementi().contains(this)){
                        g.setColor(new Color(0,0,255,15));
                        Pojam pojamElement = (Pojam)element;
                        g.fillRect(pojamElement.getX(), pojamElement.getY(),pojamElement.getW(), pojamElement.getH());
                    }
                }
            }
        }

        graphics2D.draw(s);
        g.drawString(element.getName(), (int)((Pojam) element).getX()+23,
                ((Pojam) element).getY()+35);
    }
}
