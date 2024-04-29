package raf.dsw.gerumap.gui.swing.tree.view;

import raf.dsw.gerumap.gui.swing.tree.controller.MapTreeCellEditor;
import raf.dsw.gerumap.gui.swing.tree.controller.TreeListener;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class MapTreeView extends JTree {

    public MapTreeView(DefaultTreeModel defaultTreeModel){
        this.setModel(defaultTreeModel);
        MapTreeCellRenderer mapTreeCellRenderer = new MapTreeCellRenderer();
        this.setCellEditor(new MapTreeCellEditor(this,mapTreeCellRenderer));
        this.setCellRenderer(mapTreeCellRenderer);
        this.addMouseListener(new TreeListener());
        this.setEditable(true);
    }
}
