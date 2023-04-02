package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String driver = "org.postgresql.Driver";
    private static final String url = "jdbc:postgresql://localhost:5432/crud";
    private static final String user = "postgres";
    private static final String password = "postgres";

    /**
     * Cria e retorna uma Conexão com Banco de Dados
     * @return Conexão
     * @throws SQLException
     */
    public static Connection connect() throws SQLException {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
