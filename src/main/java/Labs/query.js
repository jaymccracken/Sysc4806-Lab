
function send(){
    var a = document.forms["form"]["name"].value;
    var b = document.forms["form"]["phonenumber"].value;
    var display=document.getElementById("display")
    const newContent = document.createTextNode("Name: " + a + " PhoneNumber: " + b + "");
    display.appendChild(newContent);
    display.appendChild(document.createElement("br"));
    return false;
}