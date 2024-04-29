package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.painters.ElementPainter;
import raf.dsw.gerumap.gui.swing.painters.PojamPainter;
import raf.dsw.gerumap.gui.swing.painters.VezaPainter;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.SettingsView;

import raf.dsw.gerumap.mapRepository.commands.AbstractCommands;
import raf.dsw.gerumap.mapRepository.commands.concrete.SettingsCommand;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;
import raf.dsw.gerumap.state.State;

import java.awt.*;

public class SettingsState extends State {

    private MapView mapView;

    @Override
    public void misKliknut(int x, int y, MindMap mindMap) {

        SettingsView settingsView = new SettingsView(MainFrame.getInstance(),"Podesavanja",true);
        settingsView.setVisible(true);
        mapView = State.pronadjiMapView(mindMap);
        assert mapView != null;
        for(ElementPainter elementPainter : mapView.getSelektovaniElementi()){


                mapView.postaviElement(elementPainter.getElement());
                AbstractCommands abstractCommands = new SettingsCommand(elementPainter.getElement(),elementPainter.getElement().getName(),
                        elementPainter.getElement().getDebljina(),new Color(elementPainter.getElement().getColour()),settingsView.getName(),settingsView.getDebljina(),settingsView.getColor(),mapView.getSelektovaniElementi(),mapView);
                mindMap.getCommandManager().addCommand(abstractCommands);


        }


    }

    @Override
    public void misPovucen(int x, int y, MindMap mindMap) {

    }

    @Override
    public void misOtpusten(int x, int y, MindMap mindMap) {

    }
}
