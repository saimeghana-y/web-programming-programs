<html>
<head>
<title>JSP Unregistration</title>
</head>
<body>
<%@ page import="java.sql.*"%>
<%
 String email=request.getParameter("email");
 Class.forName("oracle.jdbc.driver.OracleDriver");
 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1288");
 String query="delete from register where emailid=?";
 PreparedStatement ps=con.prepareStatement(query);
 ps.setString(1,email);
 ps.execute();
 out.println("User deleted:"+email);
 %>

</body>
</html>
















            