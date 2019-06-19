package klondike.views.console;

import klondike.controllers.*;
import klondike.utils.IO;
import klondike.utils.YesNoDialog;
import klondike.views.View;
import klondike.views.console.menu.PlayMenu;
import klondike.views.console.menu.StartMenu;

public class ConsoleView extends View {

    @Override
    public void interact(AcceptorController acceptorController) {
        acceptorController.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        new StartMenu(startController).execute();
        new GameView(startController).writeln();
    }

    @Override
    public void visit(PlayController playController) {
        new PlayMenu(playController).execute();
        new GameView(playController).writeln();
    }

    @Override
    public void visit(ResumeController resumeController) {
        resumeController.resume(new YesNoDialog().read(Message.RESUME));
    }

    @Override
    public void visit(SaveController saveController) {
        boolean save = new YesNoDialog().read(Message.SAVE);
        String name = null;
        if (save) {
            if (saveController.hasName()) {
                saveController.save();
            } else {
                boolean exists = false;
                do {
                    name = IO.readString(Message.NAME);
                    exists = saveController.exists(name);
                    if (exists) {
                        IO.writeln(Message.NAME_EXISTS);
                    }
                } while (exists);
                saveController.save(name);
            }
        }
        saveController.next();
    }
}
