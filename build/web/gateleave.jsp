<%-- 
    Document   : gateleave
    Created on : Nov 21, 2018, 11:52:31 PM
    Author     : Abc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
    body {
margin:0;
background-color:grey;}
    .rightdiv{
background-color:white;
/*background: linear-gradient(to bottom,  lightcyan 0%,#f6f6f6 100%);*/
float:right;
width:200px;
height:600px;
}
.lftdiv{
width:200PX;
height:600px;
background-color:white;
float:left;
/*background: linear-gradient(to bottom,  lightcyan 0%,#f6f6f6 100%);*/
}
.navbar {  
  overflow: hidden;
/*  background-color: #333;*/
background: linear-gradient(to left,  #333 0%,#f6f6f6 100%);
  position: fixed;
  top: 0;
  width: 100%;
  border-bottom: 2px solid Lightcyan;
}

.navbar a {
  font-family:Lucida Console;
  float: right;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 20px;
  text-decoration: none;
  font-size: 20px;
}

.navbar a:hover{
  background: red;
  color: black;
  opacity: 0.5;
}

.butt {

background-color:blue;
float:right;
}

.navbar a.active {
  background-color: lightcyan;
  color: black;
}
.navbar a.active1 {
    background: linear-gradient(to right,  #9c9e9f 0%,#f6f6f6 100%);
  background-color: white;
  color: black;
}
.theory{
    
    height: 1000px;
        width:70%;
        background-color: white;
        margin-left: 100px;
}
.gate{
    height: 300px;
    width:100%;
     background: linear-gradient(to right,  #9c9e9f 0%,#f6f6f6 100%);
}
.headgate{
    height: 30px;
    width: 100%;
     background: linear-gradient(to right,  #9c9e9f 0%,red 100%);
     font-family: Courier new;
     font-size: 25px;
     color:white;
}
.tabform{
    align:center;
}
</style>

<title>College Application Approval</title>
</head>
<body>
<div class="navbar">
<div class="butt">
    <a href="LogOutServlet" >Log out</a></div>
   <a href="CONTACT.jsp">Contact</a>
   <a href="STATUS.jsp">Status</a>
   <a href="ABOUTUS.jsp">About Us</a>
   <a href="HOMEPAGE.jsp" class="active">Home</a>  
   <a href="HOMEPAGE.jsp" class="active1" style="float:left;">College Appliation Approval</a></div>
<br><br><br>
<div class="lftdiv"></div>
<div class="rightdiv"></div>
   <div class="gate">
       <div class="headgate">
           Gate Pass:
       </div>
       <form action="gateleave" method="get">
           <table class="tabform">
               <tr><td>DATE</td><td> :</td><td><p>
                           <script> document.write(new Date().toLocaleDateString()); </script>
                       </p></td></tr>
               <tr><td>Name</td><td>:</td><td><input type="text" name="name"></td></tr>
               
               <tr><td>Leave Required From </td><td>:</td><td><input type="datetime-local" name="sdate"></td></tr>
               <tr><td>To </td><td>:</td><td><input type="datetime-local" name="edate"></td></tr>
               <tr><td>Leave Required Reason </td>
                   <td>:</td><td><textarea rows="4" cols="50" placeholder="write valid reason" name="reason"></textarea></td></tr>
               <tr><td></td><td><input type="reset" value="Reset">
  <input type="submit" value="Submit"></td><td></td></tr>       
           </table>
       </form>
   </div>
   
   </body>
</html>
