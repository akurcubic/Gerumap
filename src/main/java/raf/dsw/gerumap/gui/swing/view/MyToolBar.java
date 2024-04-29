package raf.dsw.gerumap.gui.swing.view;
import javax.swing.*;



public class MyToolBar extends JToolBar{


    public MyToolBar(){


        super(HORIZONTAL);
        setFloatable(false);
        this.add(MainFrame.getInstance().getActionManager().getNewAction());
        this.add(MainFrame.getInstance().getActionManager().getInfoAction());
        this.add(MainFrame.getInstance().getActionManager().getDeleteAction());
        this.add(MainFrame.getInstance().getActionManager().getSetAutorAction());
        this.add(MainFrame.getInstance().getActionManager().getUndoAction());
        this.add(MainFrame.getInstance().getActionManager().getRedoAction());
        this.add(MainFrame.getInstance().getActionManager().getSavePngAction());
    }
}
