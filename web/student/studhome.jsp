<%@page import="com.universal.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="com.universal.dao.UserDao"%>
<%@include file="../blocks/studheader.jsp" %>

<%
    UserDao udao = new UserDao();
    List<User> users = udao.listFaculty();
    
    User luser = (User)session.getAttribute("loginuser");
    String name = luser.getName();
%>

<div class="tm-right-column">
    <figure>
        <img src="<%=ctx%>/assets/img/neaty-01.jpg" alt="Header image" class="img-fluid">    
    </figure>

    <div class="tm-content-div">    
    <section id="welcome" class="tm-section">
        <h1>Welcome <%=name%> !</h1>
        <hr>
        
        <%
            if(users.size()>0)
            {
        %>
        
        <table class='table table-hover'>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Branch</th>
            </tr>
            
            <%
                for (User user : users)
                {
            %>    
                <tr>
                <th><%=user.getName()%></th>
                <th><%=user.getMail()%></th>
                <th><%=user.getPhone()%></th>
                <th><%=user.getBranch()%></th>
                </tr> 
            <%    
                }
            %>
            
        </table>
            <% } else 
            {
                    out.println("<h2>No One Faculty Registered Till Yet !</h2>");
            }%>
    </section>
<%@include file="../blocks/footer.jsp" %>