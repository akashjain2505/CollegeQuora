<%@page import="com.universal.dao.AnswerDao"%>
<%@page import="com.universal.dto.Answer"%>
<%@page import="java.util.List"%>
<%@page import="com.universal.dao.QuestionDao"%>
<%@include file="../blocks/studheader.jsp" %>
<%
    int qid = Integer.parseInt(request.getParameter("qus"));
    
    String qusName = new QuestionDao().getQuestionName(qid);
    
    List<Answer> list = new AnswerDao().listAnswer(qid);
%>

<div class="tm-right-column">
    <figure>
        <img src="<%=ctx%>/assets/img/neaty-01.jpg" alt="Header image" class="img-fluid">    
    </figure>

    <div class="tm-content-div">    
    <section id="welcome" class="tm-section">
        <h1>Question : <%=qusName%></h1>
        <hr>
        <table class='table table-hover'>
            <tr>
                <th>Answer</th>
                <th>Ans Date</th> 
                <th>Faculty</th>
            </tr>
            
            <%
                for(Answer ans : list) {
            %>
                 <tr>
                <th><%=ans.getAns()%></th>
                <th><%=ans.getAnsDate()%></th> 
                <th><%=ans.getFacultyName()%></th>
            </tr>
            <%}%>
        </table>
    </section>
    </div>
</div>
<%@include file="../blocks/footer.jsp" %>
