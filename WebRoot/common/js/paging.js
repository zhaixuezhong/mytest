
var cpage,count,curcount,outstr; 
//初始化 
cpage = 1; 
outstr = ""; 


function setpage(totalpage) 
{ 	
	outstr="";
    cpage = parseInt(cpage);
    totalpage = parseInt(totalpage);
   		if(cpage>1){
   			outstr = outstr + '<span class="l_prev" onclick="gotopage('+(cpage-1)+')"></span>'; 
   			}else{
   				outstr = outstr + '<span class="l_prev"></span>'; 
   			}
   			
    	if(cpage<=1){
	    	outstr = outstr + "<span class='l_pageclice'>1</span>";      
	    }else if(cpage>1){
	   	 	outstr = outstr + "<span> <a href='javascript:void(0)' onclick='gotopage(1)'>1</a> </span>"; 	
	    }
	    if(cpage-2>2){
	  	  outstr = outstr + "<span>...</span>"; 
	    }
	    for (count=cpage-2;count<=cpage+2;count++) 
	    {      
	    	if(count>1 && count<totalpage){   
		       if(count!=cpage) 
		       { 
		         	outstr = outstr + "<span><a href='javascript:void(0)' onclick='gotopage("+count+")'>"+count+"</a> </span>"; 
		        }else{ 
		          	outstr = outstr + "<span class='l_pageclice'>"+count+"</span>"; 
		        } 
	        }
	    } 
	    if(cpage+2<totalpage-1){
	    	outstr = outstr + "<span>...</span>"; 
	    }
	   if(totalpage>1){
		   if(totalpage<=cpage){
		   		 outstr = outstr + "<span class='l_pageclice'>"+totalpage+"</span>";       
		  		outstr = outstr + '<span class="l_next"></span> ';  
		    }else{
		   		outstr = outstr + "<span><a href='javascript:void(0)' onclick='gotopage("+(totalpage)+")'>"+totalpage+" </a></span>";       
		    	outstr = outstr + '<span class="l_next"  onclick="gotopage('+(cpage+1)+')"></span>'; 
		    }
    	}else{
    	 	outstr = outstr + '<span class="l_next"></span> ';  
    	 }
    if(document.getElementById("setPageIn")){
    	document.getElementById("setPageIn").innerHTML = "<div id='setpage' class='l_page'>"+ outstr + "<span class='now_page'>第"+cpage+"页<\/span><\/div>"; 
    }
    outstr = ""; 
}

