package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;

public abstract class NodeFactory {

    public MapNode getNode(MapNode parent){

        MapNode mapNode;
        mapNode = createNode(parent);
        return mapNode;
    }

    public abstract MapNode createNode(MapNode parent);

}
