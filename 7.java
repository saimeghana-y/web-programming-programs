import java.sql.*;
import java.util.*;
class test
{
	public static void main(String ar[]) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Rollnumber:");
		int r=sc.nextInt();
  		CallableStatement cs=con.prepareCall("{call data(?,?)}");
  		cs.setInt(1,r);
   		cs.registerOutParameter(2,Types.INTEGER);
		cs.execute();
		System.out.print("Mobile Number is ");
		System.out.println(cs.getInt(2));
		sc.close();	
	}
}


// Data Procedure Creation: 

//   1  create or replace procedure data(rno in number,mobno out number)
//   2  is
//   3  begin
//   4  select mobileno into mobno from student1 where rollno=rno;
//   5  commit;
//   6  end;
//   7  /