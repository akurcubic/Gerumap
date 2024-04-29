package raf.dsw.gerumap.mapRepository.implementation;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;

public class ProjectExplorer extends MapNodeComposite {

    public ProjectExplorer(String name) {
        super(null, name);
    }

    @Override
    public void addChild(MapNode child) {
        if(child instanceof Project){
            this.children.add(child);
        }
    }

    @Override
    public void deleteChild(MapNode child) {
        if(child instanceof Project){
            this.children.remove(child);
        }
    }
}
