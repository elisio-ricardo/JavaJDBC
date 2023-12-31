package ExemplosCrudJDBC;

import db.DB;
import db.DbException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AtualizarDados {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;

        try {

            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "UPDATE seller "
                            + "SET BaseSalary = BaseSalary + ? "
                            + "Where "
                            + "(DepartmentId = ?)");
            st.setDouble(1, 200.0);
            st.setInt(2, 2);

            int rowAffected = st.executeUpdate();
            System.out.println("Done " + rowAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnecyion();
        }
    }
}
