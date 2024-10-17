package JDBC.Demo.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import JDBC.Demo.db.DB;
import JDBC.Demo.db.DbIntegrityException;

/**
 * - Criar DbIntegrityException para evitar falhas de integridade relacional no banco.
 *      - Ex: Apagar o departamento de ID número 2, no qual trabalha a funcionária Maria.
 *            Isso irá gerar erro de integridade, pois a chave extrangeira deixará de existir.
 *
 *  - Tratar a exceção de integridade referencial
 */

public class DeletarDados {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(
                "DELETE FROM department "
                + "WHERE id = ?"
            );

            st.setInt(1,2); //1 é a posição do ? que será substituida e 5 é o ID

            int rowsAffected = st.executeUpdate();
            System.out.println("Done! Rows Affected: " + rowsAffected);
        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}