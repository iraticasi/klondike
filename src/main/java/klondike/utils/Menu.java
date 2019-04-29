package klondike.utils;

import java.util.ArrayList;

public abstract class Menu {

    private static final String OPTION = "------Choose an option-----";
    private ArrayList<Command> commandList;

    public Menu() {
        this.commandList = new ArrayList<Command>();
    }

    public void execute() {
        ArrayList<Command> commands = new ArrayList<Command>();
        for (int i = 0; i < this.commandList.size(); i++) {
            commands.add(this.commandList.get(i));
        }
        boolean error;
        int option;
        do {
            error = false;
            IO.writeln();
            IO.writeln(OPTION);
            for (int i = 0; i < commands.size(); i++) {
                IO.writeln((i + 1) + ") " + commands.get(i).getTitle());
            }
            option = IO.readInt("") - 1;
            if (!new ClosedInterval(0, commands.size() - 1).includes(option)) {
                error = true;
            }
        } while (error);
        commands.get(option).execute();
    }

    protected void addCommand(Command command) {
        this.commandList.add(command);
    }

}
