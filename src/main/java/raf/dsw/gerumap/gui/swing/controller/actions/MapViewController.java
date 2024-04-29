package raf.dsw.gerumap.gui.swing.controller.actions;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MapViewController implements MouseListener {

    private MapView mapView;

    public MapViewController(MapView mapView) {
        this.mapView = mapView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        MainFrame.getInstance().getProjectView().misKliknut(e.getX(),e.getY(),mapView.getMindMap());
        mapView.setDragStartX(e.getX());
        mapView.setDragStartY(e.getY());

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        MainFrame.getInstance().getProjectView().misOtpusten(e.getX(),e.getY(),mapView.getMindMap());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
