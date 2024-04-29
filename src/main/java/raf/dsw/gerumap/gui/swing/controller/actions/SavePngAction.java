package raf.dsw.gerumap.gui.swing.controller.actions;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;

import java.awt.event.ActionEvent;
import java.io.File;

public class SavePngAction extends AbstractGerumapAction {

    public SavePngAction(){

        putValue(SMALL_ICON, loadIcon("/images/png.png"));
        putValue(NAME, "SavePng Action");
        putValue(SHORT_DESCRIPTION, "SavePng Action");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        MapTreeItem selected =  MainFrame.getInstance().getMapTree().getSelectedNode();
        if (selected.getMapNode() instanceof MindMap) {
            MindMap mindMap = (MindMap) selected.getMapNode();
            for (MapView mapView : MainFrame.getInstance().getProjectView().getMaps()) {
                if (mapView.getMindMap().getName().equals(mindMap.getName())) {
                    mapView.saveImage(new File("slika.png"));
                }
            }
        }
    }
    
}
