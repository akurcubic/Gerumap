package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.painters.ElementPainter;
import raf.dsw.gerumap.gui.swing.painters.PojamPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.mapRepository.commands.AbstractCommands;
import raf.dsw.gerumap.mapRepository.commands.concrete.AddCommand;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.element.Element;
import raf.dsw.gerumap.mapRepository.implementation.element.Pojam;
import raf.dsw.gerumap.state.State;

import javax.swing.*;


public class AddPojamState extends State {

private static int redniBroj = 1;

    @Override
    public void misKliknut(int x, int y, MindMap mindMap) {

        String name = JOptionPane.showInputDialog("Unesite naziv elementa");

        Pojam element = new Pojam(mindMap,"Pojam ",x,y,100,60);
        String naziv = "Pojam " + redniBroj++;
        if(name.isEmpty())
            element.setName(naziv);
        else {
            if(name.length() > 10 && name.length() < 15){
                element.setW(120);
                element.setH(70);
            }
            else if(name.length() < 5){
                element.setW(60);
                element.setH(40);
            }
            else{
                element.setW(140);
                element.setH(70);
            }
            element.setName(name);
        }


        AbstractCommands abstractCommands = new AddCommand(mindMap,element);
        mindMap.getCommandManager().addCommand(abstractCommands);


    }

    @Override
    public void misPovucen(int x, int y, MindMap mindMap) {

    }

    @Override
    public void misOtpusten(int x, int y, MindMap mindMap) {

    }
}
