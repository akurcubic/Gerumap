package raf.dsw.gerumap.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.observer.ISubscriber;
import raf.dsw.gerumap.observer.TipNotifikacije;
import raf.dsw.gerumap.state.StateManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter

public class ProjectView extends JPanel implements ISubscriber{

    private JLabel imeProjekta = new JLabel("");
    private JLabel imeAutora = new JLabel("");
    private Project project;
    private List<MapView> maps = new ArrayList<>();
    private HashMap<Project,List<MapView>> mapeIProjekti = new HashMap<>();
    private JTabbedPane tabbedPane;
    private StateManager stateManager;
    private JToolBar stateToolBar;


    public ProjectView(){


        stateManager = new StateManager();

        this.setLayout(new BorderLayout());

        JLabel projekat = new JLabel("Projekat:");
        JLabel autor = new JLabel("Autor:");


        JPanel panImeProjekta=new JPanel(new FlowLayout(FlowLayout.LEFT));
        panImeProjekta.add(projekat);
        panImeProjekta.add((imeProjekta));


        JPanel panAutor = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panAutor.add(autor);
        panAutor.add(imeAutora);


        Box boxCentar=Box.createVerticalBox();
        boxCentar.add(Box.createVerticalStrut(20));
        boxCentar.add(panImeProjekta);
        boxCentar.add(panAutor);

        this.add(boxCentar,BorderLayout.NORTH);

        tabbedPane = new JTabbedPane();
        this.add(tabbedPane,BorderLayout.CENTER);

        stateToolBar = new StateToolBar();
        this.add(stateToolBar,BorderLayout.EAST);


    }

    @Override
    public void update(Object notifikacija , TipNotifikacije tipNotifikacije) {

        if(notifikacija instanceof String && tipNotifikacije == TipNotifikacije.SET_AUTOR){
            String imeAutora = (String)notifikacija;
            this.imeAutora.setText(imeAutora);

        }
        if(notifikacija instanceof String && tipNotifikacije == TipNotifikacije.SET_IME){
            String imeProjekta = (String)notifikacija;
            this.imeProjekta.setText(imeProjekta);
        }
        if(notifikacija instanceof MindMap && tipNotifikacije == TipNotifikacije.DODAVANJE_MAPE){
            MindMap m = (MindMap)notifikacija;
            MapView mapView = new MapView(m.getName(),m);
            this.maps.add(mapView);
            this.tabbedPane.add(m.getName(),mapView);

            //dodavanje u hesMapu

            if(mapeIProjekti.containsKey(project)){
                List<MapView> lista = mapeIProjekti.get(project);
                lista.add(mapView);
                mapeIProjekti.put(project,lista);
            }
            else{
                List<MapView> novaLista = new ArrayList<>();
                novaLista.add(mapView);
                mapeIProjekti.put(project,novaLista);
            }
        }


        if(notifikacija instanceof MindMap && tipNotifikacije == TipNotifikacije.BRISANJE_MAPE){
            MindMap m = (MindMap) notifikacija;
            MapView mw = null;
            for(MapView mapView : this.maps){
                if(m.getName().equals(mapView.imeMape())){
                    mw = mapView;
                    this.maps.remove(mw);
                    break;
                }
            }
            this.tabbedPane.remove(mw);
        }
    }

    public void setProjectView(Project project){

        this.project = project;
        if(!project.getSubscribers().isEmpty()){
            project.getSubscribers().clear();
        }
        project.getSubscribers().add(this);
        this.imeProjekta.setText(project.getName());
        this.imeAutora.setText(project.getAutor());
        postaviTabove();
    }

    private void postaviTabove(){

        this.maps.clear();
        this.tabbedPane.removeAll();

        List<MapView> mapViewList = mapeIProjekti.get(this.project);

        if(mapViewList != null)
            maps.addAll(mapViewList);

        for(MapView mapView : this.maps){
            this.tabbedPane.add(mapView.getName(),mapView);
        }
    }

    public void startAddPojamState(){

        stateManager.setAddPojamState();
    }
    public void startAddVezaState(){

        stateManager.setAddVezaState();
    }
    public void startDeleteElementState(){

        stateManager.setDeleteElementState();
    }
    public void startMoveElementState(){

        stateManager.setMoveElementState();
    }
    public void startSettingsState(){

        stateManager.setSettingsState();
    }
    public void startZoomState(){

        stateManager.setZoomState();
    }
    public void startZoomOutState(){

        stateManager.setZoomOutState();
    }
    public void startSelectionState(){

        stateManager.setSelectionState();
    }

    public void misKliknut(int x, int y, MindMap mindMap){

        stateManager.getCurrState().misKliknut(x,y,mindMap);
    }
    public void misPovucen(int x,int y,MindMap mindMap){

        stateManager.getCurrState().misPovucen(x,y,mindMap);
    }
    public void misOtpusten(int x,int y,MindMap mindMap){

        stateManager.getCurrState().misOtpusten(x,y,mindMap);
    }
}
