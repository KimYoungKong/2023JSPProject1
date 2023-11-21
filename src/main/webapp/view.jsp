<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="com.example.dao.BoardDAO, com.example.bean.BoardVO"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Post</title>
</head>
<body>

<%
    // 파라미터로 전달된 게시글 ID를 가져옴
    String postId = request.getParameter("id");

    if (postId != null && !postId.isEmpty()) {
        // ID를 이용하여 해당 게시글 정보를 가져옴
        int postIdInt = Integer.parseInt(postId);
        BoardDAO boardDAO = new BoardDAO();
        BoardVO post = boardDAO.getPost(postIdInt);

        // 게시글이 존재하는 경우에만 내용을 표시
        if (post != null) {
%>
<h1>View Post</h1>
<table>
    <tr><td>ID:</td><td><%= post.getSeq() %></td></tr>
    <tr><td>Title:</td><td><%= post.getTitle() %></td></tr>
    <tr><td>Writer:</td><td><%= post.getWriter() %></td></tr>
    <tr><td>Content:</td><td><%= post.getContent() %></td></tr>
    <tr><td>Regdate:</td><td><%= post.getRegdate() %></td></tr>
</table>
<%
} else {
%>
<p>게시글이 존재하지 않습니다.</p>
<%
    }
} else {
%>
<p>게시글 ID가 전달되지 않았습니다.</p>
<%
    }
%>

</body>
</html>
