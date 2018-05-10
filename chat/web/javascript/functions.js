function addMessage(){
  if(window.XMLHttpRequest) { //Assuming you're not on one of the old IEs.
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange=function() {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var myArr = JSON.parse(xhttp.responseText);

        }
    }
    xhttp.open("POST","messageServlet",true);
    var formData = new FormData(document.getElementById('messageForm'));
    xhttp.send(formData);
  }
  else console.log('not working');
}

function addFriend(){
  if(window.XMLHttpRequest) { //Assuming you're not on one of the old IEs.
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange=function() {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var myArr = JSON.parse(xhttp.responseText);

        }
    }
    xhttp.open("POST","addFriend",true);
    var formData = new FormData(document.getElementById('searchForm'));
    xhttp.send(formData);
  }
  else console.log('not working');
}

// from json to js
var text = '{"employees":[' +
'{"firstName":"John","lastName":"Doe" },' +
'{"firstName":"Anna","lastName":"Smith" },' +
'{"firstName":"Peter","lastName":"Jones" }]}';

obj = JSON.parse(text);
document.getElementById("demo").innerHTML =
obj.employees[2].firstName + " " + obj.employees[1].lastName;

//get json from servlet

/*
 * from servlet to js
 * 
    List<Product> products = productDAO.list(); 
    String json = new Gson().toJson(products);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);
 * 
    String data = "Hello World!";
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(data); 
 
 */
$.getJSON('myservlet', function(data) {
    var table = $('<table>').appendTo($('#data'));
    $.each(data, function(i, product) {
        var row = $('<tr>').appendTo(table);
        $('<td>').text(product.id).appendTo(row);
        $('<td>').text(product.name).appendTo(row);
        $('<td>').text(product.description).appendTo(row);
    });
});

/*
  $.get('myservlet', function(data) {
        alert(data);
    });
 */