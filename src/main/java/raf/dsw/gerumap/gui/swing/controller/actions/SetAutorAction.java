package raf.dsw.gerumap.gui.swing.controller.actions;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.SetAutorView;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.messageGenerator.TipPoruke;

import java.awt.event.ActionEvent;

public class SetAutorAction extends AbstractGerumapAction {

    public SetAutorAction(){

        putValue(SMALL_ICON, loadIcon("/images/autor.jpg"));
        putValue(NAME, "SetAuthor Action");
        putValue(SHORT_DESCRIPTION, "SetAuthor Action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if(selected == null){
            ApplicationFramework.getInstance().getMessageGenerator().generate(TipPoruke.MORATE_SELEKTOVATI_ITEM);
        }
        else if(selected.getMapNode() instanceof Project){
            Project project = (Project)selected.getMapNode();
            SetAutorView setAutorView = new SetAutorView();
            project.setAutor(setAutorView.getName());
        }
    }
}
