package raf.dsw.gerumap.gui.swing.tree.controller;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TreeListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if(e.getClickCount() == 2){
            if(selected.getMapNode() instanceof Project){
                Project p = (Project) selected.getMapNode();
                MainFrame.getInstance().getProjectView().setProjectView(p);
            }
        }
        if(e.getClickCount() == 1){
            if(selected.getMapNode() instanceof MindMap) {
                MindMap m = (MindMap) selected.getMapNode();
                for(MapView mapView : MainFrame.getInstance().getProjectView().getMaps()){
                    if(m.getName().equals(mapView.getName())){
                        mapView.setMapView(m);
                    }
                }
            }

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
