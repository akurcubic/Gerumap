package raf.dsw.gerumap.gui.swing.controller.actions;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MapViewDrag implements MouseMotionListener {

    private MapView mapView;

    public MapViewDrag(MapView mapView) {
        this.mapView = mapView;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        MainFrame.getInstance().getProjectView().misPovucen(e.getX(),e.getY(),mapView.getMindMap());
        if((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0){
            int dx = e.getX() - mapView.getDragStartX();
            int dy = e.getY() - mapView.getDragStartY();
            mapView.setTranslateX(mapView.getTranslateX() + dx);
            mapView.setTranslateY(mapView.getDragStartY() + dy);
            mapView.setDragStartX(e.getX());
            mapView.setDragStartY(e.getY());
            mapView.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
