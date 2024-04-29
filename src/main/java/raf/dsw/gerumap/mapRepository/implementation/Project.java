package raf.dsw.gerumap.mapRepository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;
import raf.dsw.gerumap.observer.TipNotifikacije;

@Getter
@Setter

public class Project extends MapNodeComposite {

    private String autor;

    public Project(MapNode parent, String name) {
        super(parent, name);
    }

    @Override
    public void addChild(MapNode child) {
        if(child instanceof MindMap){
            this.children.add(child);
            this.notify(child, TipNotifikacije.DODAVANJE_MAPE);
        }
    }

    @Override
    public void deleteChild(MapNode child) {
        if(child instanceof MindMap){
            this.children.remove(child);
            this.notify(child, TipNotifikacije.BRISANJE_MAPE);
        }
    }

    public void setAutor(String autor) {
        this.autor = autor;
        this.notify(autor, TipNotifikacije.SET_AUTOR);
    }

    public void postaviImeProjekta(String name){

        this.setName(name);
        notify(name, TipNotifikacije.SET_IME);
    }
}
