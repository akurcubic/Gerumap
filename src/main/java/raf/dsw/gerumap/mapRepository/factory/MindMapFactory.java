package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;

public class MindMapFactory extends NodeFactory{

    private static int redniBroj = 1;


    @Override
    public MapNode createNode(MapNode parent) {
        return new MindMap(parent,"MindMap " + redniBroj++);
    }
}
