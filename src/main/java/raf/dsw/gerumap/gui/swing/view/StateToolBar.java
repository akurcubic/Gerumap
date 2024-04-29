package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;

public class StateToolBar extends JToolBar{

    public StateToolBar(){

        super(VERTICAL);
        setFloatable(false);

        this.add(MainFrame.getInstance().getActionManager().getAddPojamAction());
        this.add(MainFrame.getInstance().getActionManager().getAddVezaAction());
        this.add(MainFrame.getInstance().getActionManager().getDeleteElementAction());
        this.add(MainFrame.getInstance().getActionManager().getMoveAction());
        this.add(MainFrame.getInstance().getActionManager().getZoomInAction());
        this.add(MainFrame.getInstance().getActionManager().getZoomOutAction());
        this.add(MainFrame.getInstance().getActionManager().getSelectAction());
        this.add(MainFrame.getInstance().getActionManager().getSettingsAction());
    }
}
