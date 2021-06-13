<%@page import="com.universal.dto.Question"%>
<%@page import="java.util.List"%>
<%@page import="com.universal.dao.QuestionDao"%>
<%@page import="com.universal.dto.User"%>
<%@include file="../blocks/facheader.jsp" %>
<%
    User user = (User)session.getAttribute("loginuser");
    String name = user.getName();
    int branch = user.getBranch();
    
    QuestionDao qdao = new QuestionDao();
    List<Question> qlist = qdao.listQuestionByBranch(branch);
%>                    
<div class="tm-right-column">
    <figure>
        <img src="<%=ctx%>/assets/img/neaty-01.jpg" alt="Header image" class="img-fluid">    
    </figure>

    <div class="tm-content-div">    
    <section id="welcome" class="tm-section">
        <h1>Welcome <%=name%> Ji !</h1>
        <hr>
        <h1>Student Questions</h1>
        <table class='table table-hover'>
            <tr>
                <th>Student Name</th>
                <th>Question</th>
                <th>Qus Date</th>  
                <th>Give Answer</th>
            </tr>
            
            <%
                for(Question qu : qlist){
            %>
            <tr>
                <td><%=qu.getStudentName() %></td> 
                <td><%=qu.getQus()%></td>
                <td><%=qu.getDate()%></td>
                <td>
                    <form action='<%=ctx%>/saveAnswer' method="post">
                        <input type="hidden" name='qid' value='<%=qu.getQid()%>'>
                        <textarea cols="25" rows="1" name="ans" required></textarea>
                        <br><br>
                        <button type="submit" class='btn btn-warning'>Send</button>
                    </form>
                </td>
            </tr>
            <%}%>
            
            
        </table>    
    </section>
<%@include file="../blocks/footer.jsp" %>