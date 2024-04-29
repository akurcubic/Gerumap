package raf.dsw.gerumap.gui.swing.controller.actions;
import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.composite.MapNode;

import raf.dsw.gerumap.mapRepository.factory.MindMapFactory;
import raf.dsw.gerumap.mapRepository.factory.NodeFactory;
import raf.dsw.gerumap.mapRepository.factory.ProjectFactory;
import raf.dsw.gerumap.mapRepository.implementation.element.Element;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;
import raf.dsw.gerumap.messageGenerator.TipPoruke;

import java.awt.event.ActionEvent;



public class NewAction extends AbstractGerumapAction {


    public NewAction() {

        putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "New Action");
        putValue(SHORT_DESCRIPTION, "New Action");
    }


    @Override
    public void actionPerformed(ActionEvent e) {



        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if(selected == null){
            ApplicationFramework.getInstance().getMessageGenerator().generate(TipPoruke.MORATE_SELEKTOVATI_ITEM);
        }
        else if(selected.getMapNode() instanceof MindMap){
            ApplicationFramework.getInstance().getMessageGenerator().generate(TipPoruke.NE_MOZETE_DODATI_CVOR);
        }
        else {
            NodeFactory nodeFactory = fabrika(selected);
            MapNode mapNode = nodeFactory.getNode(selected.getMapNode());
            MainFrame.getInstance().getMapTree().addChild(selected, mapNode);
        }
    }

    private NodeFactory fabrika(MapTreeItem selected){

        MapNode selektovani = selected.getMapNode();
        if(selektovani instanceof ProjectExplorer){
            return new ProjectFactory();
        }
        else if(selektovani instanceof Project){
            return new MindMapFactory();
        }
       /* else if(selektovani instanceof MindMap){
            return new ElementFactory();
        }*/
        return null;
    }
}
