<%@include file="../blocks/studheader.jsp" %>
                    
<div class="tm-right-column">
    <figure>
        <img src="<%=ctx%>/assets/img/neaty-01.jpg" alt="Header image" class="img-fluid">    
    </figure>

    <div class="tm-content-div">
                            <!-- Welcome section -->
                            <h1>Change Password</h1>
                            <hr>
        <form action="<%=ctx%>/changepass" method="post">
            <input type="password" class='form-control' name="oldpass" placeholder="Old Password" required>
            <br>
            <input type="password" class='form-control' name="newpass" placeholder="New Password" required>
            <br><br>
            <button type='submit' class='btn btn-info'>Change It</button>            
        </form>
                            
    <br><hr>
<%@include file="../blocks/footer.jsp" %>