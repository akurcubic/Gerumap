package raf.dsw.gerumap.gui.swing.painters;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.mapRepository.implementation.element.Element;
import raf.dsw.gerumap.mapRepository.implementation.element.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.element.Veza;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;

import java.awt.*;
import java.awt.geom.Line2D;

public class VezaPainter extends ElementPainter{

    public VezaPainter(Element element) {
        super(element);
    }

    @Override
    public void draw(Graphics g) {

        Veza veza = (Veza) element;
        Graphics2D graphics2D = (Graphics2D)g;


        graphics2D.setStroke(new BasicStroke(veza.getDebljina()));
        g.setColor(new Color(veza.getColour()));

        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if (selected.getMapNode() instanceof MindMap) {
            MindMap mindMap = (MindMap) selected.getMapNode();
            for (MapView mapView : MainFrame.getInstance().getProjectView().getMaps()) {
                if (mapView.getName().equals(mindMap.getName())){
                    if(mapView.getSelektovaniElementi().contains(this)){
                        g.setColor(new Color(0,0,255,15));
                    }
                }
            }
        }


        Line2D line = new Line2D.Double(veza.getXPocetak(), veza.getYPocetak(), veza.getXKraj(), veza.getYKraj());
        graphics2D.draw(line);
        setS(line);
    }

}
