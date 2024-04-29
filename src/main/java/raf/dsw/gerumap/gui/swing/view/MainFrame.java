package raf.dsw.gerumap.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.controller.ActionManager;
import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.gui.swing.tree.MapTreeImplementation;
import raf.dsw.gerumap.gui.swing.tree.view.MapTreeView;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter

public class MainFrame extends JFrame {


    public static MainFrame instance = null;
    private ActionManager actionManager;
    private MyMenu jMenuBar;
    private JToolBar jToolBar;
    private MapTree mapTree;
    private MapTreeView projectExplorer;
    private ProjectView projectView;

    private MainFrame(){

    }

    private void init(){

        actionManager = new ActionManager();
        mapTree = new MapTreeImplementation();
        projectExplorer = mapTree.generateTree(ApplicationFramework.getInstance().getMapRepository().getProjectExplorer());
        initGui();

    }

    private void initGui(){

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int width = dimension.width;
        int height = dimension.height;
        this.setSize(width/2,height/2);
        this.setTitle("GeruMapApp");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        jMenuBar = new MyMenu();
        this.setJMenuBar(jMenuBar);

        jToolBar = new MyToolBar();
        this.add(jToolBar,BorderLayout.NORTH);

        projectView = new ProjectView();
        JScrollPane jScrollPane = new JScrollPane(projectExplorer);
        JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jScrollPane,projectView);
        jSplitPane.setDividerLocation(200);
        this.getContentPane().add(jSplitPane,BorderLayout.CENTER);
        jSplitPane.setOneTouchExpandable(true);


    }

    public static MainFrame getInstance(){

        if(instance == null){
            instance = new MainFrame();
            instance.init();
        }

        return instance;
    }

}
