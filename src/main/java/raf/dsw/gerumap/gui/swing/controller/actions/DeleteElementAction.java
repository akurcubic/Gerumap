package raf.dsw.gerumap.gui.swing.controller.actions;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class DeleteElementAction extends AbstractGerumapAction {


    public DeleteElementAction(){

        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(NAME, "DeleteElement Action");
        putValue(SHORT_DESCRIPTION, "DeleteElement Action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MainFrame.getInstance().getProjectView().startDeleteElementState();
    }
}
