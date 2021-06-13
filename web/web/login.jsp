<%@include file="../blocks/header.jsp" %>

<%
    Cookie ck[] = request.getCookies();
    String email="";
    String pass ="";
    if(ck!=null)
    {
    for(Cookie c : ck)
    {
        if(c.getName().equals("cqmail"))
        {
            email=c.getValue();
        }
        if(c.getName().equals("cqpass"))
        {
            pass=c.getValue();
        }
    }
    }
%>

<div class="tm-right-column">
    <figure>
        <img src="<%=ctx%>/assets/img/neaty-01.jpg" alt="Header image" class="img-fluid">    
    </figure>

    <div class="tm-content-div">
                            <!-- Welcome section -->
                            <h1>User Login</h1>
                            <hr>
        <form action="<%=ctx%>/loginuser" method="post">
            <input type="email" value="<%=email%>" class='form-control' name="email" placeholder="Your Email" required>        
            <br>
            <input type="password" value="<%=pass%>" class='form-control' name="pass" placeholder="Your Password" required>
            <br><br>
            <button type='submit' class='btn btn-info'>Login User</button>            
        </form>
                            
    <br><hr>
<%@include file="../blocks/footer.jsp" %>