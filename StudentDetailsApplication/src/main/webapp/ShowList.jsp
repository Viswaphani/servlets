<%@ page import="java.util.*" %>
<%@ page import="com.student.model.Student" %>
<html>
<body>
<h1 align="center">Student List</h1>
<p>
<%
 List<Student> studentList = (List)request.getAttribute("StudentList");
 Iterator<Student> it = studentList.iterator();
 while(it.hasNext()) {
	 Student st = it.next();
	 out.print("<br>name : " + st.getName() + " Id : " + st.getId() + " marks : " + st.getMarks() 
	 			+ " city : " + st.getCity());
 }
%>
<br>
  <a href="OperationsMenu.html">
    <button>Back to Main Menu</button>
  </a> 
</body>
</html>