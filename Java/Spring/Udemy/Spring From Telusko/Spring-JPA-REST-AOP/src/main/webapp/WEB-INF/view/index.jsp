<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <!--添加一条 Alien 数据-->
    <h1>Add an Alien: </h1> <br />
    <form action="addAlien" method="post">
        Enter aid: <input type="text" name="aid" /> <br />
        Enter aname: <input type="text" name="aname" /> <br />
        <input type="submit" value="Add" />
    </form>

    <hr />

    <!--根据 id 查询一条数据-->
    <h1>Get an Alien by aid: </h1> <br />
    <form action="getAlien" method="post">
        Enter aid: <input type="text" name="aid" /> <br />
        <input type="submit" value="Query" />
    </form>

    <hr />

    <!-- 根据 id 删除一条数据 -->
    <h1>Delete an Alien by aid: </h1> <br />
    <form action="delAlien" method="post">
        Enter aid: <input type="text" name="aid" /> <br />
        <input type="submit" value="Delete" />
    </form>

    <!-- 根据 name 查询一条数据 -->
    <h1>Get an Alien by aname: </h1> <br />
    <form action="getByName" method="post">
        Enter aname: <input type="text" name="aname" /> <br />
        <input type="submit" value="Query" />
    </form>

    <!--添加一条 Alien 数据, using Spring REST. -->
    <h1>Add an Alien by REST: </h1> <br />
    <form action="alien" method="post">
        Enter aid: <input type="text" name="aid" /> <br />
        Enter aname: <input type="text" name="aname" /> <br />
        <input type="submit" value="Add" />
    </form>
</body>
</html>