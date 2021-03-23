package pruebadbunit;
//~--- JDK imports ------------------------------------------------------------

import java.sql.*;

public class Employee {

    private String employeeUid;
    private String firstName;
    private String lastName;
    private String ssn;
    private String startDate;

    public Employee(String number, String stDate, String Name, String securityNumber,
            String lastName)
            throws Exception {
        if ((number == null) && (lastName == null)) {
            throw new IllegalArgumentException("El número del empleado y el apellido no pueden ser nulos");
        }
        this.employeeUid = number;
        this.startDate = stDate;
        this.firstName = Name;
        this.ssn = securityNumber;
        this.lastName = lastName;
    }

    public String getEmployeeUid() {
        return this.employeeUid;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSsn() {

        return this.ssn;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void InsertEmployee() throws Exception {

    Connection con = null;
        Statement stmt = null;
        String strSentence;


        strSentence = "INSERT INTO employees (employeeUid, startDate, firstName, ssn,lastName) VALUES (\""
                + this.getEmployeeUid() + "\",\"" + this.getStartDate() + "\",\""
                + this.getFirstName() + "\",\""
                + this.getSsn() + "\",\"" + this.getLastName() + "\")";
        try {

            String url = "jdbc:mysql:///hr";

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(url, "root", "password");

            stmt = con.createStatement();

            stmt.executeUpdate(strSentence);
            System.out.println("Los valores se añadieron a la BD");
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
// Una vez ejecutada la consulta se cierra la conexión
//abierta con la instrucción stmt.close()
//
                    stmt.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
