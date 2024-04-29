package raf.dsw.gerumap.gui.swing.view;

import lombok.Getter;

import javax.swing.*;


@Getter

public class SetAutorView extends JOptionPane {

    private String name;

    public SetAutorView(){

        name = showInputDialog(MainFrame.getInstance(),"Enter author name");
        setVisible(true);
    }
}
