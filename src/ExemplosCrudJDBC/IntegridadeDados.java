package ExemplosCrudJDBC;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class IntegridadeDados {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DB.getConnection();

            //este comando faz a proteção de integridade, tem que confirmar no final o commit
            conn.setAutoCommit(false);

            st = conn.createStatement();

            int row1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            //fingindo um erro para testar a integridade
            int x = 1;
            if (x < 2) {
                throw new SQLException("Fake error");
            }

            int row2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            System.out.println("rows1 " + row1);
            System.out.println("rows2 " + row2);

        } catch (SQLException e) {
            //Tratativa se caso der erro e não concluir o commit
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back, Causad by: " + e.getMessage());
            } catch (SQLException ex) {
                throw new DbException("Error trying to rollBack Causad by: " + ex.getMessage());
            }
        } finally {
            DB.closeStatement(st);
            DB.closeConnecyion();
        }

    }
}
