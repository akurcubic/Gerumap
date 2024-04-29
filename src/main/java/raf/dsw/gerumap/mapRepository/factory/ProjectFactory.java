package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Project;

public class ProjectFactory extends NodeFactory{

    private static int redniBroj = 1;
    @Override
    public MapNode createNode(MapNode parent) {
        return new Project(parent,"Projekat " + redniBroj++);
    }
}
