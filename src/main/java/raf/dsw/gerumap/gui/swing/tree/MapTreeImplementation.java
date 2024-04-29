package raf.dsw.gerumap.gui.swing.tree;


import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.tree.view.MapTreeView;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;
import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;


public class MapTreeImplementation implements MapTree{

    private MapTreeView treeView;
    private DefaultTreeModel defaultTreeModel;


    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {

        MapTreeItem root = new MapTreeItem(projectExplorer);
        defaultTreeModel = new DefaultTreeModel(root);
        treeView = new MapTreeView(defaultTreeModel);
        return treeView;
    }

    @Override
    public void addChild(MapTreeItem parent, MapNode child) {

        if(!((parent.getMapNode()) instanceof MapNodeComposite)){
            return;
        }
        parent.add(new MapTreeItem(child));
        ((MapNodeComposite) parent.getMapNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void deleteChild(MapTreeItem child) {

        MapNode parentMapNode = child.getMapNode().getParent();
        MapTreeItem parentMapTreeItem = (MapTreeItem) child.getParent();
        parentMapTreeItem.remove(child);
        ((MapNodeComposite)parentMapNode).deleteChild(child.getMapNode());
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public MapTreeItem getSelectedNode() {
        return (MapTreeItem) treeView.getLastSelectedPathComponent();
    }

}
