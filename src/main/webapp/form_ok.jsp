<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Submission Result</title>
</head>
<body>
<h1>입력 정보 확인</h1>

<%-- Retrieve form data from request --%>
<% String name = request.getParameter("name"); %>
<% String password = request.getParameter("password"); %>
<% String phone = request.getParameter("phone"); %>
<% String gender = request.getParameter("gender"); %>
<% String birthdate = request.getParameter("birthdate"); %>
<% String email = request.getParameter("email"); %>
<% String address = request.getParameter("address"); %>
<% String[] hobbies = request.getParameterValues("hobby"); %>
<% String color = request.getParameter("color"); %>
<% String car = request.getParameter("car"); %>

<%-- Display submitted data --%>
<p><strong>이름:</strong> <%= name %></p>
<p><strong>비밀번호:</strong> <%= password %></p>
<p><strong>핸드폰 번호:</strong> <%= phone %></p>
<p><strong>성별:</strong> <%= gender %></p>
<p><strong>생년월일:</strong> <%= birthdate %></p>
<p><strong>이메일:</strong> <%= email %></p>
<p><strong>주소:</strong> <%= address %></p>

<p><strong>취미:</strong> <%= Arrays.toString(hobbies) %></p>

<p><strong>좋아하는 색상:</strong> <%= color %></p>
<p><strong>좋아하는 자동차 브랜드:</strong> <%= car %></p>

<p>입력이 정상적으로 처리되었습니다.</p>
</body>
</html>
