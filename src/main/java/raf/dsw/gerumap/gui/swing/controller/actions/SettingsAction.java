package raf.dsw.gerumap.gui.swing.controller.actions;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class SettingsAction extends AbstractGerumapAction {

    public SettingsAction(){

        putValue(SMALL_ICON, loadIcon("/images/settings.png"));
        putValue(NAME, "Settings Action");
        putValue(SHORT_DESCRIPTION, "Settings Action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MainFrame.getInstance().getProjectView().startSettingsState();
    }
}
