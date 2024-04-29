package raf.dsw.gerumap.gui.swing.controller.actions;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class AddPojamAction extends AbstractGerumapAction {

    public AddPojamAction(){

        putValue(SMALL_ICON, loadIcon("/images/elipsa.png"));
        putValue(NAME, "AddPojam Action");
        putValue(SHORT_DESCRIPTION, "AddPojam Action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MainFrame.getInstance().getProjectView().startAddPojamState();
    }
}
