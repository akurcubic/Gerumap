package raf.dsw.gerumap.gui.swing.controller.actions;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class AddVezaAction extends AbstractGerumapAction {

    public AddVezaAction(){

        putValue(SMALL_ICON, loadIcon("/images/veza.png"));
        putValue(NAME, "AddVeza Action");
        putValue(SHORT_DESCRIPTION, "AddVeza Action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MainFrame.getInstance().getProjectView().startAddVezaState();
    }
}
