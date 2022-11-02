<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Mail-Home</title>
</head>
<script type="text/javascript">
var listOfUser;



function displayCompose(){
	document.getElementById("composeForm").style.display ='block';
	listOfUser = '${listOfMailID}'
		var temp = listOfUser.replace("[","");
		temp = temp.replace("]","");
		temp = temp.split(" ").join("");
		listOfUser = temp.split(",");
		//console.log(listOfUser);
	//findAlluser();
}

function cancelCompose(){
	document.getElementById("composeForm").style.display ='none';
}

function messageSend(){
	var form = document.getElementById("composeForm");
	var isExist = false;
	console.log(listOfUser.length);
	//console.log(typeof form.elements[1].value);
	for(var i =0;i<listOfUser.length;i++){
		//console.log(typeof listOfUser[i]);
		
		if(listOfUser[i] == form.elements[1].value)
		{
			isExist = true;
			form.submit();
			break;
		}else{
			continue;
			}
	}
	if(!isExist){
		window.alert("Invalid id");
	}
}
function getSentMessages(){
	var listOfSentMsg = '${sentMsgs}';
	console.log(typeof listOfSentMsg);
	var temp = listOfSentMsg.replace("[","");
	temp = temp.replace("]","");
	//temp = temp.replace(" ","");
	listOfSentMsg = temp.split(",");
	console.log(listOfSentMsg);

	var LIST = document.getElementById("messageList");
	LIST.style.visibility = "visible";
	LIST.innerHTML = "";
	if(listOfSentMsg[0]!=""){
	for(var i =0;i<listOfSentMsg.length;++i){
		var temp = listOfSentMsg[i].split("-");
		LIST.innerHTML += '<li>'+temp[0]+"<ul><li>"+temp[1]+"</li></ul>"+'</li>';
	}
	}else{
		window.alert("No messages :(");
		}
}
function getRecievedMessages(){
	var listOfRecvMsg = '${recvdMsgs}';
	console.log(typeof listOfRecvMsg);
	var temp = listOfRecvMsg.replace("[","");
	temp = temp.replace("]","");
	//temp = temp.replace(" ","");
	listOfRecvMsg = temp.split(",");
	console.log(listOfRecvMsg);

	var LIST = document.getElementById("messageList");
	LIST.style.visibility = "visible";
	LIST.innerHTML = "";
	if(listOfRecvMsg[0]!=""){
	for(var i =0;i<listOfRecvMsg.length;++i){
		var temp = listOfRecvMsg[i].split("-");
		LIST.innerHTML += '<li>'+temp[0]+"<ul><li>"+temp[1]+"</li></ul>"+'</li>';
		}
	}else{
		window.alert("No messages :(");
		}
	
}

</script>
<body>
Welcome ${name} :)
<br>

<form action="send" id="composeForm" style="display:none" method="post">
<table>
	<tr>
	<td>
	From:
	</td>
	<td>
	<input type="text" name="senderId" value= ${sender} readonly>
	</td>
	</tr>
	<tr>
	<td>
	To:
	</td>
	<td>
	<input type="text" name="recieverId" pattern="[a-zA-Z]+[a-zA-Z0-9]+@myMail.com" required="required">${invalidRecieverID}
	</td>
	</tr>
	</table>
	<textarea rows="10" cols="50" placeholder="Type your message here..." name="message"></textarea><br>
	<input type="button" value="Send" onclick="messageSend()">
	<input type="button" value="Cancel" onclick="cancelCompose()">
</form>

<button onclick="displayCompose()">Compose</button><br>
<button onclick="getSentMessages()">Sent messages</button>
<button onclick="getRecievedMessages()">Recieved messages</button><br>
</form>

<div style="visibility: hidden">
<ul id="messageList">
</ul>
</div>

<a href="/logout">Logout</a>
</body>
</html>