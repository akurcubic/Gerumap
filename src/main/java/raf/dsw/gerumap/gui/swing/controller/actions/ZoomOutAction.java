package raf.dsw.gerumap.gui.swing.controller.actions;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class ZoomOutAction extends AbstractGerumapAction {

    public ZoomOutAction(){

        putValue(SMALL_ICON, loadIcon("/images/zoomout.png"));
        putValue(NAME, "ZoomOut Action");
        putValue(SHORT_DESCRIPTION, "ZoomOut Action");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MainFrame.getInstance().getProjectView().startZoomOutState();
    }
}
