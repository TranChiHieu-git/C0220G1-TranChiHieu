<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sanwich condiments</title>
  </head>
  <body>
  <h1>Sanwich condiments</h1>
  <form action="/condiment" >
    <table>
      <tr>
        <td><input type="checkbox" value="Lettuce" name="giavi">Lettuce</td>
        <td><input type="checkbox" value="Tomato" name="giavi">Tomato</td>
        <td><input type="checkbox" value="Mustard" name="giavi">Mustard</td>
        <td><input type="checkbox" value="Sprouts" name="giavi">Sprouts</td>
      </tr>
    </table>
    <hr width="310" style="position: absolute;left: 10px"><br>
    <input type="submit" value="Save">
  </form>
  </body>
</html>
