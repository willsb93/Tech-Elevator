<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta name="viewport" content="width=device-width" />
<title>National Parks</title>
<link href="https://fonts.googleapis.com/css?family=Libre+Baskerville&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/site.css" />
</head>
<body>
  <c:url var="home" value="/"/>
  <c:url var="survey" value="/survey"/>
<div class="flex-container">
  <h1 class="logo"><a href="${home }">&#127794NATIONAL PARKS</a></h1>
  <ul class="navigation">

    <li><a href="${home }">home</a></li>
    <li><a href="${survey }">survey</a></li>
  </ul>
</div>