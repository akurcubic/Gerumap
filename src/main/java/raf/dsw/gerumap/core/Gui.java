package raf.dsw.gerumap.core;

import raf.dsw.gerumap.observer.ISubscriber;

public interface Gui extends ISubscriber {

    void start();

    void disableUndoAction();
    void disableRedoAction();

    void enableUndoAction();
    void enableRedoAction();
}
