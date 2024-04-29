package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.painters.ElementPainter;
import raf.dsw.gerumap.gui.swing.painters.PojamPainter;
import raf.dsw.gerumap.gui.swing.painters.VezaPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.mapRepository.commands.AbstractCommands;
import raf.dsw.gerumap.mapRepository.commands.concrete.DeleteCommand;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.element.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.element.Veza;
import raf.dsw.gerumap.state.State;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeleteElementState extends State {


    @Override
    public void misKliknut(int x, int y, MindMap mindMap) {

        List<VezaPainter> lista = new ArrayList<>();

        MapView mapView = State.pronadjiMapView(mindMap);
        Iterator<ElementPainter> iterator = mapView.getPainters().iterator();
        try {
            while (iterator.hasNext()) {

                ElementPainter elementPainter = iterator.next();
                if (elementPainter instanceof VezaPainter) {

                    VezaPainter vezaPainter = (VezaPainter) elementPainter;
                    Veza veza = (Veza) vezaPainter.getElement();
                    if (isPointOnLine(x, y, veza.getXPocetak(), veza.getYPocetak(), veza.getXKraj(), veza.getYKraj())) {

                        iterator.remove();

                        AbstractCommands abstractCommands = new DeleteCommand(mindMap, elementPainter.getElement(), lista, mapView.getPainters());
                        mindMap.getCommandManager().addCommand(abstractCommands);

                        mindMap.deleteChild(elementPainter.getElement());
                        break;
                    }
                } else if (elementPainter instanceof PojamPainter) {
                    PojamPainter pojamPainter = (PojamPainter) elementPainter;
                    Pojam pojam = (Pojam) elementPainter.getElement();
                    if (pojamPainter.elementAt(x, y)) {

                        lista.addAll(pojam.getVezaPainters());
                        iterator.remove();

                        AbstractCommands abstractCommands = new DeleteCommand(mindMap, elementPainter.getElement(), lista, mapView.getPainters());
                        mindMap.getCommandManager().addCommand(abstractCommands);

                    }
                }
            }
        }catch (Exception e){

        }

        if(!lista.isEmpty()){
            for(VezaPainter vezaPainter : lista){
                mapView.getPainters().remove(vezaPainter);
                mindMap.deleteChild(vezaPainter.getElement());
            }
        }
    }

    @Override
    public void misPovucen(int x, int y, MindMap mindMap) {

    }

    @Override
    public void misOtpusten(int x, int y, MindMap mindMap) {

    }

    public boolean isPointOnLine(int x, int y, int x1, int y1, int x2, int y2) {
        double distance = Math.abs((y2 - y1) * x - (x2 - x1) * y + x2 * y1 - y2 * x1) / Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
        double tolerance = 1.0;
        return distance < tolerance;
    }
}
