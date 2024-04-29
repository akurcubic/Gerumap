package raf.dsw.gerumap.gui.swing.controller.actions;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.InfoView;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class InfoAction extends AbstractGerumapAction {


    public InfoAction(){

        putValue(SMALL_ICON, loadIcon("/images/info.png"));
        putValue(NAME, "Info Action");
        putValue(SHORT_DESCRIPTION, "Info Action");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        InfoView infoView = new InfoView(MainFrame.getInstance(),"Info",true);
        infoView.setVisible(true);
    }
}
