package raf.dsw.gerumap.state;

import lombok.Getter;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;

@Getter

public abstract class State {

    public static int redniBroj = 1;


    public abstract void misKliknut(int x, int y, MindMap mindMap);
    public abstract void misPovucen(int x,int y,MindMap mindMap);
    public abstract  void misOtpusten(int x,int y,MindMap mindMap);

    public static MapView pronadjiMapView(MindMap mindMap){

        MapView mapView = null;
        for(MapView mw : MainFrame.getInstance().getProjectView().getMaps()){
            if(mw.getName().equals(mindMap.getName())){
                mapView = mw;
                return mapView;
            }
        }
        return null;
    }

}
