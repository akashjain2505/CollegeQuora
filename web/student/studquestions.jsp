<%@page import="com.universal.dto.User"%>
<%@page import="com.universal.dto.Question"%>
<%@page import="java.util.List"%>
<%@page import="com.universal.dao.QuestionDao"%>
<%@include file="../blocks/studheader.jsp" %>

<%
    User user = (User)session.getAttribute("loginuser");
    QuestionDao qdao = new QuestionDao();
    List<Question> list = qdao.listQuestion(user.getUserId());
%>
<div class="tm-right-column">
    <figure>
        <img src="<%=ctx%>/assets/img/neaty-01.jpg" alt="Header image" class="img-fluid">    
    </figure>

    <div class="tm-content-div">    
    <section id="welcome" class="tm-section">
        <h1>Ask Question ?</h1>
        <hr>
        <form action="<%=ctx%>/sendquestion" method="post">
            <textarea name="qus" class='form-control' cols="30" rows="3" required></textarea>
            <br>
            <button type='submit' class='btn btn-success'>Send It</button>
        </form>
        
        
        <hr>
        <h1>Old Ask Questions</h1>
        <table class='table table-hover'>
            <tr>
                <th>Question</th>
                <th>Qus Date</th> 
                <th>See Answer</th>
            </tr>
            
            <%
                for(Question qu : list){
            %>
            <tr>
                <td><%=qu.getQus()%></td>
                <td><%=qu.getDate()%></td>
                <th>
                    <a href='<%=ctx%>/student/viewanswer.jsp?qus=<%=qu.getQid()%>'><b class='btn btn-info'>View</b></a>
                </th>
            </tr>
            <%}%>
            
            
        </table>        
    </section>
<%@include file="../blocks/footer.jsp" %>