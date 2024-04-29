package raf.dsw.gerumap.mapRepository.composite;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public abstract class MapNodeComposite extends MapNode{

    protected List<MapNode> children;

    public MapNodeComposite(MapNode parent, String name) {
        super(name, parent);
        this.children = new ArrayList<>();
    }


    public abstract void addChild(MapNode child);
    public abstract void deleteChild(MapNode child);
}
