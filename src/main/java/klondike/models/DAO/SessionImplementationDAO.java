package klondike.models.DAO;

import klondike.models.SessionImplementation;
import klondike.models.StateValue;
import klondike.utils.IO;

import java.io.*;

public class SessionImplementationDAO{

    public static final String EXTENSION = ".klond";

    public static final String DIRECTORY = System.getProperty("user.dir") + "/partidas";

    private static File directory;

    static {
        SessionImplementationDAO.directory = new File(SessionImplementationDAO.DIRECTORY);
        if (!SessionImplementationDAO.directory.exists()) {
            SessionImplementationDAO.directory.mkdir();
        }
    }

    private final SessionImplementation sessionImplementation;

    private final GameDAO gameDAO;

    public SessionImplementationDAO(SessionImplementation sessionImplementation){
        this.sessionImplementation = sessionImplementation;
        this.gameDAO = new GameDAO(sessionImplementation.getGame());
    }

    public void save() {
        this.save(this.sessionImplementation.getName());
    }

    public void save(String name) {
        if (!name.endsWith(SessionImplementationDAO.EXTENSION)) {
            name = name + SessionImplementationDAO.EXTENSION;
        }
        File file = new File(SessionImplementationDAO.directory, name);
        try {
            FileWriter fileWriter = new FileWriter(file);
            this.gameDAO.save(fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void load(String name) {
        this.sessionImplementation.setName(name);
        File file = new File(SessionImplementationDAO.directory, name);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            this.gameDAO.load(bufferedReader);
            this.sessionImplementation.resetRegistry();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sessionImplementation.setStateValue(StateValue.IN_GAME);
        if (this.sessionImplementation.isGameFinished()) {
            this.sessionImplementation.setStateValue(StateValue.FINAL);
        }
    }

    public String[] getGamesNames() {
        return SessionImplementationDAO.directory.list();
    }

    public boolean exists(String name) {
        for (String auxName : this.getGamesNames()) {
            if (auxName.equals(name + SessionImplementationDAO.EXTENSION)) {
                return true;
            }
        }
        return false;
    }
}
