<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- footer -->
<footer>
	
	<div id="footer_middle">Fine is optimized for learning and
		training. Examples might be simplified to improve reading and
		learning. Tutorials, references, and examples are constantly reviewed
		to avoid errors, but we cannot warrant full correctness of all
		content. While using W3Schools, you agree to have read and accepted
		our terms of use, cookie and privacy policy.</div>
	<div id="footer_bottom">
		<address>Copyright 1999-2020 by Refsnes Data. All Rights
			Reserved. W3Schools is Powered by W3.CSS.</address>
	</div>
</footer>
<!-- jQuery -->
<script>
	jQuery(document).ready(function() {
		$(".nav_li").click(function() {
			$(".drop_menu").slideToggle("slow");
		});
	});
</script>
