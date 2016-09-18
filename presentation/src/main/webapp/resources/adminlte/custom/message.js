/**
 * 
 */


$(document).ready(function(){
	$('#msgNotification').click(function(){ 
		  alert("Please wait we are showing msg"); 
		  $.ajax({
				url : 'messages',
				type:'GET',
					success : function(data) {
		            $.each(data, function (index, article) {
		            	 
		                var td_categories = $("#msgMenu");
		                $.each(article.categories, function (i, tag) {
		                    //var span = $("<span class='label label-info' style='margin:4px;padding:4px' />");
		                	var li = $("<li><a href='#'><div class='pull-left'>");
		                	
		                	span.text(tag);
		                    td_categories.append(span);
		                });
		 
		                var td_tags = $("<td/>");
		                $.each(article.tags, function (i, tag) {
		                    var span = $("<span class='label' style='margin:4px;padding:4px' />");
		                    span.text(tag);
		                    td_tags.append(span);
		                });
		 
		                $("#added-articles").append($('<tr/>')
		                        .append($('<td/>').html("<a href='"+article.url+"'>"+article.title+"</a>"))
		                        .append(td_categories)
		                        .append(td_tags)
		                );
		 
		            }); 
				}
			});
		
		});
});