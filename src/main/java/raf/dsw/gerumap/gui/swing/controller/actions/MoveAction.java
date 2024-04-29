package raf.dsw.gerumap.gui.swing.controller.actions;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class MoveAction extends AbstractGerumapAction {

    public MoveAction(){

        putValue(SMALL_ICON, loadIcon("/images/drag.png"));
        putValue(NAME, "MoveElement Action");
        putValue(SHORT_DESCRIPTION, "MoveElement Action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MainFrame.getInstance().getProjectView().startMoveElementState();
    }
}
