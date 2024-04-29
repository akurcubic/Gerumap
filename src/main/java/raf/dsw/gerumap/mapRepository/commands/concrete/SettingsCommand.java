package raf.dsw.gerumap.mapRepository.commands.concrete;

import raf.dsw.gerumap.gui.swing.painters.ElementPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.mapRepository.commands.AbstractCommands;
import raf.dsw.gerumap.mapRepository.implementation.element.Element;

import java.awt.*;
import java.util.List;

public class SettingsCommand extends AbstractCommands {

    private Element element;
    private String oldName;
    private int oldDebljina;
    private Color oldColour;
    private String newIme;
    private int newDebljina;
    private Color newColour;
    private MapView mapView;
    private List<ElementPainter> selektovani;


    public SettingsCommand(Element element, String oldName, int oldDebljina, Color oldColour, String newIme, int newDebljina, Color newColour, List<ElementPainter> selektovani, MapView mapView) {
        this.element = element;
        this.oldName = oldName;
        this.oldDebljina = oldDebljina;
        this.oldColour = oldColour;
        this.newIme = newIme;
        this.newDebljina = newDebljina;
        this.newColour = newColour;
        this.selektovani = selektovani;
        this.mapView = mapView;


    }


    @Override
    public void doCommand() {


        element.promenaElementa(newIme,newDebljina,newColour,element);




    }

    @Override
    public void undoCommand() {

        element.promenaElementa(oldName,oldDebljina,oldColour,element);




    }
}
