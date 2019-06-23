package klondike.distributed;

import klondike.controllers.implementation.LogicImplementation;
import klondike.distributed.dispatchers.*;

public class LogicImplementationServer extends LogicImplementation {

    public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
        dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.NEW_GAME, new ResumeDispatcher(this.resumeControllerImplementation));
        dispatcherPrototype.add(FrameType.STARTNAME, new StartNameDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.TITLES, new TitlesDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playControllerImplementation));

        dispatcherPrototype.add(FrameType.MOVEFROMFOUNDATIONTOPILE, new MoveFromFoundationToPileDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.MOVEFROMPILETOFOUNDATION, new MoveFromPileToFoundationDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.MOVEFROMPILETOPILE, new MoveFromPileToPileDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.MOVEFROMSTOCKTOWASTE, new MoveFromStockToWasteDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.MOVEFROMWASTETOFOUNDATION, new MoveFromWasteToFoundationDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.MOVEFROMWASTETOPILE, new MoveFromWasteToPileDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.MOVEFROMWASTETOSTOCK, new MoveFromWasteToStockDispatcher(this.playControllerImplementation));

        dispatcherPrototype.add(FrameType.PEEKSTOCK, new PeekStockDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.PEEKWASTE, new PeekWasteDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.PEEKFOUNDATION, new PeekFoundationDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.GETPILECARDS, new GetPileCardsDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.GETNUMBEROFFACEDUPCARDSINPILE, new GetNumberOfFacedUpCardsInPileDispatcher(this.playControllerImplementation));

        dispatcherPrototype.add(FrameType.NEXT, new NextDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.SAVE, new SaveDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.SAVENAMED, new SaveNamedDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.HASNAME, new HasNameDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.EXISTS, new ExistsDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.GETTITLE, new GetTitleDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.SETTITLE, new SetTitleDispatcher(this.saveControllerImplementation));

    }
}
