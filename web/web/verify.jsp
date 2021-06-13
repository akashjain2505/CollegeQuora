<%@include file="../blocks/header.jsp" %>
                    
<div class="tm-right-column">
    <figure>
        <img src="<%=ctx%>/assets/img/neaty-01.jpg" alt="Header image" class="img-fluid">    
    </figure>

    <div class="tm-content-div">
                            <!-- Welcome section -->
                            <h1>User Verify</h1>
                            <hr>
                            <form action="<%=ctx%>/verify" method="post">
            <input type="email" class='form-control' name="email" placeholder="Your Email" required>        
            <br>
            <input type="password" class='form-control' name="otp" placeholder="Your OTP" required>
            <br><br>
            <button type='submit' class='btn btn-info'>Verify User</button>            
        </form>
                            
    <br><hr>
<%@include file="../blocks/footer.jsp" %>