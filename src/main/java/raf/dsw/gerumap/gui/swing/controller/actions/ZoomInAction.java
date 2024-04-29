package raf.dsw.gerumap.gui.swing.controller.actions;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class ZoomInAction extends AbstractGerumapAction {


    public ZoomInAction(){

        putValue(SMALL_ICON, loadIcon("/images/zoom.png"));
        putValue(NAME, "ZoomIn Action");
        putValue(SHORT_DESCRIPTION, "ZoomIn Action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MainFrame.getInstance().getProjectView().startZoomState();
    }
}
