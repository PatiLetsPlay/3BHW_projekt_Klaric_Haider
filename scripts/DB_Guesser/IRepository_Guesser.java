package DB_Guesser;
import Models.*;
import java.sql.SQLException;

public interface IRepository_Guesser {
    void open() throws SQLException;
    void close() throws SQLException;

    boolean insertGuesser(Guesser guesser) throws SQLException;
}
