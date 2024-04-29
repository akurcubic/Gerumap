package raf.dsw.gerumap.gui.swing;

import raf.dsw.gerumap.core.Gui;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.messageGenerator.Message;
import raf.dsw.gerumap.observer.TipNotifikacije;

import javax.swing.*;

public class SwingGui implements Gui{

    private MainFrame mainFrame;
    @Override
    public void start() {

        mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
    }

    @Override
    public void disableUndoAction() {
        MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
    }

    @Override
    public void disableRedoAction() {
        MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
    }

    @Override
    public void enableUndoAction() {
        MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
    }

    @Override
    public void enableRedoAction() {
        MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
    }

    @Override
    public void update(Object notifikacija, TipNotifikacije tipNotifikacije) {

        if(notifikacija instanceof Message){
            Message message = (Message)notifikacija;
            String poruka = message.getPoruka();
            String tip = message.getTipPoruke();
            JOptionPane.showMessageDialog(mainFrame,poruka,tip,1);
        }

    }
}
