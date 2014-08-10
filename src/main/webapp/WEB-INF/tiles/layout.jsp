<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>
        <tiles:insertAttribute name="title" ignore="true"/>
    </title>

    <tiles:insertAttribute name="meta"/>
</head>

<body>

<div id="wrapper">
    <tiles:insertAttribute name="header"/>

    <tiles:insertAttribute name="navigation"/>

    <div id="page">
        <div id="content">
            <tiles:insertAttribute name="body"/>
        </div>
        <!-- end #content -->
    </div>
</div>
<!-- end #wraper -->
<tiles:insertAttribute name="footer"/>
</body>
</html>
