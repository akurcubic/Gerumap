package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.painters.ElementPainter;
import raf.dsw.gerumap.gui.swing.painters.PojamPainter;
import raf.dsw.gerumap.gui.swing.painters.RectangleSelectPainter;
import raf.dsw.gerumap.gui.swing.painters.VezaPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.mapRepository.implementation.element.Element;
import raf.dsw.gerumap.mapRepository.implementation.element.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.element.Veza;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;
import raf.dsw.gerumap.state.State;


import java.util.Iterator;

public class SelectionState extends State {


    private MapView mapView;
    private boolean flag = false;
    private RectangleSelectPainter rectangleSelectPainter;

    @Override
    public void misKliknut(int x, int y, MindMap mindMap) {

        mapView = State.pronadjiMapView(mindMap);
        assert mapView != null;
        mapView.getSelektovaniElementi().clear();
        for(ElementPainter elementPainter : mapView.getPainters()){

            if(elementPainter instanceof PojamPainter){
                PojamPainter pojamPainter = (PojamPainter) elementPainter;
                Element element = pojamPainter.getElement();
                if(pojamPainter.elementAt(x,y)){

                    mapView.getSelektovaniElementi().add(elementPainter);
                    flag = true;
                }
                else{
                    element.bojaZaSelektovaniElement(element);
                }
            }
            else if(elementPainter instanceof VezaPainter){
                VezaPainter vezaPainter = (VezaPainter) elementPainter;
                Element element = vezaPainter.getElement();
                Veza veza = (Veza) element;
                if(isPointOnLine(x,y,veza.getXPocetak(),veza.getYPocetak(),veza.getXKraj(),veza.getYKraj())){
                    mapView.getSelektovaniElementi().add(elementPainter);
                    flag = true;
                }
                else{
                    element.bojaZaSelektovaniElement(element);
                }
            }

        }
        if(!flag){

            Pojam pojam = new Pojam(mindMap,"Select");
            pojam.setName("SelectRectangle");
            rectangleSelectPainter = new RectangleSelectPainter(pojam);
            rectangleSelectPainter.setPocetakX(x);
            rectangleSelectPainter.setPocetakY(y);
        }
        mapView.repaint();
    }

    @Override
    public void misPovucen(int x, int y, MindMap mindMap) {


        if(!flag){
            rectangleSelectPainter.setKrajX(x);
            rectangleSelectPainter.setKrajY(y);
            mapView.getPainters().add(rectangleSelectPainter);
            mapView.repaint();
            for(ElementPainter elementPainter : mapView.getPainters()){
                if(elementPainter instanceof PojamPainter || elementPainter instanceof VezaPainter){
                    if(rectangleSelectPainter.getS().intersects(elementPainter.getS().getBounds2D())){
                        if(!mapView.getSelektovaniElementi().contains(elementPainter)) {
                            mapView.getSelektovaniElementi().add(elementPainter);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void misOtpusten(int x, int y, MindMap mindMap) {

        if(!flag){
            rectangleSelectPainter.setKrajX(x);
            rectangleSelectPainter.setKrajY(y);
            Iterator<ElementPainter> iterator = mapView.getPainters().iterator();
            while(iterator.hasNext()) {

                ElementPainter elementPainter = iterator.next();
                if (elementPainter.getElement().getName().equals("SelectRectangle")) {
                        iterator.remove();
                }
            }
            mapView.repaint();
        }
        flag = false;

    }

    public boolean isPointOnLine(int x, int y, int x1, int y1, int x2, int y2) {
        double distance = Math.abs((y2 - y1) * x - (x2 - x1) * y + x2 * y1 - y2 * x1) / Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
        double tolerance = 1.0;
        return distance < tolerance;
    }

}
