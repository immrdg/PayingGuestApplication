<%--
  Created by IntelliJ IDEA.
  User: immrdg
  Date: 03/02/24
  Time: 10:19 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script
        type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.1.0/mdb.umd.min.js"
></script>
<link
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
        rel="stylesheet"
/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
    function redirectTo(path) {
        // Construct the new URL by appending the provided path
        // Change the URL and refresh the page
        window.location.href = window.location.origin + '/' + path;
    }
    function closeError(){
        $('#error').css('display', 'none');
    }
</script>