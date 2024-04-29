package raf.dsw.gerumap.state.concrete;
import raf.dsw.gerumap.gui.swing.painters.ElementPainter;
import raf.dsw.gerumap.gui.swing.painters.PojamPainter;
import raf.dsw.gerumap.gui.swing.painters.VezaPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.mapRepository.commands.AbstractCommands;
import raf.dsw.gerumap.mapRepository.commands.concrete.MoveCommand;
import raf.dsw.gerumap.mapRepository.implementation.element.Element;
import raf.dsw.gerumap.mapRepository.implementation.element.Veza;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.element.Pojam;
import raf.dsw.gerumap.state.State;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class MoveElementState extends State {

    private boolean flagPojam = false;
    private Pojam pojam = null;

    private MapView mapView;
    private HashMap<Element, Point> pomeraji = new HashMap<>();
    private HashMap<Veza, Point> pomerajKrajVeze = new HashMap<>();
    private int noviX;
    private int noviY;
    private int noviXKraj;
    private int noviYKraj;
    private Veza veza;
    private Point point1;
    private int stariX;
    private int stariY;



    @Override
    public void misKliknut(int x, int y, MindMap mindMap) {


        mapView = State.pronadjiMapView(mindMap);


        assert mapView != null;

        if(!mapView.getSelektovaniElementi().isEmpty()){
            for(ElementPainter elementPainter : mapView.getSelektovaniElementi()){
                if(elementPainter instanceof PojamPainter){
                    Pojam pojam1 = (Pojam) elementPainter.getElement();
                    pomeraji.put(pojam1,new Point(Math.abs(x - pojam1.getX()), Math.abs(y - pojam1.getY())));
                }
                else if(elementPainter instanceof VezaPainter){
                    Veza veza1 = (Veza) elementPainter.getElement();
                    pomeraji.put(veza1,new Point(Math.abs(x - veza1.getXPocetak()), Math.abs(y - veza1.getYPocetak())));
                    pomerajKrajVeze.put(veza1,new Point(Math.abs(x - veza1.getXKraj()), Math.abs(y - veza1.getYKraj())));
                }
            }
        }
        else {
            for (ElementPainter elementPainter : mapView.getPainters()) {
                if (elementPainter instanceof PojamPainter) {
                    PojamPainter pojamPainter = (PojamPainter) elementPainter;
                    pojam = (Pojam) pojamPainter.getElement();
                    stariX = pojam.getX();
                    stariY = pojam.getY();
                    if (pojamPainter.elementAt(x, y)) {
                        flagPojam = true;
                        mapView.postaviElement(pojam);
                        break;
                    }
                }
            }
        }

    }


    @Override
    public void misPovucen(int x, int y, MindMap mindMap) {

        if(!mapView.getSelektovaniElementi().isEmpty()){

            for(Map.Entry<Element, Point> entry : pomeraji.entrySet()){
                Element element = entry.getKey();
                if(element instanceof Pojam){

                    Pojam pojam1 = (Pojam) entry.getKey();
                    Point point = entry.getValue();

                    if(x > pojam1.getX() && y < pojam1.getY()){
                        noviX = x - point.x;
                        noviY = y + point.y;
                    }
                    else if(x < pojam1.getX() && y < pojam1.getY()){
                        noviX = x + point.x;
                        noviY = y + point.y;
                    }
                    else if(x > pojam1.getX() && y > pojam1.getY()){
                        noviX = x - point.x;
                        noviY = y - point.y;
                    }
                    else{
                        noviX = x + point.x;
                        noviY = y - point.y;
                    }
                    mapView.repaint();
                    pojam1.noveKoordinate(pojam1,noviX,noviY);
                }
                else if(element instanceof Veza){
                    Veza veza1 = (Veza) entry.getKey();
                    Point point = entry.getValue();

                    for(Map.Entry<Veza,Point> entry1 : pomerajKrajVeze.entrySet()){
                        veza = entry1.getKey();

                        if(veza.equals(veza1)){
                            veza = veza1;
                            point1 = pomerajKrajVeze.get(veza);
                        }
                    }

                    if(x > veza1.getXPocetak() && y < veza1.getYPocetak()){
                        noviX = x - point.x;
                        noviY = y + point.y;
                    }
                    else if(x < veza1.getXPocetak() && y < veza1.getYPocetak()){
                        noviX = x + point.x;
                        noviY = y + point.y;
                    }
                    else if(x > veza1.getXPocetak() && y > veza1.getYPocetak()){
                        noviX = x - point.x;
                        noviY = y - point.y;
                    }
                    else{
                        noviX = x + point.x;
                        noviY = y - point.y;
                    }

                    if(x > veza.getXKraj() && y < veza.getYKraj()){
                        noviXKraj = x - point1.x;
                        noviYKraj = y + point1.y;
                    }
                    else if(x < veza.getXKraj() && y < veza.getYKraj()){
                        noviXKraj = x + point1.x;
                        noviYKraj = y + point1.y;
                    }
                    else if(x > veza.getXKraj() && y > veza.getYKraj()){
                        noviXKraj = x - point1.x;
                        noviYKraj = y - point1.y;
                    }
                    else{
                        noviXKraj = x + point1.x;
                        noviYKraj = y - point1.y;
                    }
                    mapView.repaint();
                    mapView.postaviElement(veza);
                    veza1.noveKoordinateVeze(veza,noviX,noviY,noviXKraj,noviYKraj);
                }
            }

        }
        else {

            if (!flagPojam) {
                return;
            }
            pojam.noveKoordinate(pojam, x, y);
        }


    }

    @Override
    public void misOtpusten(int x, int y, MindMap mindMap) {


        if(!mapView.getSelektovaniElementi().isEmpty()){

            for(Map.Entry<Element, Point> entry : pomeraji.entrySet()){
                Element element = entry.getKey();
                if(element instanceof Pojam){
                    Pojam pojam1 = (Pojam) entry.getKey();
                    Point point = entry.getValue();

                    if(x > pojam1.getX() && y < pojam1.getY()){
                        noviX = x - point.x;
                        noviY = y + point.y;
                    }
                    else if(x < pojam1.getX() && y < pojam1.getY()){
                        noviX = x + point.x;
                        noviY = y + point.y;
                    }
                    else if(x > pojam1.getX() && y > pojam1.getY()){
                        noviX = x - point.x;
                        noviY = y - point.y;
                    }
                    else{
                        noviX = x + point.x;
                        noviY = y - point.y;
                    }


                    pojam1.noveKoordinate(pojam1,noviX,noviY);
                }
                else if(element instanceof Veza){
                    Veza veza1 = (Veza) entry.getKey();
                    Point point = entry.getValue();
                    for(Map.Entry<Veza,Point> entry1 : pomerajKrajVeze.entrySet()){
                        veza = entry1.getKey();

                        if(veza.getName().equals(veza1.getName())){
                            veza = veza1;
                            point1 = pomerajKrajVeze.get(veza);
                        }
                    }

                    if(x > veza1.getXPocetak() && y < veza1.getYPocetak()){
                        noviX = x - point.x;
                        noviY = y + point.y;
                    }
                    else if(x < veza1.getXPocetak() && y < veza1.getYPocetak()){
                        noviX = x + point.x;
                        noviY = y + point.y;
                    }
                    else if(x > veza1.getXPocetak() && y > veza1.getYPocetak()){
                        noviX = x - point.x;
                        noviY = y - point.y;
                    }
                    else{
                        noviX = x + point.x;
                        noviY = y - point.y;
                    }

                    if(x > veza.getXKraj() && y < veza.getYKraj()){
                        noviXKraj = x - point1.x;
                        noviYKraj = y + point1.y;
                    }
                    else if(x < veza.getXKraj() && y < veza.getYKraj()){
                        noviXKraj = x + point1.x;
                        noviYKraj = y + point1.y;
                    }
                    else if(x > veza.getXKraj() && y > veza.getYKraj()){
                        noviXKraj = x - point1.x;
                        noviYKraj = y - point1.y;
                    }
                    else{
                        noviXKraj = x + point1.x;
                        noviYKraj = y - point1.y;
                    }
                    mapView.setElement(veza);
                    veza1.noveKoordinateVeze(veza,noviX,noviY,noviXKraj,noviYKraj);
                }
            }

        }

        else {
            if (!flagPojam) {
                return;
            }
            AbstractCommands abstractCommands = new MoveCommand(pojam,x,y,noviX,noviY,noviXKraj,noviYKraj,stariX,stariY);
            mindMap.getCommandManager().addCommand(abstractCommands);

        }

    }


}
