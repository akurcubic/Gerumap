package raf.dsw.gerumap.mapRepository.implementation.mindMap;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.commands.CommandManager;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.mapRepository.implementation.element.Element;
import raf.dsw.gerumap.observer.TipNotifikacije;

@Getter
@Setter

public class MindMap extends MapNodeComposite {

    private boolean template = false;
    private CommandManager commandManager;

    public MindMap(MapNode parent, String name) {
        super(parent, name);
        commandManager = new CommandManager();
    }

    @Override
    public void addChild(MapNode child) {
        if(child instanceof Element){
            this.children.add(child);
            this.notify(child, TipNotifikacije.DODAT_NOVI_ELEMENT_U_MAPU);
        }
    }

    @Override
    public void deleteChild(MapNode child) {
        if(child instanceof Element){
            this.children.remove(child);
            this.notify(child,TipNotifikacije.IZBRISAN_ELEMENT_IZ_MAPE);
        }
    }
}
