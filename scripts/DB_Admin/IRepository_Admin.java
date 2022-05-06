package DB_Admin;
import Models.Admin;
import java.sql.SQLException;

public interface IRepository_Admin {
    void open() throws SQLException;
    void close() throws SQLException;

    boolean insertAdmin(Admin admin) throws SQLException;
    Admin getAdminByUsercode(int usercode) throws SQLException;
}
