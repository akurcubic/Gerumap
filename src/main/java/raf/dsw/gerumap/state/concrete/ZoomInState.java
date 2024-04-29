package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;
import raf.dsw.gerumap.state.State;

public class ZoomInState extends State {

    private MapView mapView;


    @Override
    public void misKliknut(int x, int y, MindMap mindMap) {

        mapView = State.pronadjiMapView(mindMap);
        assert mapView != null;

        mapView.setScaleX(mapView.getScaleX()+0.5);
        mapView.setScaleY(mapView.getScaleY()+0.5);
        if(mapView.getScaleX() > 5 || mapView.getScaleY() > 5){
            mapView.setScaleX(5);
            mapView.setScaleY(5);
        }
        mapView.setupTransformation();
    }

    @Override
    public void misPovucen(int x, int y, MindMap mindMap) {

    }

    @Override
    public void misOtpusten(int x, int y, MindMap mindMap) {

    }
}
