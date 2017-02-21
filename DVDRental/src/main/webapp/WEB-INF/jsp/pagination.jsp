<html>

<body>
	<div class="pagination" ></div>
</body>
<script type="text/javascript">
	$(function() {
	    $(".pagination").pagination({
	        items: 100,
	        itemsOnPage: 10,
	        cssStyle: 'compact-theme',
	        onPageClick: function(pageNumber) {
	        			alert("hello : " + pageNumber);
	       		 }
	    });
	});
</script>

</html>