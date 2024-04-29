package raf.dsw.gerumap.gui.swing.controller.actions;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;

import java.awt.event.ActionEvent;

public class UndoAction extends AbstractGerumapAction {

    public UndoAction(){

        putValue(SMALL_ICON, loadIcon("/images/undoo.png"));
        putValue(NAME, "Undo Action");
        putValue(SHORT_DESCRIPTION, "Undo Action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if (selected.getMapNode() instanceof MindMap) {
            MindMap mindMap = (MindMap) selected.getMapNode();
            mindMap.getCommandManager().undoCommand();
        }
    }
}
