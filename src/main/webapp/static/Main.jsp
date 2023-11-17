<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script>
        $(document).on("click", "#somebutton", function() {
            $.get("someservlet", function(responseText) {
                $("#somediv").text(responseText);
            });
        });
    </script>
</head>
<body>
    <h3>Menu</h3>
    <form action="http://localhost:8080/JspApi_war/directors">
        <input type="submit" value="Show directors" />
    </form>
    <form action="http://localhost:8080/JspApi_war/actors">
        <input type="submit" value="Show actors" />
    </form>
    <form action="http://localhost:8080/JspApi_war/actors-directors">
        <input type="submit" value="Show actors and directors" />
    </form>
    <form action="http://localhost:8080/JspApi_war/films">
        <input type="submit" value="Show films" />
    </form>
    Enter years: <input type="text" id="year" value="2021">
    <form>
        <input type="submit" value="Show films" />
    </form>
</body>
</html>