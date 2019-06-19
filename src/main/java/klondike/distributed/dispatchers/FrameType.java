package klondike.distributed.dispatchers;

public enum FrameType {
    START,
    STATE,
    UNDO,
    REDO,
    UNDOABLE,
    REDOABLE,
    NEW_GAME,
    CLOSE,
    MOVEFROMFOUNDATIONTOPILE,
    MOVEFROMPILETOFOUNDATION,
    MOVEFROMPILETOPILE,
    MOVEFROMSTOCKTOWASTE,
    MOVEFROMWASTETOFOUNDATION,
    MOVEFROMWASTETOPILE,
    MOVEFROMWASTETOSTOCK,
    PEEKSTOCK,
    PEEKWASTE,
    PEEKFOUNDATION,
    GETPILECARDS,
    GETNUMBEROFFACEDUPCARDSINPILE,
    ISGAMEFINISHED,
    GETTITLE,
    SETTITLE,
    STARTNAME,
    TITLES,
    SAVE,
    SAVENAMED,
    NEXT,
    HASNAME,
    EXISTS;


    public static FrameType parser(String string) {
        for (FrameType frameType : FrameType.values()) {
            if (frameType.name().equals(string)) {
                return frameType;
            }
        }
        return null;
    }
}
