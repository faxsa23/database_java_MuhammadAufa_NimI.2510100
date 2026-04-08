package javatutorial;

import java.sql.Connection;
import java.sql.DriverManager;

public class CConnection {
    public Connection cn;

    private String url = "jdbc:mysql://localhost:3306/karyawan_db"; // kalo ngikutin tutorial ga usah di ubah
    private String user = "karyawan_user";    // Sesuaikan sama username MySQL Anda
    private String password = "password123"; // Sesuaikan sama password MySQL Anda

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

   public boolean openConnection() {
    try {
        Class.forName(JDBC_DRIVER);
        cn = DriverManager.getConnection(url, user, password);
        System.out.println("✅ Database Connected!");
        return true;
    } catch (Exception ex) {
        System.err.println("❌ Gagal menghubungkan ke database:");
        ex.printStackTrace();
        cn = null;
        return false;
    }
}

    public Connection getConnection() {
        return cn;
    }

    public void closeConnection() {
        try {
            if (cn != null && !cn.isClosed()) cn.close();
        } catch (Exception ex) {}
    }
}