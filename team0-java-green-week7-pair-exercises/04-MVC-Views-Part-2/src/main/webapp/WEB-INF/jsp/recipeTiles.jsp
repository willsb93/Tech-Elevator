<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Recipe List View</title>
    <link rel="stylesheet" href="css/site.css" />
</head>
<body>
    <header>
        <h1>MVC Exercises - Views Part 2: Models</h1>        
    </header>
    <nav>
        <ul>
            <li><a href="recipeTiles">Tile Layout</a></li>
            <li><a href="recipeTable">Table Layout</a></li>
        </ul>
        
    </nav>
    <section id="main-content">

       <!-- Use the request attribute "recipes" (List<Recipe>) -->
 <h1 class = "Recipes"> Recipes</h1>
 
 <c:forEach var ="recipe" items = "${recipes}">
 "${recipe.name}"
 
 <c:forEach var = "rating" items ="${ }"
 ${recipe.averageRating}
 ${recipe.ingredients.size()}
 
 
 </c:forEach>

    </section>
</body>
</html>