package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;

public class MyMenu extends JMenuBar {

    public MyMenu(){

        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewAction());
        this.add(fileMenu);
        helpMenu.add(MainFrame.getInstance().getActionManager().getInfoAction());
        this.add(helpMenu);
    }
}
