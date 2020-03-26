<template>
    <div class ='shopping-list'>
        <h2> Shopping List </h2>
        <ul>
            <li> TOILET PAPER </li>
            <li> TOILET PAPER </li>
            <li> TOILET PAPER </li>
            <li> TOILET PAPER </li>
            <li> TOILET PAPER </li>
            <li> TOILET PAPER </li>
            <li> TOILET PAPER </li>
            <li> TOILET PAPER </li>
            <li> butter </li>
            <li class ='completed'> pizza </li>
            <li class ='completed'> beer </li>
            <li class ='completed'> paper towels (if it comes to that) </li>
        </ul>
    </div>  
</template>

<script>
export default {

}
</script>

<style>
.shopping-list {
    width:450px;
    background: #fff;
    margin: 50px auto;
    font-family: 'Roboto Condensed', sans-serif;
    border-radius: 10px;
}
h1 {
    background:#f2f2f2;
    color:#5c8578;
    padding:10px;
    font-size:24px;
    text-transform: uppercase;
    text-align: center;
    margin-bottom: 0px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
}
ul {
    list-style-type: none;
    margin:0px;
    padding:0px;
}
li {
    font-size: 24px;
    border-bottom:1px solid #f2f2f2;
    padding:10px 20px;
}
li:last-child{
    border:0px;
}
li.completed {
    text-decoration: line-through;
    color:darkgrey;
}
</style>
