/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function createElement(usr){
    var nameSurname = $("<li>").html(usr.name+" "+usr.surname);
    var link = $("<a>")
            .attr("href", "Bacheca?user="+usr.id)
            .html(nameSurname);
    
    var userData = $("<div>")
            .attr("class","userData")
            .append(link);
    
    
    return userData;
}

function stateSuccess(data){
    var userListPage = $("#userFriends > ul");
    var UserNotFound = "Nessun utente<br>corrisponde alla ricerca.";
    
    $(userListPage).empty();
    if(!data[0].name) {
        $(userListPage).html(UserNotFound);
    }
    else {
        for(var instance in data){
            $(userListPage).append(createElement(data[instance]));
        }
    }
}
function stateFailure(data, state){
    console.log(state);
}

$(document).ready(function(){
    $("#searchFriend").on("input", function() {
        
        var wantedUser = $("#searchFriend")[0].value;
        
        $.ajax({
            url: "filter.json",
            data:{
                q:"search",
                nomeUtenteCercato: wantedUser
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data);
            },
            error: function(data, state){
                stateFailure(data, state);
            }
        });
    });
});

$(document).ready(function(){
    $("#searchButton").click(function() {
        
        var wantedUser = $("#searchFriend")[0].value;
        
        $.ajax({
            url: "filter.json",
            data:{
                cmd:"search",
                nomeUtenteCercato: wantedUser
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data);
            },
            error: function(data, state){
                stateFailure(data, state);
            }
        });
    });
});