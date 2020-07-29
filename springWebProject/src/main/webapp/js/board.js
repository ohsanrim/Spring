function checkBoardWriteForm(){
	document.boardForm.submit();
}
function checkListForm(){
	location.href="../board/boardList.do?pg=1";
}


function boardPaging(pg){
	var keyword=document.listForm.keyword.value;
	var searchOption=document.listForm.searchOption.value;
	if(keyword==""){
		location.href="boardList.do?pg="+encodeURI(pg);
	} else {
		location.href="boardSearch.do?pg="+﻿encodeURI(pg)+"&keyword="+encodeURI(keyword)+"&searchOption="+encodeURI(searchOption);
	}
}
