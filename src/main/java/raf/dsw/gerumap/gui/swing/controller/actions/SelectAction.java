package raf.dsw.gerumap.gui.swing.controller.actions;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class SelectAction extends AbstractGerumapAction {

    public SelectAction(){

        putValue(SMALL_ICON, loadIcon("/images/selection.png"));
        putValue(NAME, "Selection Action");
        putValue(SHORT_DESCRIPTION, "Selection Action");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        MainFrame.getInstance().getProjectView().startSelectionState();
    }
}
