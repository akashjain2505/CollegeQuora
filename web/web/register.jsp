<%@include file="../blocks/header.jsp" %>

<%
    String msg = "";
    String res = request.getParameter("res");
    if(res!=null && res.equals("true"))
    {
        msg = "Register Successfully !";
    }
    if(res!=null && res.equals("false"))
    {
        msg = "Register Failed !";
    }
%>

<script>
        function validate()
        {
            var pass = document.getElementById('pass').value;
            var cpass = document.getElementById('cpass').value;
            if(pass==cpass)
                return true;
            else{
                alert('Password Not Match !');
                return false;
            }    
        }
    </script>
<div class="tm-right-column">
    <figure>
        <img src="<%=ctx%>/assets/img/neaty-01.jpg" alt="Header image" class="img-fluid">    
    </figure>

    <div class="tm-content-div">
                         
    <h1>Register User</h1>
    <hr>
    
    <form action="<%=ctx%>/saveuser" method="POST">
        <input type="text" class='form-control' name="uname" placeholder="Your Name" required>
        <br>
        <input type="email" class='form-control' name="email" placeholder="Your Email" required>        
        <br>
        <input type="password" class='form-control' id="pass" name="pass" placeholder="Your Password" required>
        <br>
        <input type="password" class='form-control' id="cpass" placeholder="Confirm Password" required>
        <br>
        <select name='branch' class='form-control' required>
            <option value=''>Choose Branch</option>
            <option value='1'>Computer Science</option>
            <option value='2'>Information Technology</option>
            <option value='3'>Mechanical</option>
        </select>
        <br>
        <select name='type' class='form-control' required>
            <option value=''>Choose Type</option>
            <option value='1'>Faculty</option>
            <option value='2'>Student</option>            
        </select>
        <br><br>
        <button type='submit' onclick="return validate()" class='btn btn-info'>Save User</button>
        &nbsp;
        <b class='text-danger'><%=msg%></b>
    </form>
    <br><hr>
<%@include file="../blocks/footer.jsp" %>
