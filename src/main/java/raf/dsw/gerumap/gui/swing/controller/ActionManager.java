package raf.dsw.gerumap.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.controller.actions.*;


public class ActionManager {

@Getter
@Setter

    private NewAction newAction;
    private InfoAction infoAction;
    private DeleteAction deleteAction;
    private SetAutorAction setAutorAction;
    private AddPojamAction addPojamAction;
    private AddVezaAction addVezaAction;
    private DeleteElementAction deleteElementAction;
    private MoveAction moveAction;
    private SettingsAction settingsAction;
    private ZoomInAction zoomInAction;
    private ZoomOutAction zoomOutAction;
    private SelectAction selectAction;
    private UndoAction undoAction;
    private RedoAction redoAction;
    private SavePngAction savePngAction;

    public ActionManager(){

        this.init();
    }

    private void init(){

        newAction = new NewAction();
        infoAction = new InfoAction();
        deleteAction = new DeleteAction();
        setAutorAction = new SetAutorAction();
        addPojamAction = new AddPojamAction();
        addVezaAction = new AddVezaAction();
        deleteElementAction = new DeleteElementAction();
        moveAction = new MoveAction();
        settingsAction = new SettingsAction();
        zoomInAction = new ZoomInAction();
        zoomOutAction = new ZoomOutAction();
        selectAction = new SelectAction();
        undoAction = new UndoAction();
        redoAction = new RedoAction();
        savePngAction = new SavePngAction();
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public SetAutorAction getSetAutorAction() {
        return setAutorAction;
    }

    public AddPojamAction getAddPojamAction() {
        return addPojamAction;
    }

    public AddVezaAction getAddVezaAction() {
        return addVezaAction;
    }

    public DeleteElementAction getDeleteElementAction() {
        return deleteElementAction;
    }

    public MoveAction getMoveAction() {
        return moveAction;
    }

    public SettingsAction getSettingsAction() {
        return settingsAction;
    }

    public ZoomInAction getZoomInAction() {
        return zoomInAction;
    }

    public ZoomOutAction getZoomOutAction() {
        return zoomOutAction;
    }

    public SelectAction getSelectAction() {
        return selectAction;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public SavePngAction getSavePngAction() {
        return savePngAction;
    }
}

