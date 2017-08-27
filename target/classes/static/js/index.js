/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function myFunction(p1, p2) {
    return p1 * p2;              // The function returns the product of p1 and p2
}

function introNew(obj){
    $('#new_'+obj).show();
    $('#new_element').prop('disabled', true);
    
}

function cancelNew(obj){
    $('#new_'+obj).hide();
    $('#new_element').prop('disabled', false);
}

$('form[id=newCostForm]').submit(function(event){

	event.preventDefault();
	var amount = $(this).find("input[name='amount']").val()
	$(this).find("input[name='amount']").val(amount.replace(',','.'));
	console.log("submitting newCostForm");
	$.ajax({
			method: "POST",
			url: "/newCost",
			data: $(this).serialize(),		
			error: function(xhr,error){
		   	console.log("error on ajax call: "+xhr);
		   },
		   success:function(response){
		   	console.log(response);
		   		if(response>0){
		   			location.reload();
		   		}else{
		   			alert("Error al crear el nuevo gasto.")
		   		}
		   	
		   }
		   
		   
	});
	

});

$('#newComerce').click(function(){

});

function introNew(obj){
    $('#new_'+obj).show();
    $('#new_element').prop('disabled', true);
    
}

$('form[id=newCommerce]').submit(function(event){

	event.preventDefault();
	var amount = $(this).find("input[name='amount']").val()
	$(this).find("input[name='amount']").val(amount.replace(',','.'));
	console.log("submitting newCostForm");
	$.ajax({
			method: "POST",
			url: "/newCost",
			data: $(this).serialize(),		
			error: function(xhr,error){
		   	console.log("error on ajax call: "+xhr);
		   },
		   success:function(response){
		   	console.log(response);
		   		if(response>0){
		   			location.reload();
		   		}else{
		   			alert("Error al crear el nuevo gasto.")
		   		}
		   	
		   }
		   
		   
	});
	

});

