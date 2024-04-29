package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.painters.ElementPainter;
import raf.dsw.gerumap.gui.swing.painters.PojamPainter;
import raf.dsw.gerumap.gui.swing.painters.VezaPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.mapRepository.commands.AbstractCommands;
import raf.dsw.gerumap.mapRepository.commands.concrete.AddCommand;
import raf.dsw.gerumap.mapRepository.implementation.element.Element;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.element.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.element.Veza;
import raf.dsw.gerumap.state.State;

import java.util.Iterator;

public class AddVezaState extends State {

    private ElementPainter vezaPainter;
    private Veza vezaElement;
    private MapView mapView;
    private boolean flag = false;
    private Pojam pojamOd;
    private Pojam pojamDo;
    private static int redniBroj = 1;

    @Override
    public void misKliknut(int x, int y, MindMap mindMap) {

        vezaElement = new Veza(mindMap,"Veza");
        String naziv = "Veza " + redniBroj++;
        vezaElement.setName(naziv);

        vezaPainter = new VezaPainter(vezaElement);
        mapView = State.pronadjiMapView(mindMap);



        for(ElementPainter elementPainter : mapView.getPainters()){
            if(elementPainter instanceof PojamPainter){
                if(elementPainter.elementAt(x,y)){
                    pojamOd = (Pojam) elementPainter.getElement();
                    flag = true;
                    break;
                }
            }
        }
        if(!flag){
            return;
        }
        vezaElement.setXPocetak(x);
        vezaElement.setYPocetak(y);
        vezaElement.setPojamOd(pojamOd);

    }

    @Override
    public void misPovucen(int x, int y, MindMap mindMap) {

        if(!flag){
            return;
        }
        vezaElement.setXKraj(x);
        vezaElement.setYKraj(y);
        mapView.getPainters().add(vezaPainter);
        mapView.repaint();


    }

    @Override
    public void misOtpusten(int x, int y, MindMap mindMap) {


        flag = false;
        mapView.getPainters().remove(vezaPainter);
        for(ElementPainter elementPainter : mapView.getPainters()){
            if(elementPainter instanceof PojamPainter){
                if(elementPainter.elementAt(x,y)){

                    pojamDo = (Pojam) elementPainter.getElement();
                    flag = true;
                    break;
                }
            }
        }
        if(flag){

            int brojac = 0;
            for(ElementPainter elementPainter : mapView.getPainters()){
                if(elementPainter instanceof VezaPainter){
                    if(elementPainter.getElement().getName().equals(vezaElement.getName())){
                        brojac++;
                    }
                }
            }
            Iterator<ElementPainter> iterator = mapView.getPainters().iterator();
            while(iterator.hasNext() && brojac > 1){
                ElementPainter elementPainter = iterator.next();
                if(elementPainter.getElement().getName().equals(vezaElement.getName())){
                    iterator.remove();
                }
            }
            mapView.repaint();
            vezaElement.setPojamDo(pojamDo);
            mapView.getPainters().add(vezaPainter);

            AbstractCommands abstractCommands = new AddCommand(mindMap,vezaElement);
            mindMap.getCommandManager().addCommand(abstractCommands);

            //mindMap.addChild(vezaElement);


            pojamOd.getVezaPainters().add((VezaPainter) vezaPainter);
            pojamDo.getVezaPainters().add((VezaPainter) vezaPainter);
        }
        else{

            Iterator<ElementPainter> iterator = mapView.getPainters().iterator();
            while(iterator.hasNext()){
                ElementPainter elementPainter = iterator.next();
                if(elementPainter.getElement().getName().equals(vezaElement.getName())){
                    iterator.remove();
                }
            }
            mapView.repaint();
        }

    }
}
