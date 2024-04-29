package raf.dsw.gerumap.gui.swing.controller.actions;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;
import raf.dsw.gerumap.messageGenerator.TipPoruke;

import java.awt.event.ActionEvent;

public class DeleteAction extends AbstractGerumapAction {

    public DeleteAction(){

        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(NAME, "Delete Action");
        putValue(SHORT_DESCRIPTION, "Delete Action");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();

        if(selected == null){
            ApplicationFramework.getInstance().getMessageGenerator().generate(TipPoruke.MORATE_SELEKTOVATI_ITEM);
        }
        else if(selected.getMapNode() instanceof ProjectExplorer){
            ApplicationFramework.getInstance().getMessageGenerator().generate(TipPoruke.CVOR_NE_MOZE_BITI_OBRISAN);
        }
        else {
            MainFrame.getInstance().getMapTree().deleteChild(selected);

        }
    }
}
