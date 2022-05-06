package DB_Guesser;
import Models.*;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IRepository_Guesser {
    void open() throws SQLException;
    void close() throws SQLException;

    boolean insertGuesser(Guesser guesser) throws SQLException;

    public List<Guesser> getScoreFromPlayerFnLn(String firstname, String lastname) throws SQLException;
    public List<Guesser> getScoreFromAll() throws SQLException;
}
