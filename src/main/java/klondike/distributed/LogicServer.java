package klondike.distributed;

import klondike.controllers.Logic;
import klondike.distributed.dispatchers.*;

public class LogicServer extends Logic {

    public LogicServer(boolean isStandalone) {
        super(isStandalone);
    }

    public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
        dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startController));
        dispatcherPrototype.add(FrameType.NEW_GAME, new ResumeDispatcher(this.resumeController));
        dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playController));

        dispatcherPrototype.add(FrameType.MOVEFROMFOUNDATIONTOPILE, new MoveFromFoundationToPileDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.MOVEFROMPILETOFOUNDATION, new MoveFromPileToFoundationDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.MOVEFROMPILETOPILE, new MoveFromPileToPileDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.MOVEFROMSTOCKTOWASTE, new MoveFromStockToWasteDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.MOVEFROMWASTETOFOUNDATION, new MoveFromWasteToFoundationDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.MOVEFROMWASTETOPILE, new MoveFromWasteToPileDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.MOVEFROMWASTETOSTOCK, new MoveFromWasteToStockDispatcher(this.playController));

        dispatcherPrototype.add(FrameType.PEEKSTOCK, new PeekStockDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.PEEKWASTE, new PeekWasteDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.PEEKFOUNDATION, new PeekFoundationDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.GETPILECARDS, new GetPileCardsDispatcher(this.playController));
        dispatcherPrototype.add(FrameType.GETNUMBEROFFACEDUPCARDSINPILE, new GetNumberOfFacedUpCardsInPileDispatcher(this.playController));
    }
}
